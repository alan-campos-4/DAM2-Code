using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.Reporting.WinForms;

namespace Informe1
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            this.reportViewer1.RefreshReport();
        }

        private void ButtonSearch_Click(object sender, EventArgs e)
        {
            /*
            string valorParametro = "Ejemplo";
            ReportParameter parametro = new ReportParameter("NombreParametro", valorParametro);
            reportViewer1.LocalReport.SetParameters(new ReportParameter[] { parametro });
            reportViewer1.RefreshReport();
            */

            string valorParametro = textBox1.Text;
            ReportParameter parametro = new ReportParameter("PMarca", valorParametro);
            reportViewer1.LocalReport.SetParameters(new ReportParameter[] { parametro });
            reportViewer1.RefreshReport();
        }
    }
}
