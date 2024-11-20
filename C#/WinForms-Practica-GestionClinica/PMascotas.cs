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
    public partial class PMascotas : Form
    {
        public PMascotas()
        {
            InitializeComponent();
        }

        public string connectionString = "Server=localhost;Database=clínica veterinaria;User ID=root;Password=root;SslMode=none";
        public DataTable tableClients;
        public MySqlDataAdapter adapter;

        private void PMascotas_Load(object sender, EventArgs e)
        {

        }
    }
}
