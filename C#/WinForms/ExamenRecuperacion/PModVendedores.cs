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
    public partial class PModVendedores : Form1
    {
        public PModVendedores()
        {
            InitializeComponent();
        }

        private void PModVendedores_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT DISTINCT(Provincia) FROM Vendedores";
            var command = new MySqlCommand(query, connection);
            MySqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                comboBoxProvince.Items.Add(reader["Provincia"]);
            }
            connection.Close();
        }

        private void ButtonOk_Click(object sender, EventArgs e)
        {
            if (!String.IsNullOrEmpty(textBoxFName.Text) ||
                !String.IsNullOrEmpty(textBoxLName.Text) ||
                !String.IsNullOrEmpty(comboBoxProvince.Text) ||
                !String.IsNullOrEmpty(textBoxCity.Text) ||
                dateTimePicker1.Value == null)
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
