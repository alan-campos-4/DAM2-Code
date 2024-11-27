using MySql.Data.MySqlClient;
using System;
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
        public string connectionString = g.connectionString();

        private void PCitas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT ID_CL, CONCAT(Apellidos, ', ', Nombre) AS Name FROM clientes";
            DataTable tableClients = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableClients);
            listBoxClients.DataSource = tableClients;
            listBoxClients.DisplayMember = "Name";
            listBoxClients.ValueMember = "ID_CL";
            connection.Close();
        }
    }
}
