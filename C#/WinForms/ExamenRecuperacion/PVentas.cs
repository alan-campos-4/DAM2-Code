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

namespace ExamenRecuperacion
{
    public partial class PVentas : Form1
    {
        public PVentas()
        {
            InitializeComponent();
        }

        private void PVentas_Load(object sender, EventArgs e)
        {
            ReloadDataTable();
            dataGridView1.ClearSelection();
        }

        public void ReloadDataTable()
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT VT.Codigo, CONCAT(Apellidos,', ',Nombre) AS Vendedor, Importe " +
                "FROM Ventas VT JOIN Vendedores VD ON VT.CodigoVendedor=VD.Codigo";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable DT = new DataTable();
            adapter.Fill(DT);
            dataGridView1.DataSource = DT;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dataGridView1.Columns["Codigo"].Visible = false;
            connection.Close();
        }

        private void NuevaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string title = "Nueva venta";
            PModVentas pAdd = new PModVentas { Text = title };
            if (pAdd.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    MySqlConnection connection = new MySqlConnection(connectionString);
                    connection.Open();

                    string sql = "INSERT INTO Ventas " +
                        "(CodigoVendedor, Importe, Fecha) VALUES " +
                        "(@code, @price, @date)";
                    var comando = new MySqlCommand(sql, connection);
                    comando.Parameters.AddWithValue("@code", pAdd.comboBoxSeller.SelectedValue);
                    comando.Parameters.AddWithValue("@price", pAdd.textBoxPrice.Text);
                    comando.Parameters.AddWithValue("@date", pAdd.dateTimePicker1.Value);
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
                string title = "Modificar venta";
                PModVentas pMod = new PModVentas { Text = title };
                pMod.comboBoxSeller.SelectedValue = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                pMod.textBoxPrice.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
                //pMod.dateTimePicker1.Value = DateTime.Parse(dataGridView1.SelectedRows[0].Cells[6].Value.ToString());
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();

                        string sql = "UPDATE Ventas SET " +
                            "CodigoVendedor=@codev, Importe=@price, Fecha=@date " +
                            "WHERE Codigo=@cod";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@cod", dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
                        comando.Parameters.AddWithValue("@codev", pMod.comboBoxSeller.SelectedValue);
                        comando.Parameters.AddWithValue("@price", pMod.textBoxPrice.Text);
                        comando.Parameters.AddWithValue("@date", pMod.dateTimePicker1.Value);
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            ShowConfirm(title, "Se han modificado los datos correctamente.");
                            ReloadDataTable();
                        }
                        else { ShowError(this.Text, "No se ha moficado ninguna fila."); }
                    }
                    catch (MySqlException ex) { ShowError(this.Text, ex.Message); }
                }
            }
        }

        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                string title = "Borrar venta";
                if (ShowWarning(title, "¿Estás seguro de que quieres borrar \nesta venta?") == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();
                        string sql = "DELETE FROM Ventas WHERE Codigo=@cod";
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


    }
}
