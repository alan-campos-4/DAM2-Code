using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Ejer1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Adder_Click(object sender, EventArgs e)
        {
            if (!String.IsNullOrEmpty(Num1.Text) && !String.IsNullOrEmpty(Num2.Text))
            {
                if (Num1.Text.All(Char.IsDigit) && Num2.Text.All(Char.IsDigit))
                {
                    int res = int.Parse(Num1.Text) + int.Parse(Num2.Text);
                    Result.Text = Convert.ToString(res);
                }
                else
                {
                    Result.Text = "Debes introducir\nnúmeros";
                }
            }
            else
            {
                Result.Text = "Debes rellenar\nambos campos";
            }
        }
    }
}
