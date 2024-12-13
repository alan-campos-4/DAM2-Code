using MySql.Data.MySqlClient;
using MySqlX.XDevAPI.Relational;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Printing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Examen2
{
    public partial class PAlta : Form
    {
        public PAlta()
        {
            InitializeComponent();
            labelCodeRepeatedError.Hide();
            textBoxStock.KeyPress += new KeyPressEventHandler(g.CheckInteger_KeyPress);
            textBoxPrice.KeyPress += new KeyPressEventHandler(g.CheckInteger_KeyPress);
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

        private void PAlta_Load(object sender, EventArgs e)
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

        private void ButtonOK_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBoxCode.Text) ||
                String.IsNullOrEmpty(textBoxDesc.Text) ||
                String.IsNullOrEmpty(textBoxPrice.Text) ||
                String.IsNullOrEmpty(textBoxStock.Text) ||
                String.IsNullOrEmpty(comboBoxFamily.Text) )
            {
                g.ShowError("Debes rellenar todos los campos.");
                this.DialogResult = DialogResult.None;
            }
            else if (int.Parse(textBoxStock.Text) < 0)
            {
                g.ShowError("El stock no puede estar por debajo de 0.");
                this.DialogResult = DialogResult.None;
            }
            else if (this.Text==g.AddTitle && CodigoExiste(int.Parse(textBoxCode.Text)))
            {
                labelCodeRepeatedError.Show();
                this.DialogResult = DialogResult.None;
            }
            else
            {
                labelCodeRepeatedError.Hide();
                this.DialogResult = DialogResult.OK;
            }
        }

        private bool CodigoExiste(int newCode)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT Codigo FROM articulos";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable tableCodigos = new DataTable();
            adapter.Fill(tableCodigos);

            foreach (DataRow row in tableCodigos.Rows)
            {
                foreach (DataColumn col in tableCodigos.Columns)
                {
                    if (row[col].ToString() == textBoxCode.Text)
                        return true;
                }
            }
            connection.Close();
            return false;
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        
    }
}
