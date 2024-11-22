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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace WinForms_Dataset
{
    public partial class Provincias : Form
    {
        public Provincias()
        {
            InitializeComponent();
        }

        public string connectionString = "Server=localhost;Database=instituto;User ID=root;Password=root;SslMode=none";

        private void Provincias_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            
            string query = "SELECT * FROM provincias";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            DataTable Tprovincias = new DataTable();
            adapter.Fill(Tprovincias);

            comboBox1.DataSource = Tprovincias;
            comboBox1.DisplayMember = "provincia";
            comboBox1.ValueMember = "id";
            


            connection.Close();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string idProv = comboBox1.SelectedIndex.ToString();

            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT id, municipio FROM municipios WHERE provincia=" + idProv;
            
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            DataTable Tmunicipios = new DataTable();
            adapter.Fill(Tmunicipios);
            comboBox2.DataSource = Tmunicipios;
            comboBox2.DisplayMember = "municipio";
            comboBox2.ValueMember = "id";


            connection.Close();
        }
    }
}
