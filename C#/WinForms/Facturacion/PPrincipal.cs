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

namespace WinForms_Facturacion
{
    public partial class PPrincipal : Form
    {
        public PPrincipal()
        {
            InitializeComponent();
            buttonMod.Enabled = false;
            buttonDelete.Enabled = false;
        }

        public ItemList IL;

        private void PPrincipal_Load(object sender, EventArgs e)
        {
            IL = new ItemList();
            dataGridItems.Rows.Add(IL.items[0].code, IL.items[0].description, 6, IL.items[0].price, 2.4);
            dataGridItems.Rows.Add(IL.items[1].code, IL.items[1].description, 4, IL.items[1].price, 1.2);
            dataGridItems.Rows.Add(IL.items[3].code, IL.items[3].description, 1, IL.items[3].price, 12);
            UpdateTotal();
        }
        
        private void ButtonAdd_Click(object sender, EventArgs e)
        {
            PAlta pAlta = new PAlta();
            if (pAlta.ShowDialog() == DialogResult.OK)
            {
                dataGridItems.Rows.Add(
                    pAlta.numericUpDownCode.Value,
                    pAlta.textBoxDesc.Text,
                    pAlta.textBoxQuant.Text, 
                    pAlta.textBoxPrice.Text,
                    (int.Parse(pAlta.textBoxQuant.Text) * double.Parse(pAlta.textBoxPrice.Text))
                );
                UpdateTotal();
            }
        }

        private void ButtonMod_Click(object sender, EventArgs e)
        {
            PAlta pAlta = new PAlta();
            pAlta.numericUpDownCode.Value = int.Parse(dataGridItems.SelectedRows[0].Cells[0].Value.ToString());
            pAlta.textBoxQuant.Text = dataGridItems.SelectedRows[0].Cells[2].Value.ToString();
            if (pAlta.ShowDialog() == DialogResult.OK)
            {
                dataGridItems.SelectedRows[0].Cells[0].Value = pAlta.numericUpDownCode.Value;
                dataGridItems.SelectedRows[0].Cells[1].Value = pAlta.textBoxDesc.Text;
                dataGridItems.SelectedRows[0].Cells[2].Value = pAlta.textBoxQuant.Text;
                dataGridItems.SelectedRows[0].Cells[3].Value = pAlta.textBoxPrice.Text;
                dataGridItems.SelectedRows[0].Cells[4].Value = (int.Parse(pAlta.textBoxQuant.Text) * double.Parse(pAlta.textBoxPrice.Text));
                UpdateTotal();
            }
        }

        private void ButtonDelete_Click(object sender, EventArgs e)
        {
            if (dataGridItems.Rows.Count > 0 && dataGridItems.SelectedRows.Count > 0)
            {
                if (MessageBox.Show("¿Quieres borrar esta fila?", "Borrar", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning) == DialogResult.OK)
                {
                    dataGridItems.Rows.RemoveAt(dataGridItems.SelectedRows[0].Index);
                    UpdateTotal();
                }
            }
        }

        private void UpdateTotal()
        {
            double sum = 0.0;
            foreach (DataGridViewRow item in dataGridItems.Rows)
            {
                if (item.Cells[4].Value != null)
                    { sum += double.Parse(item.Cells[4].Value.ToString()); }
            }
            textBoxTotal.Text = sum.ToString();
        }

        private void dataGridItems_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridItems.SelectedRows.Count > 0)
            {
                buttonMod.Enabled = true;
                buttonDelete.Enabled = true;
            }
            else
            {
                buttonMod.Enabled = false;
                buttonDelete.Enabled = false;
            }
        }

        private void dataGridItems_MouseDown(object sender, MouseEventArgs e)
        {
            DataGridView.HitTestInfo hitTest = dataGridItems.HitTest(e.X, e.Y);

            if (hitTest.RowIndex <= -1 || hitTest.ColumnIndex <= -1)
            {
                dataGridItems.ClearSelection();
            }
        }
    }
}
