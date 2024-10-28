using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Projecto
{
    public partial class PClientes : Form
    {
        public PClientes()
        {
            InitializeComponent();
        }

        private void altaToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            PAlta PantallaAltaCliente = new PAlta();
            if (PantallaAltaCliente.ShowDialog() == DialogResult.OK)
            {
                string cliente =
                    PantallaAltaCliente.textBoxName2.Text + ", " +
                    PantallaAltaCliente.textBoxName1.Text + " - " +
                    PantallaAltaCliente.textBoxPhone.Text;
                listBox1.Items.Add(cliente);
            }
        }

        private void modificarToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            if (listBox1.Items.Count > 0)
            {
                PModificar PantallaModificar = new PModificar();
                if (listBox1.SelectedIndex > -1)
                {
                    string cliente = listBox1.SelectedItems.ToString();
                    string[] datos = cliente.Split(new string[] { ", ", " - " }, StringSplitOptions.RemoveEmptyEntries);
                    
                    PantallaModificar.textBoxName2.Text = datos[0].ToString();
                    PantallaModificar.textBoxName1.Text = datos[1].ToString();
                    PantallaModificar.textBoxPhone.Text = datos[2].ToString();
                    if (PantallaModificar.ShowDialog() == DialogResult.OK)
                    {
                        string nuevocliente =
                            PantallaModificar.textBoxName2.Text + ", " +
                            PantallaModificar.textBoxName1.Text + " - " +
                            PantallaModificar.textBoxPhone.Text;
                        listBox1.Items.Add(nuevocliente);
                    }
                }
            }
        }

        private void bajaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listBox1.Items.Count > 0)
            {
                if (listBox1.SelectedIndex > -1)
                {
                    listBox1.Items.RemoveAt(listBox1.SelectedIndex);
                }
            }
        }

        private void listBox1_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            /*int index = this.listBox1.IndexFromPoint(e.Location);
            if (index != System.Windows.Forms.ListBox.NoMatches)
            {
                MessageBox.Show(index.ToString());
            }*/
            if (listBox1.Items.Count > 0)
            {
                if (listBox1.SelectedIndex > -1)
                {
                    string cliente = listBox1.SelectedItems.ToString();
                    string[] datos = cliente.Split(new string[] { ", ", " - " }, StringSplitOptions.RemoveEmptyEntries);

                    PMostrar PantallaMostrarCliente = new PMostrar();
                    PantallaMostrarCliente.ShowDialog();
                    PantallaMostrarCliente.labelName2.Text = datos[0].ToString();
                    PantallaMostrarCliente.labelName1.Text = datos[0].ToString();
                    PantallaMostrarCliente.labelPhone.Text = datos[0].ToString();
                }
            }
        }
    }
}