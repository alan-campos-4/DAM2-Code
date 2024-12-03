using MySql.Data.MySqlClient;
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
        public string connectionString = g.ConnectionString();
        public DataTable tableClients;
        public MySqlDataAdapter adapter;

        private void PClientes_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            tableClients = new DataTable();
            adapter = new MySqlDataAdapter("SELECT * FROM clientes", connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableClients);
            dataGridView1.DataSource = tableClients;
            dataGridView1.Columns["ID_CL"].Visible = false;
            dataGridView1.Columns["DNI"].Visible = false;
            dataGridView1.Columns["Observaciones"].Visible = false;
            connection.Close();
        }

        private void altaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PClientesAdd pAdd = new PClientesAdd{ Text = "Añadir Cliente" };
            if (pAdd.ShowDialog()==DialogResult.OK)
            {
                tableClients.Rows.Add(
                    g.GenerateNewID("clientes", 1000),
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
            }
        }

        private void modificaciónToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PClientesAdd pMod = new PClientesAdd{ Text = "Modificar Cliente" };
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
                }
            }
            else { g.ShowError("Fila seleccionada.", "No se puede realizar esta acción\nsin seleccionar una fila."); }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                if (g.ShowWarning("Borrar cliente", "¿Seguro que quieres borrar este cliente?") == DialogResult.OK)
                {
                    dataGridView1.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                }
            }
            else { g.ShowError("Fila seleccionada.", "No se puede realizar esta acción\nsin seleccionar una fila."); }
        }

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PClientesShow pShow = new PClientesShow();
                pShow.ShowDialog();
            }
        }
    }
}
