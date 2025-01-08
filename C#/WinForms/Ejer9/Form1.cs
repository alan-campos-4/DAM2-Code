using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Ejer9
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            labelError.Hide();
        }

        private void buttonCalc_Click(object sender, EventArgs e)
        {
            if (int.TryParse(textBoxDays.Text, out int days) &&
                double.TryParse(textBoxSalary.Text, out double salary))
            {
                labelError.Hide();
                labelResult.Text =    (days * salary).ToString();
                labelNetResult.Text = (days * salary * (1 - 0.1) * (1 - 0.15)).ToString();
            }
            else
            {
                labelError.Text = "Valores no válidos";
                labelError.Show();
            }
        }
    }
}
