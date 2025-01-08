using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Projecto
{
    public partial class PAlta : Form
    {
        public PAlta()
        {
            InitializeComponent();
            labelErrorAlta.Hide();
        }


        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (!String.IsNullOrEmpty(textBoxName1.Text) && //Checks the boxes are not empty
                !String.IsNullOrEmpty(textBoxName2.Text) &&
                !String.IsNullOrEmpty(textBoxPhone.Text))
            {
                if (textBoxName1.Text.All(Char.IsLetter) &&     //Checks the names only contains letters
                    textBoxName2.Text.All(Char.IsLetter) &&
                    int.TryParse(textBoxPhone.Text, out _) )    //Checks the phone only contains numbers
                {
                    labelErrorAlta.Hide();
                    string Alta = textBoxName2.Text + ", " + textBoxName1.Text + " - " + textBoxPhone.Text;
                }
                else
                {
                    labelErrorAlta.Text = "Los datos introducidos no son válidos";
                    labelErrorAlta.Show();
                }
            }
            else
            {
                labelErrorAlta.Text = "Debes rellenar todos los campos";
                labelErrorAlta.Show();
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}