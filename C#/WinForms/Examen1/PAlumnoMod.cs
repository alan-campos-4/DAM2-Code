using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Examen1
{
    public partial class PAlumnoMod : Form
    {
        public PAlumnoMod()
        {
            InitializeComponent();
        }

        public string caption;
        public int scoreNum;

        private void buttonOk_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBoxCode.Text) ||
                String.IsNullOrEmpty(textBoxName.Text) ||
                String.IsNullOrEmpty(textBoxLName.Text) ||
                String.IsNullOrEmpty(textBoxPhone.Text) ||
                String.IsNullOrEmpty(textBoxProvince.Text) ||
                String.IsNullOrEmpty(textBoxNote1.Text) ||
                String.IsNullOrEmpty(textBoxNote2.Text) ||
                String.IsNullOrEmpty(textBoxNote3.Text))
            {
                MessageBox.Show("Debes rellenar todos los campos.");
                this.DialogResult = DialogResult.None;
            }
            else 
            {
                if (textBoxNote1.Text.Equals('-') ||
                    textBoxNote2.Text.Equals('-') ||
                    textBoxNote3.Text.Equals('-'))
                {
                    
                }
                if (Double.TryParse(textBoxNote1.Text, out double n1) &&
                    Double.TryParse(textBoxNote2.Text, out double n2) &&
                    Double.TryParse(textBoxNote3.Text, out double n3))
                {
                    if (n1 >= 0.0 && n2 >= 0.0 && n3 >= 0.0 &&
                        n1 <= 10.0 && n2 <= 10.0 && n3 <= 10.0)
                    {
                        if (MessageBox.Show("¿Son los datos correctos?", caption, MessageBoxButtons.OKCancel) == DialogResult.Cancel)
                        {
                            this.DialogResult = DialogResult.None;
                        }
                    }
                    else
                    {
                        MessageBox.Show("Las notas no están dentro del rango válido.");
                        this.DialogResult = DialogResult.None;
                    }
                }
                else
                {
                    MessageBox.Show("Las valores de las notas no son válidos.");
                    this.DialogResult = DialogResult.None;
                }
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
