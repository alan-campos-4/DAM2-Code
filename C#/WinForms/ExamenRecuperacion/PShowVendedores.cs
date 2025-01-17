using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExamenRecuperacion
{
    public partial class PShowVendedores : Form1
    {
        public PShowVendedores()
        {
            InitializeComponent();
            textBoxFName.ReadOnly = true;
            textBoxLName.ReadOnly = true;
            textBoxProvince.ReadOnly = true;
            textBoxCity.ReadOnly = true;
            textBoxPhone.ReadOnly = true;
            dateTimePicker1.Enabled = false;
        }

        private void ButtonOk_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void PShowVendedores_Load(object sender, EventArgs e)
        {
            

        }
    }
}
