using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Practica_GestionClinica
{
    public partial class PCitas : Form
    {
        public PCitas()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnectionString();

        private void PCitas_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = 
                "SELECT ID_CT, Fecha_Hora, M.Especie, M.Nombre, Motivo " +
                "FROM citas CT JOIN clientes CL ON CT.Cliente=CL.ID_CL " +
                "JOIN mascotas M ON CT.Mascota=M.ID_M";
            DataTable tableClients = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            adapter.Fill(tableClients);
            dataGridView1.DataSource = tableClients;
            dataGridView1.Columns["ID_CT"].Visible = false;

            string query1 = "SELECT Fecha_Hora FROM citas";
            DataTable tableCalendar = new DataTable();
            MySqlDataAdapter adapter1 = new MySqlDataAdapter(query1, connection);
            MySqlCommandBuilder commandBuilder1 = new MySqlCommandBuilder(adapter1);
            adapter1.Fill(tableCalendar);
            
            for (int i= 0; i < tableCalendar.Rows.Count; i++)
            {
                monthCalendar1.AddBoldedDate(DateTime.Parse(tableCalendar.Rows[i][1].ToString()));
            }
            monthCalendar1.Refresh();

            connection.Close();
        }
    }
}
