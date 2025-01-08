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
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            connection.Close();
        }

        private void DataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
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

                double total = 0;
                double sum = 0;
                while (reader.Read())
                {
                    listBox1.Items.Add(reader["Descripcion"].ToString());
                    total++;
                    sum += double.Parse(reader["Precio"].ToString());
                }
                labelTotal.Text = total.ToString();
                labelAvg.Text = (sum / total).ToString();
                
                connection.Close();
            }
        }

        private void ListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listBox1.SelectedItems.Count > 0)
            {
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                richTextBox1.Text = "";
                string id = listBox1.SelectedItems[0].ToString().Split('-')[0];

                string query = "SELECT Descripcion, Precio FROM articulos WHERE Codigo=@cod";
                MySqlCommand command = new MySqlCommand(query, connection);
                command.Parameters.AddWithValue("@cod", id);
                MySqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.Text = reader["Descripcion"].ToString() + " -> " + reader["Precio"].ToString() + "€";
                }

                connection.Close();
            }
        }
    }
}
