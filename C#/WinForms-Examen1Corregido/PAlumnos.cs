using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Examen1
{
    public partial class PAlumnos : Form
    {
        public PAlumnos()
        {
            InitializeComponent();
        }

        private void PAlumnos_Load(object sender, EventArgs e)
        {
            dataGridView1.Rows.Add(1001, "Laura", "Sánchez", 456456, "Sevilla", "4.5, 7.8, 6.3", 6.2);
            dataGridView1.Rows.Add(1002, "Manuel", "Higueros", 181818, "Huelva", "7.8, 6.8, 9.3", 7.97);
            dataGridView1.Rows.Add(1003, "Diego", "Tenorio", 739739, "Cádiz", "4.5, 7.8, 6.3", 6.2);
            dataGridView1.Rows.Add(1004, "Sara", "Torres", 484848, "Sevilla", "5.5, 8.8, 6.5", 6.93);
            GetTotalAverage();
        }




        public string GetStudentAverage(string tb1, string tb2, string tb3)
        {
            double num = 0;

            if (!tb1.Equals("-")) { num += Double.Parse(tb1); }
            if (!tb2.Equals("-")) { num += Double.Parse(tb1); }
            if (!tb3.Equals("-")) { num += Double.Parse(tb3); }

            double avg = (double)num / (double)3;
            return avg.ToString();
        }
        
        public void GetTotalAverage()
        {
            double sum = 0;
            int total = 0;

            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                string[] notas = row.Cells[5].Value.ToString().Split(',');

                for (int i=0; i<3; i++)
                {
                    if (!notas[i].Equals("-"))
                    {
                        notas[i] = notas[i].Replace(" ", "");
                        sum += Double.Parse(notas[i]);
                        total++;
                    }
                }
            }
            textBoxAvg.Text = ((sum / total) / 10).ToString();
        }




        private void altaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAlumnoMod pInsertar = new PAlumnoMod();
            pInsertar.caption = "Añadir Alumno";
            if (pInsertar.ShowDialog() == DialogResult.OK)
            {
                dataGridView1.Rows.Add(
                    pInsertar.textBoxCode.Text,
                    pInsertar.textBoxName.Text,
                    pInsertar.textBoxLName.Text,
                    pInsertar.textBoxPhone.Text,
                    pInsertar.textBoxProvince.Text,
                    pInsertar.textBoxNote1.Text + ", " +
                    pInsertar.textBoxNote2.Text + ", " +
                    pInsertar.textBoxNote3.Text,
                    GetStudentAverage(pInsertar.textBoxNote1.Text, pInsertar.textBoxNote2.Text, pInsertar.textBoxNote3.Text)
                );
                dataGridView1.ClearSelection();
                GetTotalAverage();
            }
        }

        private void modificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PAlumnoMod pModificar = new PAlumnoMod();
                pModificar.caption = "Modificar Alumno";
                string[] notas = dataGridView1.SelectedRows[0].Cells[5].Value.ToString().Split(',');
                pModificar.textBoxNote1.Text = notas[0].Replace('.',',');
                pModificar.textBoxNote2.Text = notas[1].Replace(" ","").Replace('.',','); ;
                pModificar.textBoxNote3.Text = notas[2].Replace(" ","").Replace('.',','); ;
                pModificar.textBoxCode.ReadOnly = true;
                pModificar.textBoxCode.Text = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();
                pModificar.textBoxName.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                pModificar.textBoxLName.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
                pModificar.textBoxPhone.Text = dataGridView1.SelectedRows[0].Cells[3].Value.ToString();
                pModificar.textBoxProvince.Text = dataGridView1.SelectedRows[0].Cells[4].Value.ToString();

                if (pModificar.ShowDialog() == DialogResult.OK)
                {
                    dataGridView1.SelectedRows[0].Cells[0].Value = pModificar.textBoxCode.Text;
                    dataGridView1.SelectedRows[0].Cells[1].Value = pModificar.textBoxName.Text;
                    dataGridView1.SelectedRows[0].Cells[2].Value = pModificar.textBoxLName.Text;
                    dataGridView1.SelectedRows[0].Cells[3].Value = pModificar.textBoxPhone.Text;
                    dataGridView1.SelectedRows[0].Cells[4].Value = pModificar.textBoxProvince.Text;
                    dataGridView1.SelectedRows[0].Cells[5].Value =
                        pModificar.textBoxNote1.Text.Replace(',', '.') + ", " +
                        pModificar.textBoxNote2.Text.Replace(',', '.') + ", " +
                        pModificar.textBoxNote3.Text.Replace(',', '.');
                    dataGridView1.SelectedRows[0].Cells[6].Value = GetStudentAverage(
                        pModificar.textBoxNote1.Text, 
                        pModificar.textBoxNote2.Text, 
                        pModificar.textBoxNote3.Text
                    );
                    dataGridView1.ClearSelection();
                    GetTotalAverage();
                }
            }
            else { MessageBox.Show("No se ha seleccionado ninguna fila."); }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                if (MessageBox.Show("¿Seguro que quieres borrar este alumno?", "Borrar", MessageBoxButtons.OKCancel) == DialogResult.OK)
                {
                    dataGridView1.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                    dataGridView1.ClearSelection();
                    GetTotalAverage();
                }
            }
            else { MessageBox.Show("No se ha seleccionado ninguna fila."); }
        }
    }
}
