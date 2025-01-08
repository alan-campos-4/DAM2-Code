using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Ejer2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Search_Click(object sender, EventArgs e)
        {
            int count = 0;
            if (!String.IsNullOrEmpty(WordInput.Text) && !String.IsNullOrEmpty(TextInput.Text))
            {
                if (Char.IsLetter(WordInput.Text, 0))
                {
                    char[] inputArray = TextInput.Text.ToCharArray();
                    for (int i = 0; i < inputArray.Length; i++)
                    {
                        if (inputArray[i] == Char.Parse(WordInput.Text)) 
                            count++;
                    }
                    if (count > 0)
                        {Result.Text = "La letra introducida aparece "+count+" veces";}
                    else
                        {Result.Text = "La letra introducida no aparece"; }
                }
                else {Result.Text = "Debes escribir una letra";}
            }
            else {Result.Text = "Debes rellenar ambos campos";}
        }
    }
}
