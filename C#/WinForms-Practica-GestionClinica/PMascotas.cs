using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Management;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Practica_GestionClinica
{
    public partial class PMascotas : Form
    {
        public PMascotas()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnectionString();
        public DataTable Tclients, Tpets;
        public MySqlDataAdapter adapter;

        private void PMascotas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            Tpets = new DataTable();
            string query2 = "SELECT M.*, CONCAT(C.Apellidos,', ',C.Nombre) AS Cliente FROM mascotas M " +
                "JOIN clientes C ON M.Cliente=C.ID_CL " +
                "ORDER BY 3, 4";
            adapter = new MySqlDataAdapter(query2, connection);
            MySqlCommandBuilder commandBuilder2 = new MySqlCommandBuilder(adapter);
            adapter.Fill(Tpets);
            dataGridPets.DataSource = Tpets;
            dataGridPets.Columns["ID_M"].Visible = false;
            dataGridPets.Columns["Cliente"].Visible = false;
            dataGridPets.Columns["Notas"].Visible = false;
            dataGridPets.Columns["Cliente"].GetPreferredWidth(DataGridViewAutoSizeColumnMode.AllCells, true);

            connection.Close();
        }

        private void textBoxSearch_TextChanged(object sender, EventArgs e)
        {
            dataGridPets.ClearSelection();
            foreach (DataGridViewRow row in dataGridPets.Rows)
            {
                row.Visible = true;
            }
            if (!String.IsNullOrEmpty(textBoxSearch.Text))
            {
                foreach (DataGridViewRow row in dataGridPets.Rows)
                {
                    if (!row.Cells[8].Value.ToString().Contains(textBoxSearch.Text))
                    {
                        CurrencyManager manager1 = (CurrencyManager)BindingContext[dataGridPets.DataSource];
                        manager1.SuspendBinding();
                        row.Visible = false;
                        manager1.ResumeBinding();
                    }
                }
            }
        }


        private void añadirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAddMascotas pAdd = new PAddMascotas { Text = "Añadir mascota" };
            if (pAdd.ShowDialog() == DialogResult.OK)
            {
                try { 
                    Tpets.Rows.Add(
                        g.GenerateNewID("mascotas"),
                        pAdd.comboBoxOwner.Text,
                        pAdd.textBoxSpecies.Text,
                        pAdd.textBoxBreed,
                        pAdd.textBoxName.Text,
                        pAdd.comboBoxSex.Text,
                        pAdd.richTextBox1.Text
                    );
                    adapter.Update(Tpets);
                }
                catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
            }
        }

        private void modificiarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridPets.SelectedRows.Count > 0)
            {
                PAddMascotas pMod = new PAddMascotas { Text = "Modificar mascota" };
                pMod.comboBoxOwner.Text = dataGridPets.SelectedRows[0].Cells[1].Value.ToString();
                pMod.textBoxSpecies.Text = dataGridPets.SelectedRows[0].Cells[2].Value.ToString();
                pMod.textBoxBreed.Text = dataGridPets.SelectedRows[0].Cells[3].Value.ToString();
                pMod.textBoxName.Text = dataGridPets.SelectedRows[0].Cells[4].Value.ToString();
                pMod.dateTimePicker1.Text = dataGridPets.SelectedRows[0].Cells[5].Value.ToString();
                pMod.comboBoxSex.Text = dataGridPets.SelectedRows[0].Cells[6].Value.ToString();
                pMod.richTextBox1.Text = dataGridPets.SelectedRows[0].Cells[7].Value.ToString();
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    try {
                        dataGridPets.SelectedRows[0].Cells[1].Value = pMod.comboBoxOwner.Text;
                        dataGridPets.SelectedRows[0].Cells[2].Value = pMod.textBoxSpecies.Text;
                        dataGridPets.SelectedRows[0].Cells[3].Value = pMod.textBoxBreed.Text;
                        dataGridPets.SelectedRows[0].Cells[4].Value = pMod.textBoxName.Text;
                        dataGridPets.SelectedRows[0].Cells[5].Value = pMod.dateTimePicker1.Value;
                        dataGridPets.SelectedRows[0].Cells[6].Value = pMod.comboBoxSex.Text;
                        dataGridPets.SelectedRows[0].Cells[7].Value = pMod.richTextBox1.Text;
                        adapter.Update(Tpets);
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridPets.SelectedRows.Count > 0)
            {
                if (g.ShowWarning("Borrar cliente", "¿Seguro que quieres borrar este cliente?") == DialogResult.OK)
                {
                    try
                    {
                        dataGridPets.Rows.RemoveAt(dataGridPets.SelectedRows[0].Index);
                        adapter.Update(Tpets);
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }

    }
}
