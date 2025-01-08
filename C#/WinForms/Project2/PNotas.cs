using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Project2
{
    public partial class PNotas : Form
    {
        public PNotas()
        {
            InitializeComponent();
        }

        public class ComboBoxStudent
        {
            public int Code { get; set; }
            public string Name { get; set; }
            public ComboBoxStudent (int code, string name)
            {
                this.Code = code;
                this.Name = name;
            }
            public override string ToString()
            {
                return Name;
            }
        }

        private void PNotas_Load(object sender, EventArgs e)
        {
            dataGridScores1.Rows.Add(1001, "Matemáticas", 5.2);
            dataGridScores1.Rows.Add(1002, "Matemáticas", 9.0);
            dataGridScores1.Rows.Add(1003, "Matemáticas", 6.5);
            dataGridScores1.Rows.Add(1004, "Matemáticas", 8.0);
            dataGridScores1.Rows.Add(1005, "Matemáticas", 9.0);
            dataGridScores1.Rows.Add(1001, "Biología", 8.5);
            dataGridScores1.Rows.Add(1002, "Física", 4.0);
            dataGridScores1.Rows.Add(1003, "Química", 6.8);
            dataGridScores1.Rows.Add(1004, "Historia", 5.0);
            dataGridScores1.Rows.Add(1005, "Filosofía", 8.4);

            comboBoxStudents.Items.Add("Todos los alumnos");
            comboBoxStudents.Items.Add(new ComboBoxStudent(1001, "Ana Pérez"));
            comboBoxStudents.Items.Add(new ComboBoxStudent(1002, "Laura López"));
            comboBoxStudents.Items.Add(new ComboBoxStudent(1003, "Luis Casillas"));
            comboBoxStudents.Items.Add(new ComboBoxStudent(1004, "José Medina"));
            comboBoxStudents.Items.Add(new ComboBoxStudent(1005, "María Sánchez"));

            foreach (DataGridViewRow row in dataGridScores1.Rows)
            {
                if (row.Cells[0].Value != null)
                    row.Visible = false;
            }
        }

        private void comboBoxStudents_SelectedIndexChanged(object sender, EventArgs e)
        {
            dataGridScores1.ClearSelection();
            if (comboBoxStudents.SelectedIndex == 0)
            {
                foreach (DataGridViewRow row in dataGridScores1.Rows)
                {
                    row.Visible = true;
                }
            }
            else
            { 
                for (int i = 0; i < dataGridScores1.Rows.Count; i++)
                {
                    dataGridScores1.Rows[i].Visible = false;
                }
                for (int j = 0; j < dataGridScores1.Rows.Count; j++)
                {
                    if (dataGridScores1.Rows[j].Cells[0].Value.ToString().Equals((comboBoxStudents.SelectedItem as ComboBoxStudent).Code.ToString()))
                    {
                        dataGridScores1.Rows[j].Visible = true;
                    }

                }
            }
        }
    }
}
