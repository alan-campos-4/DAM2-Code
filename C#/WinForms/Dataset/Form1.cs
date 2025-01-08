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

namespace WinForms_Dataset
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        string connectionString = "Server=localhost;Database=instituto;User ID=root;Password=root;SslMode=none";

        private void Form1_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            DataSet dataSet = new DataSet();
            string query = "SELECT * FROM alumnos";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            adapter.Fill(dataSet, "alumnos");
            dataGridView1.DataSource = dataSet.Tables["Alumnos"];
        }

        private void provinciasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Provincias provincias = new Provincias();
            provincias.ShowDialog();
        }
    }
}
