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

        private void buttonOk_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBoxCode.Text) ||
                String.IsNullOrEmpty(textBoxName.Text) ||
                String.IsNullOrEmpty(textBoxLName.Text) ||
                String.IsNullOrEmpty(textBoxPhone.Text) ||
                String.IsNullOrEmpty(textBoxProvince.Text) )
            {
                MessageBox.Show("Debes rellenar todos los campos.");
                this.DialogResult = DialogResult.None;
            }
            else 
            {
                TextBox[] tbNotes = { textBoxNote1 , textBoxNote2 , textBoxNote3 };
                foreach (TextBox tb in tbNotes)
                {
                    if (String.IsNullOrEmpty(textBoxCode.Text))
                    {
                        tb.Text = "-";
                        this.DialogResult = DialogResult.OK;
                    }
                    else if (Double.TryParse(tb.Text, out double num))
                    {
                        if (num >= 0.0 && num <= 10.0)
                        {
                            if (MessageBox.Show("¿Son los datos correctos?", caption, MessageBoxButtons.OKCancel) == DialogResult.Cancel)
                                { this.DialogResult = DialogResult.None; }
                            else
                                { this.DialogResult = DialogResult.OK; }
                        }
                        else
                        {
                            MessageBox.Show("Las notas no están dentro del rango válido.");
                            this.DialogResult = DialogResult.None;
                        }
                    }
                }
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
