﻿using MySql.Data.MySqlClient;
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
    public partial class PAddMascotas : Form
    {
        public PAddMascotas()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();
        public char sex;

        private void PMascotasAdd_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT ID, CONCAT(Apellidos, ', ', Nombre) AS Name FROM clientes";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connectionString);
            DataTable Tduenos = new DataTable();
            adapter.Fill(Tduenos);
            comboBoxOwner.DataSource = Tduenos;
            comboBoxOwner.DisplayMember = "Name";
            comboBoxOwner.ValueMember = "ID";
            comboBoxOwner.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDown;
            comboBoxOwner.AutoCompleteMode = AutoCompleteMode.SuggestAppend;
            comboBoxOwner.AutoCompleteSource = AutoCompleteSource.ListItems;

            connection.Close();
        }

        private void ButtonOK_Click(object sender, EventArgs e)
        {
            if (FindEmpty())
            {
                g.ShowError("Debes rellenar todos los datos.");
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

        private void ButtonCancel_Click(object sender, EventArgs e)
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
                //String.IsNullOrEmpty(comboBoxSex.Text) ||
                String.IsNullOrEmpty(comboBoxOwner.Text) ||
                String.IsNullOrEmpty(richTextBox1.Text))
            { empty = true; }
            else if (dateTimePicker1 == null)
            { empty = true; }

            return empty;
        }

        private void RadioButtonMale_CheckedChanged(object sender, EventArgs e)
        {
            if (radioButtonMale.Checked)
                { sex = 'M'; }
            else
                { sex = 'F'; }
        }
    }
}
