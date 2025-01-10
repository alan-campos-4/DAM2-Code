using Google.Protobuf.WellKnownTypes;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
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
            comboBoxFuel.Items.Add("Gasolina");
            comboBoxFuel.Items.Add("Diésel");
            comboBoxFuel.Items.Add("Eléctrico");
            comboBoxFuel.Items.Add("Híbrido");
            labelNecessary.Visible = false;

            /*
            id INT AUTO_INCREMENT PRIMARY KEY,
            marca VARCHAR(50) NOT NULL,
            modelo VARCHAR(50) NOT NULL,
            año YEAR NOT NULL,
            precio DECIMAL(10, 2) NOT NULL,
            color VARCHAR(30),
            kilometraje INT DEFAULT 0,
            combustible ENUM('Gasolina', 'Diésel', 'Eléctrico', 'Híbrido') NOT NULL,
            transmisión ENUM('Manual', 'Automático') NOT NULL,
            puertas TINYINT DEFAULT 5,
            stock INT DEFAULT 1,
            descripcion TEXT,
            fecha_ingreso DATE,
            activo BOOLEAN DEFAULT TRUE
             */

            NotNullFields = new System.Windows.Forms.TextBox[] {
                textBoxMaker,
                textBoxModel,
                textBoxPrice
            };
        }

        static Global g = new Global();
        public System.Windows.Forms.TextBox[] NotNullFields = new System.Windows.Forms.TextBox[10];

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

        public bool FieldsFull()
        {
            bool empty = false;
            foreach (TextBox tb in NotNullFields)
            {
                if (String.IsNullOrEmpty(tb.Text))
                {
                    empty = true;
                    tb.BackColor = Color.IndianRed;
                    labelNecessary.Visible = true;
                }
                else
                {
                    tb.BackColor = Color.White;
                    labelNecessary.Visible = false;
                }
            }
            return empty;
        }


        private void ButtonOk_Click(object sender, EventArgs e)
        {
            if (DialogResult == DialogResult.OK)
            {
                if (!FieldsFull())
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
