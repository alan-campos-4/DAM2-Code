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
        public Global() { }

        public string ConnectionString()
        {
            return "Server=localhost;Database=clínica veterinaria;User ID=root;Password=SyncDeezNuts99...;SslMode=none";
        }

        public DialogResult ShowWarning(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
        }

        public DialogResult ShowError(string message)
        {
            return MessageBox.Show(message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        public string GenerateNewID(string Table)
        {
            if (Table=="clientes" || Table=="mascotas")
            {
                MySqlConnection connection = new MySqlConnection(ConnectionString());
                connection.Open();

                string query = "SELECT Nombre FROM " + Table;
                MySqlDataAdapter adapter = new MySqlDataAdapter(query, ConnectionString());
                DataTable DT = new DataTable();
                adapter.Fill(DT);
                int rowCount = DT.Rows.Count;

                connection.Close();

                if (Table=="clientes")
                    return (1000 + rowCount + 1).ToString();
                else
                    return (10000 + rowCount).ToString();
            }
            else
            {
                Random rnd = new Random();
                return (rnd.Next(100000, 999999)).ToString();
            }
        }



        /*
         La aplicación debe ser capaz de manejar errores comunes, 
        como intentos de agregar un cliente con un correo electrónico duplicado 
        o de eliminar registros relacionados (por ejemplo, eliminar un cliente con mascotas o citas asociadas).

        El sistema debe mostrar mensajes de confirmación o advertencia cuando se realicen acciones críticas 
        (como eliminar registros).

        El sistema debe controlar intentos de introducir información errónea como CP inexistentes, 
        número en un nombre, letra incorrecta en un DNI, etc… 
        y deberá mostraros estos errores con claridad al lado de cada componente fallido.
         */
    }
}
