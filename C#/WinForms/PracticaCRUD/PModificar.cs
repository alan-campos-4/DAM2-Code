using System;
using System.Drawing;
using System.Windows.Forms;

namespace WF_PracticaCRUD
{
    public partial class PModificar : Form1
    {
        public PModificar()
        {
            InitializeComponent();
            comboBoxFuel.Items.Add("Gasolina");
            comboBoxFuel.Items.Add("Diésel");
            comboBoxFuel.Items.Add("Eléctrico");
            comboBoxFuel.Items.Add("Híbrido");

            textBoxModel.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckModel_KeyPress);
            textBoxMaker.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckLetters_KeyPress);
            textBoxColor.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckLetters_KeyPress);
            textBoxYear.KeyPress  += new System.Windows.Forms.KeyPressEventHandler(CheckInteger_KeyPress);
            textBoxStock.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckInteger_KeyPress);
            textBoxKilom.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckInteger_KeyPress);
            textBoxPrice.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckDecimal_KeyPress);

            NecessaryFields = new System.Windows.Forms.TextBox[] {
                textBoxMaker,
                textBoxModel,
                textBoxYear,
                textBoxPrice
            };
            foreach (var field in NecessaryFields)
            { field.KeyPress += new System.Windows.Forms.KeyPressEventHandler(CheckFields_KeyPress); }
        }

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

        public void CheckNecessaryFields()
        {
            NecessaryFieldsFull = true;
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
            { labelNecessary.Visible = false; }
            else
            { labelNecessary.Visible = true; }
        }

        private void CheckFields_KeyPress(object sender, KeyPressEventArgs e)
        {
            CheckNecessaryFields();
        }


        private void ButtonOk_Click(object sender, EventArgs e)
        {
            if (this.DialogResult == DialogResult.OK)
            {
                if (this.NecessaryFieldsFull)
                {
                    if (ShowYesNo(Text, "¿Son los datos correctos?") == DialogResult.Yes)
                    { this.DialogResult = DialogResult.OK; }
                    else
                    { this.DialogResult = DialogResult.None; }
                }
                else { this.DialogResult = DialogResult.None; }
            }
        }

        private void ButtonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
