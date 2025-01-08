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
    public partial class PAddClientes : Form
    {
        public PAddClientes()
        {
            InitializeComponent();
            this.textBoxDNI.KeyPress += new KeyPressEventHandler(g.CheckValidDNI_KeyPress);
            this.textBoxEmail.KeyPress += new KeyPressEventHandler(g.CheckValidEmail_KeyPress);
            this.textBoxName1.KeyPress += new KeyPressEventHandler(g.CheckOnlyLetters_KeyPress);
            this.textBoxName2.KeyPress += new KeyPressEventHandler(g.CheckOnlyLetters_KeyPress);
            this.comboBoxCity.KeyPress += new KeyPressEventHandler(g.CheckOnlyLetters_KeyPress);
            this.comboBoxProv.KeyPress += new KeyPressEventHandler(g.CheckOnlyLetters_KeyPress);
            this.textBoxPhone.KeyPress += new KeyPressEventHandler(g.CheckOnlyNumbers_KeyPress);
            this.textBoxPostal.KeyPress += new KeyPressEventHandler(g.CheckOnlyNumbers_KeyPress);
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

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

            string idProv = comboBoxProv.SelectedValue.ToString();
            string query = "SELECT id, municipio FROM municipios WHERE provincia = " + idProv;
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            DataTable Tmunicipios = new DataTable();
            adapter.Fill(Tmunicipios);
            comboBoxCity.DataSource = Tmunicipios;
            comboBoxCity.ValueMember = "id";
            comboBoxCity.DisplayMember = "municipio";
            
            comboBoxCity.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDown;
            comboBoxCity.AutoCompleteMode = AutoCompleteMode.SuggestAppend;
            comboBoxCity.AutoCompleteSource = AutoCompleteSource.ListItems;

            connection.Close();
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (FindEmpty())
            {
                g.ShowError("Debes rellenar todos los datos.");
                this.DialogResult = DialogResult.None;
            }
            else if (!g.ContainsCharacterOnce('@', textBoxEmail.Text))
            {
                g.ShowError("La dirección email no es válida.");
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
            if (CheckGroupBox(groupBox1))
                { empty = true; }
            if (CheckGroupBox(groupBox2))
                { empty = true; }
            if (string.IsNullOrEmpty(richTextBox1.Text))
                { empty = true; }
            return empty;
        }

        private bool CheckGroupBox(GroupBox grp)
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
