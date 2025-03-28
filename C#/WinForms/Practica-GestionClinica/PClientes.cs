﻿using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace WinForms_Practica_GestionClinica
{
    public partial class PClientes : Form
    {
        public PClientes()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();
        public DataTable tableClients;
        public MySqlDataAdapter adapter;

        private void PClientes_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            tableClients = new DataTable();
            adapter = new MySqlDataAdapter("SELECT * FROM clientes ORDER BY 2, 3", connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableClients);
            dataGridView1.DataSource = tableClients;
            dataGridView1.Columns["ID"].Visible = false;
            dataGridView1.Columns["DNI"].Visible = false;
            dataGridView1.Columns["Provincia"].Visible = false;
            dataGridView1.Columns["Direccion"].Visible = false;
            dataGridView1.Columns["CodPostal"].Visible = false;
            dataGridView1.Columns["Observaciones"].Visible = false;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            connection.Close();
        }

        private void AltaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAddClientes pAdd = new PAddClientes{ Text = "Añadir Cliente" };
            if (pAdd.ShowDialog()==DialogResult.OK)
            {
                try
                { 
                    tableClients.Rows.Add(
                        g.GenerateNewID("clientes"),
                        pAdd.textBoxDNI.Text,
                        pAdd.textBoxName1.Text,
                        pAdd.textBoxName2.Text,
                        pAdd.textBoxPhone.Text,
                        pAdd.textBoxEmail.Text,
                        pAdd.comboBoxProv.Text,
                        pAdd.comboBoxCity.Text,
                        pAdd.textBoxAddress.Text,
                        pAdd.textBoxPostal.Text,
                        pAdd.richTextBox1.Text
                    );
                    adapter.Update(tableClients);
                }
                catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
            }

            /*
            PAlta pAdd = new PAlta { Text = g.AddTitle };
            if (pAdd.ShowDialog()==DialogResult.OK)
            {
                if (g.ShowWarning(g.AddTitle, "¿Son los datos correctos?") == DialogResult.OK)
                {
                    MySqlConnection connection = new MySqlConnection(connectionString);
                    connection.Open();

                    string sql = "INSERT INTO articulos VALUES (@code, @desc, @price, @stck, @fam)";
                    var comando = new MySqlCommand(sql, connection);
                    comando.Parameters.AddWithValue("@code", pAdd.textBoxCode.Text);
                    comando.Parameters.AddWithValue("@desc", pAdd.textBoxDesc.Text);
                    comando.Parameters.AddWithValue("@price", pAdd.textBoxPrice.Text);
                    comando.Parameters.AddWithValue("@stck", pAdd.textBoxStock.Text);
                    comando.Parameters.AddWithValue("@fam", pAdd.comboBoxFamily.Text);
                    int filasAfectadas = comando.ExecuteNonQuery();
                    connection.Close();

                    if (filasAfectadas > 0)
                    {
                        g.ShowConfirm(g.AddTitle, "Se han añadido los datos correctamente.");
                        ReloadDataGrid();
                    }
                    else { g.ShowError("No se ha añadido ninguna fila."); }
                }
            }

             */
        }

        private void ModificaciónToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PAddClientes pMod = new PAddClientes{ Text = "Modificar Cliente" };
                pMod.textBoxDNI.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                pMod.textBoxName1.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
                pMod.textBoxName2.Text = dataGridView1.SelectedRows[0].Cells[3].Value.ToString();
                pMod.textBoxPhone.Text = dataGridView1.SelectedRows[0].Cells[4].Value.ToString();
                pMod.textBoxEmail.Text = dataGridView1.SelectedRows[0].Cells[5].Value.ToString();
                pMod.comboBoxProv.DisplayMember = dataGridView1.SelectedRows[0].Cells[6].Value.ToString();
                pMod.comboBoxCity.DisplayMember = dataGridView1.SelectedRows[0].Cells[7].Value.ToString();
                pMod.textBoxAddress.Text = dataGridView1.SelectedRows[0].Cells[8].Value.ToString();
                pMod.textBoxPostal.Text = dataGridView1.SelectedRows[0].Cells[9].Value.ToString();
                pMod.richTextBox1.Text = dataGridView1.SelectedRows[0].Cells[10].Value.ToString();
                if (pMod.ShowDialog()==DialogResult.OK)
                {
                    try {
                        dataGridView1.SelectedRows[0].Cells[1].Value = pMod.textBoxDNI.Text;
                        dataGridView1.SelectedRows[0].Cells[2].Value = pMod.textBoxName1.Text;
                        dataGridView1.SelectedRows[0].Cells[3].Value = pMod.textBoxName2.Text;
                        dataGridView1.SelectedRows[0].Cells[4].Value = pMod.textBoxPhone.Text;
                        dataGridView1.SelectedRows[0].Cells[5].Value = pMod.textBoxEmail.Text;
                        dataGridView1.SelectedRows[0].Cells[6].Value = pMod.comboBoxProv.Text;
                        dataGridView1.SelectedRows[0].Cells[7].Value = pMod.comboBoxCity.Text;
                        dataGridView1.SelectedRows[0].Cells[8].Value = pMod.textBoxAddress.Text;
                        dataGridView1.SelectedRows[0].Cells[9].Value = pMod.textBoxPostal.Text;
                        dataGridView1.SelectedRows[0].Cells[10].Value = pMod.richTextBox1.Text;
                        adapter.Update(tableClients);
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }

        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                if (g.ShowWarning("Borrar cliente", "¿Seguro que quieres borrar este cliente?") == DialogResult.OK)
                {
                    try
                    {
                        dataGridView1.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        adapter.Update(tableClients);
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) {g.ShowError(ex.Message);}
                }
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }

        private void TextBox1_TextChanged(object sender, EventArgs e)
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
                    string name = row.Cells[2].Value.ToString() + row.Cells[3].Value.ToString();
                    if (!name.ToLower().Contains(textBoxSearch.Text.ToLower()))
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
