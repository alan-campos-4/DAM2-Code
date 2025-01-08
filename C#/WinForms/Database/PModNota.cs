using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Database
{
    public partial class PModNota : Form
    {
        public PModNota()
        {
            InitializeComponent();
        }

        private void buttonOk_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBoxCode1.Text) ||
                String.IsNullOrEmpty(textBoxCode2.Text) ||
                String.IsNullOrEmpty(textBoxSubject.Text) ||
                String.IsNullOrEmpty(textBoxScore.Text))
            {
                DialogResult = DialogResult.None;
            }
        }
    }
}
