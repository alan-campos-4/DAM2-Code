using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Dataset2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public string connectionString = "Server=localhost;Database=instituto;User ID=root;Password=root;SslMode=none";
        public DataTable tableAlumnos;
        public MySqlDataAdapter adapter;

        private void Form1_Load(object sender, EventArgs e)
        {
            tableAlumnos = new DataTable();
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            adapter = new MySqlDataAdapter("SELECT * FROM alumnos", connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableAlumnos);
            dataGridView1.DataSource = tableAlumnos;
        }

        private void altaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            /*PAlta pAlta = new PAlta();
            pAlta.Text = "Alta a alumno";
            if (pAlta.ShowDialog() == DialogResult.OK)
            {
                DataRow newRow = tableAlumnos.NewRow();
                newRow["Codigo"] = pAlta.textBoxCode.Text;
                newRow["Nombre"] = pAlta.textBoxName.Text;
                newRow["Apellidos"] = pAlta.textBoxLName.Text;
                newRow["Telefono"] = pAlta.textBoxPhone.Text;
                newRow["Provincia"] = pAlta.textBoxProvince.Text;
                tableAlumnos.Rows.Add(newRow);
                tableAlumnos.AcceptChanges();
            }*/

            PAlta1 pAlta = new PAlta1(tableAlumnos);
            pAlta.Text = "Alta a alumno";
            if (pAlta.ShowDialog() == DialogResult.OK)
            {
                DataRow newRow = tableAlumnos.NewRow();
                newRow["Codigo"] = pAlta.textBoxes[0].Text;
                newRow["Nombre"] = pAlta.textBoxes[1].Text;
                newRow["Apellidos"] = pAlta.textBoxes[2].Text;
                newRow["Telefono"] = pAlta.textBoxes[3].Text;
                newRow["Provincia"] = pAlta.textBoxes[4].Text;
                tableAlumnos.Rows.Add(newRow);
                tableAlumnos.AcceptChanges();
            }
        }

        private void modificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                string idSelected = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();
                PAlta1 pMod = new PAlta1(tableAlumnos);
                pMod.Text = "Modificar alumno";
                pMod.textBoxes[0].ReadOnly = true;
                for (int i = 0; i < dataGridView1.Columns.Count; i++)
                {
                    pMod.textBoxes[i].Text = dataGridView1.SelectedRows[0].Cells[i].Value.ToString();
                }
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    DataRow[] rowsToUpdate = tableAlumnos.Select("Codigo = "+idSelected);
                    if (rowsToUpdate.Length > 0)
                    {
                        DataRow row = rowsToUpdate[0];
                        row["Codigo"] = pMod.textBoxes[0].Text;
                        row["Nombre"] = pMod.textBoxes[1].Text;
                        row["Apellidos"] = pMod.textBoxes[2].Text;
                        row["Telefono"] = pMod.textBoxes[3].Text;
                        row["Provincia"] = pMod.textBoxes[4].Text;
                        tableAlumnos.AcceptChanges();
                    }
                }
            }
            else {MessageBox.Show("Debes seleccionar una fila.");}
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                if (MessageBox.Show("¿Estás seguro de que quieres borrar este alumno?","Borrar alumno",MessageBoxButtons.OKCancel) == DialogResult.OK)
                {
                    string idSelected = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();
                    DataRow[] rowsToDelete = tableAlumnos.Select("Codigo = " + idSelected);
                    if (rowsToDelete.Length > 0)
                    {
                        DataRow row = rowsToDelete[0];
                        row.Delete();
                        tableAlumnos.AcceptChanges();
                    }
                }
            }
            else {MessageBox.Show("Debes seleccionar una fila.");}
        }

        private void buttonUpdate_Click(object sender, EventArgs e)
        {
            adapter.Update(tableAlumnos);
        }

    }
}
