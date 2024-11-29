using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Examen1
{
    public partial class PPrincipal : Form
    {
        public PPrincipal()
        {
            InitializeComponent();
        }

        private void alumnosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAlumnos pAlumnos = new PAlumnos();
            pAlumnos.ShowDialog();
        }

        private void buscadorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PBuscador pBuscador = new PBuscador();
            pBuscador.ShowDialog();
        }
    }
}
