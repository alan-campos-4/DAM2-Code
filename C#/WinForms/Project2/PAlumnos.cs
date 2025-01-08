using System;
using System.Drawing;
using System.Windows.Forms;

namespace WinForms_Project2
{
    public partial class PAlumnos : Form
    {
        public PAlumnos()
        {
            InitializeComponent();
        }

        private void PAlumnos_Load(object sender, EventArgs e)
        {
            dataGridStudents.ClearSelection();
            dataGridStudents.BackgroundColor = Color.White;
            dataGridStudents.Rows.Add(1001, "Ana", "Pérez", "563563");
            dataGridStudents.Rows.Add(1002, "Laura", "López", "464652");
            dataGridStudents.Rows.Add(1003, "Luis", "Casillas", "713713");
            dataGridStudents.Rows.Add(1004, "José", "Medina", "758728");
            dataGridStudents.Rows.Add(1005, "María", "Sánchez", "149149");

            dataGridScores.ClearSelection();
            dataGridScores.BackgroundColor = Color.White;
            dataGridScores.Rows.Add(1001, "Matemáticas", 5.2);
            dataGridScores.Rows.Add(1002, "Matemáticas", 9.0);
            dataGridScores.Rows.Add(1003, "Matemáticas", 6.5);
            dataGridScores.Rows.Add(1004, "Matemáticas", 8.0);
            dataGridScores.Rows.Add(1005, "Matemáticas", 9.0);
            dataGridScores.Rows.Add(1001, "Biología", 8.5);
            dataGridScores.Rows.Add(1002, "Física", 4.0);
            dataGridScores.Rows.Add(1003, "Química", 6.8);
            dataGridScores.Rows.Add(1004, "Historia", 5.0);
            dataGridScores.Rows.Add(1005, "Filosofía", 8.4);

            foreach (DataGridViewRow row in dataGridScores.Rows)
            {
                row.Visible = false;
            }

            updateAverageScore();
        }






        private void altaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAlumnosAlta PAltaAlumno = new PAlumnosAlta();
            PAltaAlumno.usedCodes = new string[dataGridStudents.Rows.Count];
            for (int i = 0; i< dataGridStudents.Rows.Count; i++)
            {
                PAltaAlumno.usedCodes[i] = dataGridStudents.Rows[i].Cells[0].Value != null ? dataGridStudents.Rows[i].Cells[0].Value.ToString() : string.Empty;
            }
            if (PAltaAlumno.ShowDialog() == DialogResult.OK)
            {
                dataGridStudents.Rows.Add(
                    PAltaAlumno.textBoxCode.Text,
                    PAltaAlumno.textBoxName1.Text,
                    PAltaAlumno.textBoxName2.Text,
                    PAltaAlumno.textBoxPhone.Text
                );
            }

        }

