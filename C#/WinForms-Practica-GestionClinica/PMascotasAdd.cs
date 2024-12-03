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
    public partial class PMascotasAdd : Form
    {
        public PMascotasAdd()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnectionString();

        private void PMascotasAdd_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT ID_CL, CONCAT(Apellidos, ', ', Nombre) AS Name FROM clientes";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            DataTable Tduenos = new DataTable();
            adapter.Fill(Tduenos);
            comboBoxOwner.DataSource = Tduenos;
            comboBoxOwner.DisplayMember = "Name";
            comboBoxOwner.ValueMember = "ID_CL";
            comboBoxOwner.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDown;
            comboBoxOwner.AutoCompleteMode = AutoCompleteMode.SuggestAppend;
            comboBoxOwner.AutoCompleteSource = AutoCompleteSource.ListItems;

            comboBoxSex.Items.Add("M");
            comboBoxSex.Items.Add("F");

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
            if (String.IsNullOrEmpty(textBoxName.Text) ||
                String.IsNullOrEmpty(textBoxSpecies.Text) ||
                String.IsNullOrEmpty(textBoxBreed.Text) ||
                String.IsNullOrEmpty(textBoxName.Text) ||
                String.IsNullOrEmpty(comboBoxSex.Text) ||
                String.IsNullOrEmpty(comboBoxOwner.Text) ||
                String.IsNullOrEmpty(richTextBox1.Text))
            { empty = true; }
            else if (dateTimePicker1 == null)
            { empty = true; }

            return empty;
        }

    }
}
