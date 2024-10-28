using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            contador.Text = Convert.ToString(Convert.ToInt32(contador.Text) + 1);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (num1.Text == null || num2.Text == null)
            {
                result.Text = "Debes rellenar ambos campos";
            }
            else
            {
                result.Text = Convert.ToString(Convert.ToInt32(num1.Text) + Convert.ToInt32(num2.Text));
            }
        }

    }
}
