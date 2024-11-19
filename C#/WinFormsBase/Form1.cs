using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsBase
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void form2ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 pantalla = new Form2();
            pantalla.ShowDialog();
        }

        private void form3ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 pantalla = new Form2();
            pantalla.ShowDialog();
        }
    }
}
