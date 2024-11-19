using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Dataset2
{
    public partial class PAlta : Form
    {
        public PAlta()
        {
            InitializeComponent();
        }

        private void buttonOk_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBoxCode.Text) ||
                String.IsNullOrEmpty(textBoxName.Text) ||
                String.IsNullOrEmpty(textBoxLName.Text) ||
                String.IsNullOrEmpty(textBoxPhone.Text) ||
                String.IsNullOrEmpty(textBoxProvince.Text) )
            {
                MessageBox.Show("Debes rellenar todos los campos");
                this.DialogResult = DialogResult.None;
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
