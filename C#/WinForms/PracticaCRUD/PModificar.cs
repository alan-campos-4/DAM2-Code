using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WF_PracticaCRUD
{
    public partial class PModificar : Form
    {
        public PModificar()
        {
            InitializeComponent();
        }

        private void PModificar_Load(object sender, EventArgs e)
        {
            comboBoxFuel.Items.Clear();
            comboBoxFuel.Items.Add("Gasolina");
            comboBoxFuel.Items.Add("Diésel");
            comboBoxFuel.Items.Add("Eléctrico");
            comboBoxFuel.Items.Add("Híbrido");

            comboBoxTrans.Items.Clear();
            comboBoxTrans.Items.Add("Manual");
            comboBoxTrans.Items.Add("Automático");

            comboBoxDoors.Items.Clear();
            comboBoxDoors.Items.Add(3);
            comboBoxDoors.Items.Add(4);
            comboBoxDoors.Items.Add(5);
            comboBoxDoors.Items.Add(7);

            comboBoxActive.Items.Clear();
            comboBoxActive.Items.Add(0);
            comboBoxActive.Items.Add(1);
        }

        private void ButtonOk_Click(object sender, EventArgs e)
        {
            if (DialogResult == DialogResult.OK)
            {
                DialogResult = DialogResult.OK;
            }

            /*
            comando.Parameters.AddWithValue("@marc", pAdd.textBoxMaker.Text);
            comando.Parameters.AddWithValue("@model", pAdd.textBoxModel.Text);
            comando.Parameters.AddWithValue("@ano", pAdd.textBoxYear.Text);
            comando.Parameters.AddWithValue("@price", pAdd.textBoxPrice.Text);
            comando.Parameters.AddWithValue("@col", pAdd.textBoxColor.Text);
            comando.Parameters.AddWithValue("@kilom", pAdd.textBoxKilom.Text);
            comando.Parameters.AddWithValue("@fuel", pAdd.comboBoxFuel.Text);
            comando.Parameters.AddWithValue("@trans", pAdd.comboBoxTrans.Text);
            comando.Parameters.AddWithValue("@doors", pAdd.comboBoxDoors.Text);
            comando.Parameters.AddWithValue("@stck", pAdd.textBoxStock.Text);
            comando.Parameters.AddWithValue("@desc", pAdd.richTextBox1.Text);
            comando.Parameters.AddWithValue("@date", pAdd.dateTimePicker1.Text);
            comando.Parameters.AddWithValue("@act", pAdd.comboBoxActive.Text);
             */
        }

        private void ButtonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
