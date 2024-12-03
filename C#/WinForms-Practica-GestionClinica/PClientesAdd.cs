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

namespace WinForms_Practica_GestionClinica
{
    public partial class PClientesAdd : Form
    {
        public PClientesAdd()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnectionString();

        private void PClientesAdd_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT * FROM provincias";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            DataTable Tprovincias = new DataTable();
            adapter.Fill(Tprovincias);
            comboBoxProv.DataSource = Tprovincias;
            comboBoxProv.DisplayMember = "provincia";
            comboBoxProv.ValueMember = "id";
            comboBoxProv.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDown;
            comboBoxProv.AutoCompleteMode = AutoCompleteMode.SuggestAppend;
            comboBoxProv.AutoCompleteSource = AutoCompleteSource.ListItems;

            connection.Close();
        }

        private void comboBoxProvince_SelectedIndexChanged(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string idProv = comboBoxProv.SelectedIndex.ToString();
            string query = "SELECT id, municipio FROM municipios WHERE provincia=" + idProv;
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            DataTable Tmunicipios = new DataTable();
            adapter.Fill(Tmunicipios);
            comboBoxCity.DataSource = Tmunicipios;
            comboBoxCity.DisplayMember = "municipio";
            comboBoxCity.ValueMember = "id";
            comboBoxCity.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDown;
            comboBoxCity.AutoCompleteMode = AutoCompleteMode.SuggestAppend;
            comboBoxCity.AutoCompleteSource = AutoCompleteSource.ListItems;

            connection.Close();
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (FindEmpty())
            {
                g.ShowError("Datos", "Debes rellenar todos los datos.");
                this.DialogResult = DialogResult.None;
            }
            else if (g.ShowWarning(this.Text, "¿Son los datos correctos?") == DialogResult.Cancel)
            {
                this.DialogResult = DialogResult.None;
            }
            else
            {
                this.DialogResult = DialogResult.OK;
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private bool FindEmpty()
        {
            bool empty = false;
            if (checkGroupBox(groupBox1))
                { empty = true; }
            if (checkGroupBox(groupBox2))
                { empty = true; }
            if (string.IsNullOrEmpty(richTextBox1.Text))
                { empty = true; }
            return empty;
        }

        private bool checkGroupBox(GroupBox grp)
        {
            bool empty = false;
            foreach (Control ctr in grp.Controls)
            {
                //if (ctr is TextBox || ctr is ComboBox)
                {
                    if (string.IsNullOrEmpty(ctr.Text))
                    {
                        empty = true;
                        break;
                    }
                }
            }
            return empty;
        }
        
    }
}
