using MySql.Data.MySqlClient;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Database
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public static string connectionString = "Server=localhost;Database=instituto;User ID=root;Password=root;SslMode=none";

        private void Form1_Load(object sender, EventArgs e)
        {
            // 
            // Initial connection
            // 
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            // 
            // Load Alumnos in DataGridView
            // 
            ShowAlumnos();

            // 
            // Load Provincias in ComboBox
            // 
            string query2 = "SELECT DISTINCT Provincia FROM alumnos";
            MySqlCommand comando2 = new MySqlCommand(query2, connection);
            MySqlDataReader reader2 = comando2.ExecuteReader();

            comboBox1.Items.Add("Todas las provincias");
            while (reader2.Read())
            {
                comboBox1.Items.Add(reader2["provincia"]);
            }

            dataGridView1.ClearSelection();

            UpdateAverage();

            reader2.Close();
            connection.Close();
        }

        public void ShowAlumnos()
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT * FROM alumnos";
            MySqlCommand comando = new MySqlCommand(query, connection);
            MySqlDataReader reader = comando.ExecuteReader();

            dataGridView1.Columns.Clear();
            for (var col = 0; col < reader.FieldCount; col++)
            {
                dataGridView1.Columns.Add(reader.GetName(col), reader.GetName(col));
            }
            while (reader.Read())
            {
                object[] newrow = new object[reader.FieldCount];
                for (var cell = 0; cell < reader.FieldCount; cell++)
                {
                    newrow[cell] = reader.GetValue(cell);
                }
                dataGridView1.Rows.Add(newrow);
            }
            reader.Close();
            connection.Close();
        }


        private void ComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                row.Visible = true;
            }
            if (comboBox1.SelectedIndex != 0)
            {
                for (int i = 0; i < dataGridView1.Rows.Count; i++)
                {
                    if (!dataGridView1.Rows[i].Cells[4].Value.Equals(comboBox1.SelectedItem.ToString()))
                    {
                        dataGridView1.Rows[i].Visible = false;
                    }
                }
            }
            UpdateAverage();
        }

        public void UpdateAverage()
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT * FROM alumnos";
            MySqlCommand comando = new MySqlCommand(query, connection);
            MySqlDataReader reader = comando.ExecuteReader();

            double sum = 0.0;
            int total = 0;

            while (reader.Read())
            {
                foreach (DataGridViewRow row in dataGridView1.Rows)
                {
                    if ((int)reader["codigo"] == (int)row.Cells[0].Value && 
                        row.Visible == true)
                    {
                        sum += (double)reader["nota"];
                        total++;
                    }
                }
            }
            toolStripStatusLabel1.Text = (sum / total).ToString();

            reader.Close();
            connection.Close();
        }

        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            var connection = new MySqlConnection(connectionString);
            connection.Open();

            if (dataGridView1.SelectedRows.Count > 0)
            {
                // Define el ID del registro que deseas eliminar
                int idAEliminar = int.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());

                // Crea la consulta SQL
                string sql = "DELETE FROM alumnos WHERE codigo = @id";

                var comando = new MySqlCommand(sql, connection);
                comando.Parameters.AddWithValue("@id", idAEliminar);
                comando.ExecuteNonQuery();

                ShowAlumnos();

                MessageBox.Show("Fila borrada");
            }
            else
            {
                MessageBox.Show("Ninguna fila seleccionada");
            }
            connection.Close();
        }
    }
}
