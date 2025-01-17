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

namespace ExamenRecuperacion
{
    public partial class PModVentas : Form1
    {
        public PModVentas()
        {
            InitializeComponent();
            textBoxPrice.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckDecimal_KeyPress);
        }

        private void PModVentas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT Codigo, CONCAT (Apellidos,', ',Nombre) As Name FROM Vendedores";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable DT = new DataTable();
            adapter.Fill(DT);
            comboBoxSeller.DataSource = DT;
            comboBoxSeller.ValueMember = "Codigo";
            comboBoxSeller.DisplayMember = "Name";
            connection.Close();
        }

        private void ButtonOk_Click(object sender, EventArgs e)
        {
            if (!String.IsNullOrEmpty(textBoxPrice.Text) ||
                !String.IsNullOrEmpty(comboBoxSeller.Text))
            {
                if (ShowYesNo(Text, "¿Son los datos correctos?") == DialogResult.Yes)
                { this.DialogResult = DialogResult.OK; }
                else
                { this.DialogResult = DialogResult.None; }
            }
            else
            {
                this.DialogResult = DialogResult.None;
                ShowError(this.Text, "Debes rellenar todos los campos");
            }
        }

        private void ButtonCancel_Click(object sender, EventArgs e)
        {
            if (ShowYesNo(Text, "¿Estás seguro de que quieres salir?") == DialogResult.Yes)
            { this.Close(); }
            else
            { this.DialogResult = DialogResult.None; }
        }
    }
}
