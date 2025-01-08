using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Ejer7
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonOk_Click(object sender, EventArgs e)
        {
            if ((float.TryParse(textBox1.Text, out float res1)) &&
                (float.TryParse(textBox2.Text, out float res2)) &&
                (float.TryParse(textBox3.Text, out float res3)))
            {
                String res = "";
                if (radioButtonAdd.Checked)         { res = (res1 + res2 + res3).ToString(); }
                else if (radioButtonSubt.Checked)   { res = (res1 - res2 - res3).ToString(); }
                else if (radioButtonMult.Checked)   { res = (res1 * res2 * res3).ToString(); }
                else if (radioButtonDivide.Checked) { res = (res1 / res2 / res3).ToString(); }
                else if (radioButtonAll.Checked)
                {
                    res = (res1 + res2 + res3).ToString() + " | "
                        + (res1 - res2 - res3).ToString() + " | "
                        + (res1 * res2 * res3).ToString() + " | "
                        + (res1 / res2 / res3).ToString();
                }
                labelResult.Text = "Los resultados son: " + res;
            }
            else
            {
                labelResult.Text = "Debes introducir números.";
            }
        }

        private void buttonDelete_Click(object sender, EventArgs e)
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            radioButtonAdd.Checked = false;
            radioButtonSubt.Checked = false;
            radioButtonMult.Checked = false;
            radioButtonDivide.Checked = false;
            radioButtonAll.Checked = false;
            labelResult.Text = "Los resultados son: ";
        }

        private void buttonOut_Click(object sender, EventArgs e)
        {
            System.Windows.Forms.Application.Exit();
        }
    }
}
