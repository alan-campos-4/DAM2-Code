using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics.Eventing.Reader;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Facturacion
{
    public partial class PAlta : Form
    {
        public PAlta()
        {
            InitializeComponent();
        }

        public ItemList IL = new ItemList();

        private void PAlta_Load(object sender, EventArgs e)
        {
            numericUpDownCode.Minimum = 1;
            numericUpDownCode.Maximum = IL.items.Length;
        }

        private void ButtonOk_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBoxQuant.Text))
            {
                labelError.Text = "Debes rellenar todos los campos";
                this.DialogResult = DialogResult.None;
            }
            if (int.Parse(textBoxQuant.Text) < 1)
            {
                labelError.Text = "La cantidad no es válida";
                this.DialogResult = DialogResult.None;
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void numericUpDownCode_ValueChanged(object sender, EventArgs e)
        {
            int index = decimal.ToInt32(numericUpDownCode.Value);
            textBoxDesc.Text = IL.items[index-1].description.ToString();
            textBoxPrice.Text = IL.items[index-1].price.ToString();
        }

        private void checkInteger_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != ','))
            {
                e.Handled = true;
            }
            if ((e.KeyChar == ',') && ((sender as TextBox).Text.IndexOf(',') == -1))
            {
                e.Handled = true;
            }
        }
    }
}