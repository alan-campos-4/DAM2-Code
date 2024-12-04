using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Practica_GestionClinica
{
    internal class Global
    {
        //public Global() { }

        public string ConnectionString()
        {
            return "Server=localhost;Database=clínica veterinaria;User ID=root;Password=root;SslMode=none";
        }

        public DialogResult ShowWarning(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
        }

        public DialogResult ShowError(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        public string GenerateNewID(string Table, int IDbase)
        {
            MySqlConnection connection = new MySqlConnection(ConnectionString());
            connection.Open();

            string query = "SELECT ID_CL FROM "+Table;
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, ConnectionString());
            DataTable DT = new DataTable();
            adapter.Fill(DT);
            int rowCount = DT.Rows.Count;

            connection.Close();

            return (IDbase + rowCount + 1).ToString();
        }
    }
}
