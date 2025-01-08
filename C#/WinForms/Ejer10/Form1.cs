using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace WinForms_Ejer10
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            textBoxCode1.Text = "1";
            textBoxDesc1.Text = "Tornillos";
            textBoxCode2.Text = "2";
            textBoxDesc2.Text = "Arandelas";
            textBoxCode3.Text = "6";
            textBoxDesc3.Text = "Martillo";

            textBoxCode1.ReadOnly = true;
            textBoxDesc1.ReadOnly = true;
            textBoxCode2.ReadOnly = true;
            textBoxDesc2.ReadOnly = true;
            textBoxCode3.ReadOnly = true;
            textBoxDesc3.ReadOnly = true;
            textBoxSubtotal1.ReadOnly = true;
            textBoxSubtotal2.ReadOnly = true;
            textBoxSubtotal3.ReadOnly = true;

            labelDiscount.Hide();
            labelError.Hide();
        }

        double subtotal1, subtotal2, subtotal3, total;

        private void button1_Click(object sender, EventArgs e)
        {
            if (int.TryParse(quantity1.Text, out int q1) &&
                int.TryParse(quantity2.Text, out int q2) &&
                int.TryParse(quantity3.Text, out int q3) &&
                double.TryParse(textBoxPrice1.Text, out double p1) &&
                double.TryParse(textBoxPrice2.Text, out double p2) &&
                double.TryParse(textBoxPrice3.Text, out double p3) )
            {
                labelError.Hide();

                subtotal1 = p1 * q1;
                subtotal2 = p2 * q2;
                subtotal3 = p3 * q3;
                total = subtotal1 + subtotal2 + subtotal3;

                if (total >= 10000 && total <= 20000)
                {
                    total *= 0.9;
                    labelDiscount.Text = "Descuento aplicado\ndel 10%";
                    labelDiscount.Show();
                }
                else if (total >= 20001 && total <= 50000)
                {
                    total *= 0.7;
                    labelDiscount.Text = "Descuento aplicado\ndel 30%";
                    labelDiscount.Show();
                }
                else if (total > 50000)
                {
                    total *= 0.5;
                    labelDiscount.Text = "Descuento aplicado\ndel 50%";
                    labelDiscount.Show();
                }
                else { labelDiscount.Hide(); }

                textBoxSubtotal1.Text = subtotal1.ToString();
                textBoxSubtotal2.Text = subtotal2.ToString();
                textBoxSubtotal3.Text = subtotal3.ToString();

                labelTotal.Text = total.ToString();
                labelTotalIva.Text = (total * 1.21).ToString();
            }
            else
            {
                labelError.Text = "Debes introducir valores válidos";
                labelError.Show();
            }
        }
    }
}
