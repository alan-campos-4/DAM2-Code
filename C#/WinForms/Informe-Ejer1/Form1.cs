﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Informe_Ejer1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'DataSet1.inmuebles' Puede moverla o quitarla según sea necesario.
            this.inmueblesTableAdapter.Fill(this.DataSet1.inmuebles);

            this.reportViewer1.RefreshReport();
        }
    }
}