        private void modificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (rowSelected(dataGridStudents))
            {
                PAlumnosMod PantallaAlta = new PAlumnosMod();
                PantallaAlta.textBoxCode.Text = dataGridStudents.SelectedRows[0].Cells[0].Value.ToString();
                PantallaAlta.textBoxName1.Text = dataGridStudents.SelectedRows[0].Cells[1].Value.ToString();
                PantallaAlta.textBoxName2.Text = dataGridStudents.SelectedRows[0].Cells[2].Value.ToString();
                PantallaAlta.textBoxPhone.Text = dataGridStudents.SelectedRows[0].Cells[3].Value.ToString();
                if (PantallaAlta.ShowDialog() == DialogResult.OK)
                {
                    dataGridStudents.SelectedRows[0].Cells[1].Value = PantallaAlta.textBoxName1.Text;
                    dataGridStudents.SelectedRows[0].Cells[2].Value = PantallaAlta.textBoxName2.Text;
                    dataGridStudents.SelectedRows[0].Cells[3].Value = PantallaAlta.textBoxPhone.Text;
                }
            }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (rowSelected(dataGridStudents))
            {
                if (confirmDeleteMessage("Alumno", "este alumno y sus notas"))
                {
                    dataGridStudents.Rows.RemoveAt(dataGridStudents.SelectedRows[0].Index);

                    for (int i = 0; i < dataGridScores.Rows.Count; i++)
                    {
                        if ((dataGridScores.Rows[i].Cells[0].Value.ToString() == null) &&
                            (dataGridScores.Rows[i].Cells[0].Value.ToString().Equals(dataGridStudents.SelectedRows[0].Cells[0].Value.ToString())))
                        {
                            dataGridScores.Rows.Remove(dataGridScores.Rows[i]);
                        }
                    }
                }
            }
        }






        private void buttonScoreAdd_Click(object sender, EventArgs e)
        {
            if (rowSelected(dataGridStudents))
            {
                PNotasAlta PantallaNota = new PNotasAlta();
                PantallaNota.textBoxStudent.Text =
                    dataGridStudents.SelectedRows[0].Cells[1].Value.ToString() + " " +
                    dataGridStudents.SelectedRows[0].Cells[2].Value.ToString();
                if (PantallaNota.ShowDialog() == DialogResult.OK)
                {
                    dataGridScores.Rows.Add(
                        dataGridStudents.SelectedRows[0].Cells[0].Value.ToString(),
                        PantallaNota.textBoxSubject.Text,
                        PantallaNota.textBoxScore.Text
                    );
                    updateAverageScore();
                }
            }
        }

        private void buttonScoreMod_Click(object sender, EventArgs e)
        {
            if (rowSelected(dataGridScores))
            {
                PNotasModificar PantallaModNota = new PNotasModificar();
                PantallaModNota.textBoxStudent.Text =
                    dataGridStudents.SelectedRows[0].Cells[1].Value.ToString() + " " +
                    dataGridStudents.SelectedRows[0].Cells[2].Value.ToString();
                PantallaModNota.textBoxSubject.Text = dataGridScores.SelectedRows[0].Cells[1].Value.ToString();
                PantallaModNota.textBoxScore.Text = dataGridScores.SelectedRows[0].Cells[2].Value.ToString();
                if (PantallaModNota.ShowDialog() == DialogResult.OK)
                {
                    dataGridScores.SelectedRows[0].Cells[1].Value = PantallaModNota.textBoxSubject.Text;
                    dataGridScores.SelectedRows[0].Cells[2].Value = PantallaModNota.textBoxScore.Text;
                    updateAverageScore();
                }
            }
        }

        private void buttonScoreDelete_Click(object sender, EventArgs e)
        {
            if (rowSelected(dataGridScores))
            {
                if (confirmDeleteMessage("Nota", "esta nota"))
                {
                    dataGridScores.Rows.RemoveAt(dataGridScores.SelectedRows[0].Index);
                    updateAverageScore();
                }
            }
        }






        private void dataGridStudents_MouseClick(object sender, MouseEventArgs e)
        {
            dataGridScores.ClearSelection();
            for (int i = 0; i < dataGridScores.Rows.Count; i++)
            {
                dataGridScores.Rows[i].Visible = false;
            }
            for (int j = 0; j < dataGridScores.Rows.Count; j++)
            {
                if (dataGridScores.Rows[j].Cells[0].Value == null)
                {
                    showErrorMB(dataGridScores.Name, "La celda de notas tiene valor nulo");
                }
                else
                {
                    if (dataGridScores.Rows[j].Cells[0].Value.ToString() == dataGridStudents.SelectedRows[0].Cells[0].Value.ToString())
                    {
                        dataGridScores.Rows[j].Visible = true;
                    }
                }
            }
            updateAverageScore();
        }

        public void updateAverageScore()
        {
            int total = 0;
            double sum = 0;
            for (int i = 0; i < dataGridScores.Rows.Count; i++)
            {
                DataGridViewRow row = dataGridScores.Rows[i];
                if (row.Visible == true)
                {
                    if (double.TryParse(row.Cells[2].Value.ToString(), out double scoreValue))
                    {
                        sum += scoreValue;
                        total++;
                    }
                    else { labelAvg.Text = "Cell not parsed"; }
                }
            }
            if (total > 0)
                { labelAvg.Text = "Media = " + (sum / total).ToString(); }
            else
                { labelAvg.Text = ""; }
        }

        public bool rowSelected(DataGridView dg)
        {
            if (dg.SelectedRows.Count > 0)
            {
                if (dg.SelectedRows[0].Cells[0].Value != null)
                {
                    return true;
                }
                else { showErrorMB(dg.Name, "No se puede seleccionar esta fila."); }
            }
            else { showErrorMB(dg.Name, "No se ha seleccionado ninguna fila."); }
            return false;
        }

        public bool confirmDeleteMessage(string title, string obj)
        {
            return MessageBox.Show("¿Quieres borrar " + obj + "?", "Borrar " + title,
                MessageBoxButtons.OKCancel, MessageBoxIcon.Warning)
                == DialogResult.OK;
        }

        public void showErrorMB(string name, string msg)
        {
            MessageBox.Show(msg, "Error en "+name, MessageBoxButtons.OK, MessageBoxIcon.Error);
        }




        
    }
}
