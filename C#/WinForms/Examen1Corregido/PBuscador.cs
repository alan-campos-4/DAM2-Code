using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace WinForms_Examen1
{
    public partial class PBuscador : Form
    {
        public PBuscador()
        {
            InitializeComponent();
        }

        private void PBuscador_Load(object sender, EventArgs e)
        {
            dataGridView2.Rows.Add(1001, "Laura", "Sánchez", 456456, "Sevilla", "4.5, 7.8, 6.3", 6.2);
            dataGridView2.Rows.Add(1002, "Manuel", "Higueros", 181818, "Huelva", "7.8, 6.8, 9.3", 7.97);
            dataGridView2.Rows.Add(1003, "Diego", "Tenorio", 739739, "Cádiz", "4.5, 7.8, 6.3", 6.2);
            dataGridView2.Rows.Add(1004, "Sara", "Torres", 484848, "Sevilla", "5.5, 8.8, 6.5", 6.93);
        }

        private void dataGridView2_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView2.SelectedRows.Count == 1)
            {
                int selectedIndex = dataGridView2.SelectedRows[0].Index;
                PAlumnos pAlumnos = new PAlumnos();
                pAlumnos.dataGridView1.Rows[0].Selected = true;
                pAlumnos.ShowDialog();
            }
        }

        private void textBoxSearch_TextChanged(object sender, EventArgs e)
        {
            dataGridView2.ClearSelection();
            foreach (DataGridViewRow row in dataGridView2.Rows)
            {
                row.Visible = true;
            }
            if (!String.IsNullOrEmpty(textBoxSearch.Text))
            {
                foreach (DataGridViewRow row in dataGridView2.Rows)
                {
                    if (!row.Cells[2].Value.ToString().Contains(textBoxSearch.Text))
                    {
                        row.Visible = false;
                    }
                }
            }

        }
    }
}
