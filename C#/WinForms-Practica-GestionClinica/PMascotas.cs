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

        private void PMascotas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            Tclients = new DataTable();
            Tpets = new DataTable();
            string query1 = "SELECT ID_CL, Nombre, Apellidos FROM clientes";
            string query2 = "SELECT * FROM mascotas ORDER BY 3, 4";
            adapter1 = new MySqlDataAdapter(query1, connection);
            adapter2 = new MySqlDataAdapter(query2, connection);
            MySqlCommandBuilder commandBuilder1 = new MySqlCommandBuilder(adapter1);
            MySqlCommandBuilder commandBuilder2 = new MySqlCommandBuilder(adapter2);
            adapter1.Fill(Tclients);
            adapter2.Fill(Tpets);
            comboBoxOwners.DataSource = Tclients;
            comboBoxOwners.DisplayMember = "Nombre";
            comboBoxOwners.ValueMember = "ID_CL";
            //comboBoxOwners.Items.Add(0, "Todos los dueños");
            dataGridPets.DataSource = Tpets;
            dataGridPets.Columns["ID_M"].Visible = false;
            dataGridPets.Columns["Cliente"].Visible = false;
            dataGridPets.Columns["Notas"].Visible = false;

            connection.Close();
        }

        private void comboBoxOwners_SelectedIndexChanged(object sender, EventArgs e)
        {
            string indexClient = comboBoxOwners.SelectedValue.ToString();
            dataGridPets.DataSource = Tpets;
            dataGridPets.Columns["ID_M"].Visible = true;
            dataGridPets.Columns["Cliente"].Visible = true;
            dataGridPets.Columns["Notas"].Visible = true;
            foreach (DataGridViewRow row in dataGridPets.Rows)
            {
                if (row.Cells[0].Value.ToString() != null)
                    row.Visible = false;
            }
            foreach (DataGridViewRow row in dataGridPets.Rows)
            {
                if (row.Cells[0].Value.ToString() != null &&
                    row.Cells[0].Value.ToString().Equals(indexClient))
                { row.Visible = true; }
            }
            dataGridPets.Columns["ID_M"].Visible = false;
            dataGridPets.Columns["Cliente"].Visible = false;
            dataGridPets.Columns["Notas"].Visible = false;
        }
    }
}
