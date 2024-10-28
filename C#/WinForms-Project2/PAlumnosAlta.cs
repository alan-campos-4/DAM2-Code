using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Project2
{
    public partial class PAlumnosAlta : Form
    {
        public PAlumnosAlta()
        {
            InitializeComponent();
        }

        public string[] usedCodes;

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBoxName1.Text) || //Checks the boxes are not empty
                String.IsNullOrEmpty(textBoxName2.Text) ||
                String.IsNullOrEmpty(textBoxPhone.Text) ||
                String.IsNullOrEmpty(textBoxCode.Text))
            {
                labelError.Text = "Debes rellenar todos los campos.";
                this.DialogResult = DialogResult.None;
            }
            else if (usedCodes.Contains(textBoxCode.Text))
            {
                labelError.Text = "Ese código no está disponible.";
                this.DialogResult = DialogResult.None;
            }
            else
            {
                MessageBox.Show("¿Son los datos correctos?", "Alta a alumno", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void checkOnlyLetters_KeyPress(object sender, KeyPressEventArgs e)
        {
            e.Handled = !(char.IsLetter(e.KeyChar) || e.KeyChar == (char)Keys.Back);
        }

        private void checkOnlyNumbers_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.'))
            {
                e.Handled = true;
            }
            // Only allow one decimal point
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
        }
    }
}