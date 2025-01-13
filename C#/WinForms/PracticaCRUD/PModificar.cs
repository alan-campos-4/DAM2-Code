using System;
using System.Drawing;
using System.Windows.Forms;

namespace WF_PracticaCRUD
{
    public partial class PModificar : Form
    {
        public PModificar()
        {
            InitializeComponent();
            comboBoxFuel.Items.Add("Gasolina");
            comboBoxFuel.Items.Add("Diésel");
            comboBoxFuel.Items.Add("Eléctrico");
            comboBoxFuel.Items.Add("Híbrido");

            textBoxMaker.KeyPress += new System.Windows.Forms.KeyPressEventHandler(g.CheckLetters_KeyPress);
            textBoxColor.KeyPress += new System.Windows.Forms.KeyPressEventHandler(g.CheckLetters_KeyPress);
            textBoxYear.KeyPress  += new System.Windows.Forms.KeyPressEventHandler(g.CheckInteger_KeyPress);
            textBoxStock.KeyPress += new System.Windows.Forms.KeyPressEventHandler(g.CheckInteger_KeyPress);
            textBoxKilom.KeyPress += new System.Windows.Forms.KeyPressEventHandler(g.CheckInteger_KeyPress);
            textBoxPrice.KeyPress += new System.Windows.Forms.KeyPressEventHandler(g.CheckDecimal_KeyPress);

            NecessaryFields = new System.Windows.Forms.TextBox[] {
                textBoxMaker,
                textBoxModel,
                textBoxYear,
                textBoxPrice
            };
            foreach (var field in NecessaryFields)
            {
                field.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckFields_KeyPress);
            }
        }

        static Global g = new Global();
        public bool NecessaryFieldsFull;
        public System.Windows.Forms.TextBox[] NecessaryFields = new System.Windows.Forms.TextBox[10];

        private void PModificar_Load(object sender, EventArgs e)
        {
            if (Text.Equals("Mostrar Coche"))
            {
                foreach (Control c in groupBox1.Controls)
                {
                    if (!(c is Label))
                        { c.Enabled = false; }
                }
                foreach (Control c in groupBox2.Controls)
                {
                    if (!(c is Label))
                        { c.Enabled = false; }
                }
                buttonOk.Visible = false;
                buttonCancel.Visible = false;
            }
        }

        public void CheckFields_KeyPress(object sender, KeyPressEventArgs e)
        {
            NecessaryFieldsFull = true;
            if (String.IsNullOrEmpty((sender as TextBox).Text))
            {
                NecessaryFieldsFull = false;
                (sender as TextBox).BackColor = Color.IndianRed;
            }
            else { (sender as TextBox).BackColor = Color.White; }
            /*NecessaryFieldsFull = true;
            foreach (TextBox tb in NecessaryFields)
            {
                if (String.IsNullOrEmpty(tb.Text))
                {
                    NecessaryFieldsFull = false;
                    tb.BackColor = Color.IndianRed;
                }
                else
                {
                    tb.BackColor = Color.White;
                }
            }
            if (NecessaryFieldsFull)
            { labelNecessary.Visible = true; }
            else
            { labelNecessary.Visible = false; }*/


        }


        private void ButtonOk_Click(object sender, EventArgs e)
        {
            if (DialogResult == DialogResult.OK)
            {
                if (NecessaryFieldsFull)
                {
                    if (g.ShowYesNo(Text, "¿Son los datos correctos?") == DialogResult.Yes)
                    { DialogResult = DialogResult.OK; }
                    else
                    { DialogResult = DialogResult.None; }
                }
                else { DialogResult = DialogResult.None; }
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
