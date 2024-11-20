using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Practica_GestionClinica
{
    public partial class PClientes : Form
    {
        public PClientes()
        {
            InitializeComponent();
        }

        public string connectionString = "Server=localhost;Database=clínica veterinaria;User ID=root;Password=root;SslMode=none";
        public DataTable tableClients;
        public MySqlDataAdapter adapter;

        private void PClientes_Load(object sender, EventArgs e)
        {
            tableClients = new DataTable();
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            adapter = new MySqlDataAdapter("SELECT * FROM clientes", connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableClients);
            dataGridView1.DataSource = tableClients;
            dataGridView1.Columns["ID_CL"].Visible = false;
            dataGridView1.Columns["Observaciones"].Visible = false;
        }
    }
}
