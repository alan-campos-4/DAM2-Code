using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Ejer6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            panelCredit.Hide();
            panelCash.Hide();
        }

        private void comboBox1_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            if (comboBox1.SelectedItem == comboBox1.Items[0])
            {
                panelCredit.Show();
                panelCash.Hide();
            }
            else
            {
                panelCredit.Hide();
                panelCash.Show();
            }
        }
    }
}
