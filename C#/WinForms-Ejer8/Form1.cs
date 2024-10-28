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

namespace WinForms_Ejer8
{
    public partial class Form1 : Form
    {
        /*
         * Vamos a realizar un programa que permita a una tienda saber el valor que pagará un cliente  
         * por la compra de varios elementos (3 artículos comprados) de distinta referencia.  
         * Debe tener como entradas el valor unitario, la cantidad de productos comprados   
         * y al valor final se debe adicionar el 21% correspondiente al IVA.
         */

        /*
        public class Item
        {
            string Text;
            double Value;

            public Item(string text, double value)
            {
                Text = text;
                Value = value;
            }
        }
        
        private List<Item> GetPriceList()
        {
            return new List<Item>
            {
               new Item("Tornillos", 3.0),
               new Item("Tijeras", 7.5),
               new Item("Alambre", 12)
            };
        }
        private void BindList(System.Windows.Forms.ComboBox comboBox, List<Item> priceList)
        {
            comboBox.DataSource = priceList;
            comboBox.ValueMember = "Value";
            comboBox.DisplayMember = "Text";
        }
        //*/


        public Form1()
        {
            InitializeComponent();
            //BindList(comboBox1, GetPriceList());
            //BindList(comboBox2, GetPriceList());
            //BindList(comboBox3, GetPriceList());
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

            labelError.Hide();
        }

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

                textBoxSubtotal1.Text = (p1 * q1).ToString();
                textBoxSubtotal2.Text = (p2 * q2).ToString();
                textBoxSubtotal3.Text = (p3 * q3).ToString();

                labelTotal.Text = (p1*q1 + p2*q2 + p3*q3).ToString();
                labelTotalIva.Text = (double.Parse(labelTotal.Text) * 1.21).ToString();
            }
            else
            {
                labelError.Text = "Debes introducir valores válidos";
                labelError.Show();
            }
            
        }
    }
}
