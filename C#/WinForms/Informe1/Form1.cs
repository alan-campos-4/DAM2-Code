﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Informe1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'coches.coches' Puede moverla o quitarla según sea necesario.
            this.cochesTableAdapter.Fill(this.coches.coches);

            this.reportViewer1.RefreshReport();
        }

        private void VerPorMarcaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            
            form2.ShowDialog();
        }
    }
}
