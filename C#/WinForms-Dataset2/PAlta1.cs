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
    public partial class PAlta1 : Form
    {
        public PAlta1(DataTable DT)
        {
            InitializeComponent(DT);
        }

        private void buttonOk_Click(object sender, EventArgs e)
        {
            if (checkEmpty())
            {
                MessageBox.Show("Debes rellenar todos los campos");
                this.DialogResult = DialogResult.None;
            }
        }

        private bool checkEmpty()
        {
            bool empty = false;
            foreach (TextBox tb in textBoxes)
            {
                if (String.IsNullOrEmpty(tb.Text))
                    empty = true;
            }
            return empty;
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
