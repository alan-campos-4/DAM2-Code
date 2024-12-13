using MySql.Data.MySqlClient;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Practica_GestionClinica
{
    public partial class PCitas : Form
    {
        public PCitas()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();
        DataTable tableCitas;
        MySqlDataAdapter adapterC;

        private void PCitas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query1 = "SELECT * FROM citas";
            tableCitas = new DataTable();
            adapterC = new MySqlDataAdapter(query1, connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapterC);
            adapterC.Fill(tableCitas);
            dataGridView1.DataSource = tableCitas;
            dataGridView1.Columns["ID"].Visible = false;
            dataGridView1.Columns["Cliente"].Visible = false;
            dataGridView1.Columns["Mascota"].Visible = false;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            for (int i= 0; i < tableCitas.Rows.Count; i++)
            {
                DateTime dt = DateTime.Parse(tableCitas.Rows[i][3].ToString());
                monthCalendar1.AddBoldedDate(dt);
            }
            monthCalendar1.UpdateBoldedDates();


            connection.Close();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                string idClient = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                string idPet = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
                string query1 = "SELECT CONCAT(Apellidos,', ',Nombre) AS Name FROM clientes WHERE ID=" + idClient;
                string query2 = "SELECT CONCAT(Especie,' - ',Nombre) AS Name FROM mascotas WHERE ID=" + idPet;
                DataTable table1 = new DataTable();
                DataTable table2 = new DataTable();
                MySqlDataAdapter adapter1 = new MySqlDataAdapter(query1, connection);
                MySqlDataAdapter adapter2 = new MySqlDataAdapter(query2, connection);
                adapter1.Fill(table1);
                adapter2.Fill(table2);

                labelClient.Text = table1.Rows[0][0].ToString();
                labelPet.Text = table2.Rows[0][0].ToString();

                connection.Close();
            }
        }




        private void NuevaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAddCitas pAdd = new PAddCitas{ Text = "Crear Cita" };
            pAdd.dateTimePicker1.Value = DateTime.Now;
            pAdd.dateTimePicker2.Value = DateTime.Now;
            if (pAdd.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    tableCitas.Rows.Add(
                        g.GenerateNewID("citas"),
                        pAdd.comboBoxClients.SelectedValue,
                        pAdd.comboBoxPets.SelectedValue,
                        pAdd.textBoxReason.Text,
                        pAdd.richTextBox1.Text,
                        pAdd.dateTimePicker1.Value
                    );
                    adapterC.Update(tableCitas);
                }
                catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
            }
        }

        private void AlterarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PAddCitas pMod = new PAddCitas{ Text = "Alterar Cita" };
                pMod.comboBoxClients.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                pMod.comboBoxPets.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
                pMod.dateTimePicker1.Text = dataGridView1.SelectedRows[0].Cells[3].Value.ToString();
                pMod.dateTimePicker2.Text = dataGridView1.SelectedRows[0].Cells[4].Value.ToString();
                pMod.textBoxReason.Text = dataGridView1.SelectedRows[0].Cells[5].Value.ToString();
                pMod.richTextBox1.Text = dataGridView1.SelectedRows[0].Cells[6].Value.ToString();
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    try
                    {
                        dataGridView1.SelectedRows[0].Cells[1].Value = pMod.comboBoxClients.Text;
                        dataGridView1.SelectedRows[0].Cells[2].Value = pMod.comboBoxPets.Text;
                        dataGridView1.SelectedRows[0].Cells[3].Value = pMod.dateTimePicker1.Text;
                        dataGridView1.SelectedRows[0].Cells[4].Value = pMod.dateTimePicker2.Text;
                        dataGridView1.SelectedRows[0].Cells[5].Value = pMod.textBoxReason.Text;
                        dataGridView1.SelectedRows[0].Cells[6].Value = pMod.richTextBox1.Text;
                        adapterC.Update(tableCitas);
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
        }

        private void EliminarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                if (g.ShowWarning("Borrar cita", "¿Seguro que quieres borrar esta cita?") == DialogResult.OK)
                {
                    try
                    {
                        dataGridView1.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        adapterC.Update(tableCitas);
                        //tableCitas.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        //adapterC.Update(tableCitas);
                        //tableDates.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        //adapterD.Update(tableDates);
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }
    }
}
