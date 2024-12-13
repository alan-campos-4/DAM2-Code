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
    public partial class PBuscar : Form
    {
        public PBuscar()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

        private void PBuscar_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            dataGridView1.Rows.Clear();
            string query = "SELECT Codigo, Descripcion FROM articulos";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable tableArticulos = new DataTable();
            adapter.Fill(tableArticulos);
            dataGridView1.DataSource = tableArticulos;
            dataGridView1.Columns["Codigo"].AutoSizeMode = DataGridViewAutoSizeColumnMode.DisplayedCells;
            dataGridView1.Columns["Descripcion"].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;

            connection.Close();
        }

        private void textBoxSearch_TextChanged(object sender, EventArgs e)
        {
            dataGridView1.ClearSelection();
            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                row.Visible = true;
            }
            if (!String.IsNullOrEmpty(textBoxSearch.Text))
            {
                foreach (DataGridViewRow row in dataGridView1.Rows)
                {
                    if (!row.Cells[1].Value.ToString().Contains(textBoxSearch.Text))
                    {
                        CurrencyManager manager1 = (CurrencyManager)BindingContext[dataGridView1.DataSource];
                        manager1.SuspendBinding();
                        row.Visible = false;
                        manager1.ResumeBinding();
                    }
                }
            }

        }
    }
}
