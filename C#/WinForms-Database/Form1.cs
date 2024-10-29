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

namespace WinForms_Database
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // 
            // Initial connection
            // 
            string connectionString = "Server=localhost;Database=instituto;User ID=root;Password=root;SslMode=none"; ;
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            // 
            // Load Alumnos in DataGridView
            // 
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

            reader2.Close();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
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
        }
    }
}
