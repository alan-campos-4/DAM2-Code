using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace App2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Generator_Click(object sender, EventArgs e)
        {
            Random rnd = new Random();
            NumGenerated.Text = rnd.Next(100).ToString();

            Comparer_Click(sender, e);
        }

        private void Comparer_Click(object sender, EventArgs e)
        {
            if (UserInput.Text == null)
            {
                Result.Text = "Debes introducir un número";
            }
            else if (!int.TryParse(UserInput.Text, out int value))
            {
                Result.Text = "Debes introducir un número";
            }
            else
            {
                if (int.Parse(NumGenerated.Text) == int.Parse(UserInput.Text))
                {
                    Result.Text = "Igual";
                }
                else if (int.Parse(NumGenerated.Text) > int.Parse(UserInput.Text))
                {
                    Result.Text = "Mayor";
                }
                else
                {
                    Result.Text = "Menor";
                }
            }
        }
    }
}