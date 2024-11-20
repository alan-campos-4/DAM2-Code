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
        }

        private void ClientesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PClientes clientes = new PClientes();
            clientes.ShowDialog();
        }

        private void MascotasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PMascotas mascotas = new PMascotas();
            mascotas.ShowDialog();
        }

        private void CitasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PCitas citas = new PCitas();
            citas.ShowDialog();
        }
    }
}
