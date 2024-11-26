using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Practica_GestionClinica
{
    internal class Global
    {
        public Global() { }

        public string connectionString()
        {
            return "Server=localhost;Database=clínica veterinaria;User ID=root;Password=root;SslMode=none";
        }

        public DialogResult showWarning(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
        }

        public DialogResult showError(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
    }
}
