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

        public string connectionString = "Server=localhost;Database=clínica veterinaria;User ID=root;Password=root;SslMode=none";
        public DataTable Tclients, Tpets;
        public MySqlDataAdapter adapter1, adapter2;

        private void dataGridPets_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //
        }

        private void añadirToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void PMascotas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            Tclients = new DataTable();
            string query1 = "SELECT ID_CL, CONCAT(Apellidos, ', ', Nombre) AS Name FROM clientes";
            adapter1 = new MySqlDataAdapter(query1, connection);
            MySqlCommandBuilder commandBuilder1 = new MySqlCommandBuilder(adapter1);
            adapter1.Fill(Tclients);
            comboBoxOwners.DataSource = Tclients;
            comboBoxOwners.DisplayMember = "Name";
            comboBoxOwners.ValueMember = "ID_CL";

            Tpets = new DataTable();
            string query2 = "SELECT * FROM mascotas ORDER BY 3, 4";
            adapter2 = new MySqlDataAdapter(query2, connection);
            MySqlCommandBuilder commandBuilder2 = new MySqlCommandBuilder(adapter2); 
            adapter2.Fill(Tpets);
            dataGridPets.DataSource = Tpets;
            dataGridPets.Columns["ID_M"].Visible = false;
            dataGridPets.Columns["Cliente"].Visible = false;
            dataGridPets.Columns["Notas"].Visible = false;

            connection.Close();
        }

        private void comboBoxOwners_SelectedIndexChanged(object sender, EventArgs e)
        {
            dataGridPets.ClearSelection();
            string indexClient = comboBoxOwners.SelectedValue.ToString();

            foreach (DataGridViewRow row in dataGridPets.Rows)
            {
                row.Visible = true;
            }
            foreach (DataGridViewRow row in dataGridPets.Rows)
            {
                if (row.Cells[1].Value.ToString() != null &&
                    !row.Cells[1].Value.ToString().Equals(indexClient))
                {
                    CurrencyManager currencyManager1 = (CurrencyManager)BindingContext[dataGridPets.DataSource];
                    currencyManager1.SuspendBinding();
                    row.Visible = false;
                    currencyManager1.ResumeBinding();
                }
            }
        }
    }
}
