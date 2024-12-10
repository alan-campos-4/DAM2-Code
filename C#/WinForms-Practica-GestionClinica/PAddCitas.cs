using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.NetworkInformation;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Practica_GestionClinica
{
    public partial class PAddCitas : Form
    {
        public PAddCitas()
        {
            InitializeComponent();
            dateTimePicker2.Format = DateTimePickerFormat.Time;

        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

        private void PCitasAdd_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT ID, CONCAT(Apellidos, ', ', Nombre) AS Name FROM clientes";
            DataTable tableClients = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableClients);
            comboBoxClients.DataSource = tableClients;
            comboBoxClients.ValueMember = "ID";
            comboBoxClients.DisplayMember = "Name";

            connection.Close();
        }

        private void comboBoxClients_SelectedIndexChanged(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            int index = comboBoxClients.SelectedIndex;
            string query = "SELECT ID, CONCAT(Especie, ', ', Nombre) AS Name FROM mascotas WHERE Cliente=" + index;
            DataTable tableClients = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableClients);
            comboBoxClients.DataSource = tableClients;
            comboBoxClients.ValueMember = "ID";
            comboBoxClients.DisplayMember = "Name";

            connection.Close();
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(comboBoxClients.Text) ||
                String.IsNullOrEmpty(comboBoxPets.Text) ||
                String.IsNullOrEmpty(textBoxReason.Text) ||
                String.IsNullOrEmpty(richTextBox1.Text))
            {
                g.ShowError("Debes rellenar todos los campos");
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
            //connection.Close();
        }
    }
}
