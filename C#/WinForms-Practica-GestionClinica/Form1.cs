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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.clientesToolStripMenuItem.Margin = new System.Windows.Forms.Padding(15, this.Height*3/5, 30, 5);
            this.mascotasToolStripMenuItem.Margin = new System.Windows.Forms.Padding(15, 10, 30, 5);
            this.citasToolStripMenuItem.Margin = new System.Windows.Forms.Padding(15, 10, 30, 5);
        }

        private void ClientesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //PClientes clientes = new PClientes();
            //clientes.ShowDialog();
            var frm = new PClientes
            {
                Location = this.Location,
                StartPosition = FormStartPosition.Manual
            };
            frm.FormClosing += delegate { this.Show(); };
            frm.Show();
            this.Hide();
        }

        private void MascotasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //PMascotas mascotas = new PMascotas();
            //mascotas.ShowDialog();
            var frm = new PMascotas
            {
                Location = this.Location,
                StartPosition = FormStartPosition.Manual
            };
            frm.FormClosing += delegate { this.Show(); };
            frm.Show();
            this.Hide();
        }

        private void CitasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //PCitas citas = new PCitas();
            //citas.ShowDialog();
            var frm = new PCitas()
            {
                Location = this.Location,
                StartPosition = FormStartPosition.Manual
            };
            frm.FormClosing += delegate { this.Show(); };
            frm.Show();
            this.Hide();
        }
    }
}
