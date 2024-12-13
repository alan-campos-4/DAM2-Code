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
        }

        public string connectionString = "Server=docarmo.net;Database=examen;User ID=examen;Password=examen;SslMode=none";

        private void PStats_Load(object sender, EventArgs e)
        {
            /*
             Dispondremos de una pantalla de estadísticas donde al seleccionar una familia nos dará información acerca de ésta. Los datos a mostrar serán: (1,5 puntos).
                Número de artículos en stock por familia.
                Precio promedio de los artículos por familia
                Listado de todos los artículos y su precio ordenados por descripción.
                El artículo más caro y el más barato.
             */

            labelListado.Text = "Listado de todos los artículos \n y su precio ordenados por descripción.";

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

        private void comboBoxFamily_SelectedIndexChanged(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string id = comboBoxFamily.SelectedValue.ToString();
            string query1 = "SELECT COUNT(*) FROM articulos WHERE CodFamilia=" + id + ";";
            /*
            DataTable quantity, average, expensive, cheapest;
            MySqlDataAdapter adapter1, adapter2, adapter3, adapter4;

            

            
            adapter1 = new MySqlDataAdapter(query1, connection);
            quantity = new DataTable();
            adapter1.Fill(quantity);

            foreach (DataRow row in quantity.Rows)
            {
                foreach (DataColumn col in quantity.Columns)
                {
                    labelQuantity.Text = row[col].ToString();
                }
            }*/
            MySqlCommand command = new MySqlCommand(query1, connection);
            MySqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                labelQuantity.Text = reader["Codigo"].ToString();
            }
            



            labelAverage.Text = comboBoxFamily.SelectedValue.ToString();




            connection.Close();
        }
    }
}
