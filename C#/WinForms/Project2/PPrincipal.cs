using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Project2
{
    public partial class PPrincipal : Form
    {
        public PPrincipal()
        {
            InitializeComponent();
        }

        private void alumnosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAlumnos PantallaAlumnos = new PAlumnos();
            PantallaAlumnos.ShowDialog();
        }

        private void notasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PNotas PantallaNotas = new PNotas();
            PantallaNotas.ShowDialog();
        }
    }

    

    public class textBoxChecks
    {
        public static void checkOnlyLetters_KeyPress(object sender, KeyPressEventArgs e)
        {
            e.Handled = !(char.IsLetter(e.KeyChar) || e.KeyChar == (char)Keys.Back);
        }

        public static void checkOnlyNumbers_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.'))
            {
                e.Handled = true;
            }
            // Only allow one decimal point
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
        }
    }
}
