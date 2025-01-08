using MySql.Data.MySqlClient;
using Org.BouncyCastle.Pqc.Crypto.Lms;
using System;
using System.Collections;
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
    public partial class PStats : Form
    {
        public PStats()
        {
            InitializeComponent();
            labelListado.Text = "Listado de todos los artículos \n y su precio ordenados por descripción.";
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

        private void PStats_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT * FROM familias";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable tableFamilias = new DataTable();
            adapter.Fill(tableFamilias);
            comboBoxFamily.DataSource = tableFamilias;
            comboBoxFamily.ValueMember = "Codigo";
            comboBoxFamily.DisplayMember = "Descripcion";

            connection.Close();
        }

        private void ComboBoxFamily_SelectedIndexChanged(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string id = comboBoxFamily.SelectedValue.ToString();
            string query1, query2, query3, query4, query5;
            MySqlCommand command;
            MySqlDataReader reader;


            // Número de artículos en stock por familia.
            query1 = "SELECT COUNT(*) FROM articulos WHERE CodFamilia=@cod AND Stock>0";
            command = new MySqlCommand(query1, connection);
            command.Parameters.AddWithValue("@cod", id);
            reader = command.ExecuteReader();
            while (reader.Read())
            {
                labelQuantity.Text = reader["COUNT(*)"].ToString();
            }
            reader.Close();


            // Precio promedio de los artículos por familia.
            query2 = "SELECT AVG(Precio) FROM articulos WHERE CodFamilia=@cod";
            command = new MySqlCommand(query2, connection);
            command.Parameters.AddWithValue("@cod", id);
            reader = command.ExecuteReader();
            while (reader.Read())
            {
                labelAverage.Text = reader["AVG(Precio)"].ToString();
            }
            reader.Close();


            // El artículo más caro y el más barato.
            query3 = "SELECT Descripcion FROM articulos WHERE CodFamilia=@cod AND Precio=( SELECT MAX(Precio) FROM articulos WHERE CodFamilia=@cod )";
            query4 = "SELECT Descripcion FROM articulos WHERE CodFamilia=@cod AND Precio=( SELECT MIN(Precio) FROM articulos WHERE CodFamilia=@cod )";
            command = new MySqlCommand(query3, connection);
            command.Parameters.AddWithValue("@cod", id);
            reader = command.ExecuteReader();
            while (reader.Read())
            {
                labelExpensive.Text = reader["Descripcion"].ToString();
            }
            reader.Close();
            command = new MySqlCommand(query4, connection);
            command.Parameters.AddWithValue("@cod", id);
            reader = command.ExecuteReader();
            while (reader.Read())
            {
                labelCheapest.Text = reader["Descripcion"].ToString();
            }
            reader.Close();


            // Listado de todos los artículos y su precio ordenados por descripción.
            query5 = "SELECT Descripcion, Precio FROM articulos WHERE CodFamilia=@cod ORDER BY 1";
            command = new MySqlCommand(query5, connection);
            command.Parameters.AddWithValue("@cod", id);
            reader = command.ExecuteReader();
            listBox1.Items.Clear();
            while (reader.Read())
            {
                listBox1.Items.Add(reader["Descripcion"].ToString() + ": " + reader["Precio"].ToString() + "€");
            }
            reader.Close();


            connection.Close();
        }
    }
}
