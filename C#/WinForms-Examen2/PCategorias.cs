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

namespace WinForms_Examen2
{
    public partial class PCategorias : Form
    {
        public PCategorias()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

        private void PCategorias_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT * FROM familias";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable tableFamilias = new DataTable();
            adapter.Fill(tableFamilias);
            dataGridView1.DataSource = tableFamilias;
            dataGridView1.Columns["Codigo"].Visible = false;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            connection.Close();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                listBox1.Items.Clear();
                string id = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();

                string query = "SELECT * FROM articulos WHERE CodFamilia=@cod";
                MySqlCommand command = new MySqlCommand(query, connection);
                command.Parameters.AddWithValue("@cod", id);
                MySqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    listBox1.Items.Add(reader["Descripcion"]);
                }
                
                connection.Close();
            }
        }
    }
}
