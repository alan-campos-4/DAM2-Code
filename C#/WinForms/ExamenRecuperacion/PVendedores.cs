using System;
using MySql.Data.MySqlClient;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExamenRecuperacion
{
    public partial class PVendedores : Form1
    {
        public PVendedores()
        {
            InitializeComponent();
            
        }

        private void PVendedores_Load(object sender, EventArgs e)
        {
            ReloadDataTable();
        }

        private void ReloadDataTable()
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT Codigo, Nombre, Apellidos, Provincia, Poblacion, Telefono FROM Vendedores";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable DT = new DataTable();
            adapter.Fill(DT);
            dataGridView1.DataSource = DT;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dataGridView1.Columns["Codigo"].Visible = false;
            connection.Close();
        }

        private void AltaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string title = "Alta de vendedor";
            PModVendedores pAdd = new PModVendedores { Text = title };
            if (pAdd.ShowDialog()==DialogResult.OK)
            {
                try
                {
                    MySqlConnection connection = new MySqlConnection(connectionString);
                    connection.Open();

                    string sql = "INSERT INTO Vendedores " +
                        "(Nombre, Apellidos, Provincia, Poblacion, Telefono, FechaAlta) VALUES " +
                        "(@nom, @apell, @provin, @poblac, @tel, @fecha)";
                    var comando = new MySqlCommand(sql, connection);
                    comando.Parameters.AddWithValue("@nom", pAdd.textBoxFName.Text);
                    comando.Parameters.AddWithValue("@apell", pAdd.textBoxLName.Text);
                    comando.Parameters.AddWithValue("@provin", pAdd.comboBoxProvince.Text);
                    comando.Parameters.AddWithValue("@poblac", pAdd.textBoxCity.Text);
                    comando.Parameters.AddWithValue("@tel", pAdd.textBoxPhone.Text);
                    comando.Parameters.AddWithValue("@fecha", pAdd.dateTimePicker1.Value);
                    int filasAfectadas = comando.ExecuteNonQuery();
                    connection.Close();

                    if (filasAfectadas > 0)
                    {
                        ShowConfirm(title, "Se han añadido los datos correctamente.");
                        ReloadDataTable();
                    }
                    else { ShowError(this.Text, "No se ha añadido ninguna fila."); }
                }
                catch (MySqlException ex) { ShowError(this.Text, ex.Message); }
            }
        }

        private void ModificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                string title = "Modificar vendedor";
                PModVendedores pMod = new PModVendedores { Text = title };
                pMod.textBoxFName.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                pMod.textBoxLName.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
                pMod.comboBoxProvince.Text = dataGridView1.SelectedRows[0].Cells[3].Value.ToString();
                pMod.textBoxCity.Text = dataGridView1.SelectedRows[0].Cells[4].Value.ToString();
                pMod.textBoxPhone.Text = dataGridView1.SelectedRows[0].Cells[5].Value.ToString();
                //pMod.dateTimePicker1.Value = DateTime.Parse(dataGridView1.SelectedRows[0].Cells[6].Value.ToString());
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();

                        string sql = "UPDATE Vendedores SET" +
                            "Nombre=@nom, Apellidos=@apell, Provincia=@provin, Poblacion=@poblac, Telefono=@tel, FechaAlta=@fecha "+
                            "WHERE Codigo=@cod";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@cod", dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
                        comando.Parameters.AddWithValue("@nom", pMod.textBoxFName.Text);
                        comando.Parameters.AddWithValue("@apell", pMod.textBoxLName.Text);
                        comando.Parameters.AddWithValue("@provin", pMod.comboBoxProvince.Text);
                        comando.Parameters.AddWithValue("@poblac", pMod.textBoxCity.Text);
                        comando.Parameters.AddWithValue("@tel", pMod.textBoxPhone.Text);
                        comando.Parameters.AddWithValue("@fecha", pMod.dateTimePicker1.Value);
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            ShowConfirm(title, "Se han modificado los datos correctamente.");
                            ReloadDataTable();
                        }
                        else { ShowError(this.Text, "No se ha modificado ninguna fila."); }
                    }
                    catch (MySqlException ex) { ShowError(this.Text, ex.Message); }
                }
            }
        }

        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                string title = "Baja de vendedor";
                if (ShowWarning(title, "¿Estás seguro de que quieres borrar \neste vendedor?") == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();
                        string sql = "DELETE FROM Vendedores WHERE Codigo=@cod";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@cod", dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            ShowConfirm(title, "Se han borrado los datos correctamente.");
                            ReloadDataTable();
                        }
                        else { ShowError(this.Text, "No se ha borrado ninguna fila."); }
                    }
                    catch (MySqlException ex) { ShowError(this.Text, ex.Message); }
                }
            }
        }

        private void DataGridView1_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PShowVendedores Descripcion = new PShowVendedores();
                Descripcion.textBoxFName.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                Descripcion.textBoxLName.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
                Descripcion.textBoxProvince.Text = dataGridView1.SelectedRows[0].Cells[3].Value.ToString();
                Descripcion.textBoxCity.Text = dataGridView1.SelectedRows[0].Cells[4].Value.ToString();
                Descripcion.textBoxPhone.Text = dataGridView1.SelectedRows[0].Cells[5].Value.ToString();
                
                //Descripcion.dateTimePicker1.Value = DateTime.Parse(dataGridView1.SelectedRows[0].Cells[6].Value.ToString());

                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();
                string query = "SELECT Importe, Fecha FROM Ventas WHERE CodigoVendedor=@cod";
                var comando = new MySqlCommand(query, connection);
                comando.Parameters.AddWithValue("@cod", dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
                MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    Descripcion.listBox1.Items.Add(reader["Importe"] + " - " + reader["Fecha"]);
                }
                connection.Close();

                Descripcion.ShowDialog();
            }
        }

        private void DataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                double total = 0.0;
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                string query = "SELECT Importe FROM Ventas WHERE CodigoVendedor=@CodVen";
                var command = new MySqlCommand(query, connection);
                command.Parameters.AddWithValue("@CodVen", dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
                MySqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    if (double.TryParse(reader["Importe"].ToString(), out double n))
                    {
                        total += n;
                    }
                }
                connection.Close();

                labelTotal.Text = total.ToString();
            }
        }


    }
}
