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
        public string connectionString = g.ConnectionString();
        DataTable tableCitas, tableCitasView, tableDates;
        MySqlDataAdapter adapterC, adapterCV, adapterD;

        private void PCitas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query1 = 
                "SELECT CT.ID, Fecha_Hora, M.Especie, M.Nombre, Motivo " +
                "FROM citas CT JOIN clientes CL ON CT.Cliente=CL.ID " +
                "JOIN mascotas M ON CT.Mascota=M.ID";
            tableCitasView = new DataTable();
            adapterCV = new MySqlDataAdapter(query1, connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapterCV);
            adapterCV.Fill(tableCitasView);
            dataGridView1.DataSource = tableCitasView;
            dataGridView1.Columns["ID"].Visible = false;

            

            string query2 = "SELECT * FROM citas";
            tableCitas = new DataTable();
            MySqlDataAdapter adapter2 = new MySqlDataAdapter(query2, connection);
            MySqlCommandBuilder commandBuilder2 = new MySqlCommandBuilder(adapter2);
            adapter2.Fill(tableCitas);


            string query3 = "SELECT Fecha_Hora FROM citas";
            tableDates = new DataTable();
            adapterD = new MySqlDataAdapter(query3, connection);
            MySqlCommandBuilder commandBuilder1 = new MySqlCommandBuilder(adapterD);
            adapterD.Fill(tableDates);
            for (int i= 0; i < tableDates.Rows.Count; i++)
            {
                monthCalendar1.AddBoldedDate(DateTime.Parse(tableDates.Rows[i][0].ToString()));
            }
            monthCalendar1.Refresh();
            monthCalendar1.UpdateBoldedDates();

            connection.Close();
        }

        private void nuevaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAddCitas pAdd = new PAddCitas{ Text = "Crear Cita" };
            pAdd.dateTimePicker1.Value = DateTime.Now;
            pAdd.dateTimePicker2.Value = DateTime.Now;
            if (pAdd.ShowDialog() == DialogResult.OK)
            {
                //
            }
        }

        private void alterarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PAddCitas pMod = new PAddCitas{ Text = "Alterar Cita" };
                //pMod.comboBoxClients.Text =  
                //pMod.comboBoxPets.Text =  
                pMod.dateTimePicker1.Value = DateTime.Now;
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    //
                }
            }
        }

        private void eliminarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                if (g.ShowWarning("Borrar cliente", "¿Seguro que quieres borrar este cliente?") == DialogResult.OK)
                {
                    try
                    {
                        dataGridView1.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        adapterCV.Update(tableCitasView);
                        tableCitas.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        adapterC.Update(tableCitas);
                        tableDates.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        adapterD.Update(tableDates);
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }
    }
}
