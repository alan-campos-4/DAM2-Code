using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Examen2
{
    public partial class PPrincipal : Form
    {
        public PPrincipal()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

        private void Form1_Load(object sender, EventArgs e)
        {
            ReloadDataGrid();
        }

        private void ReloadDataGrid()
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            
            string query = "SELECT A.Codigo, A.Descripcion, F.Descripcion AS Familia, A.Precio, A.Stock FROM articulos A JOIN familias F ON A.CodFamilia=F.Codigo";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable tableArticulos = new DataTable();
            adapter.Fill(tableArticulos);
            dataGridView1.DataSource = tableArticulos;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dataGridView1.Columns["Descripcion"].AutoSizeMode = DataGridViewAutoSizeColumnMode.DisplayedCells;

            connection.Close();
        }

        private void EstadísticasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PStats pStats = new PStats();
            pStats.ShowDialog();
        }

        private void AltaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PAlta pAdd = new PAlta { Text = g.AddTitle };
            if (pAdd.ShowDialog()==DialogResult.OK)
            {
                if (g.ShowWarning(g.AddTitle, "¿Son los datos correctos?") == DialogResult.OK)
                {
                    MySqlConnection connection = new MySqlConnection(connectionString);
                    connection.Open();

                    string sql = "INSERT INTO articulos VALUES (@code, @desc, @price, @stck, @fam)";
                    var comando = new MySqlCommand(sql, connection);
                    comando.Parameters.AddWithValue("@code", pAdd.textBoxCode.Text);
                    comando.Parameters.AddWithValue("@desc", pAdd.textBoxDesc.Text);
                    comando.Parameters.AddWithValue("@price", pAdd.textBoxPrice.Text);
                    comando.Parameters.AddWithValue("@stck", pAdd.textBoxStock.Text);
                    comando.Parameters.AddWithValue("@fam", pAdd.comboBoxFamily.Text);
                    int filasAfectadas = comando.ExecuteNonQuery();
                    connection.Close();

                    if (filasAfectadas > 0)
                    {
                        g.ShowConfirm(g.AddTitle, "Se han añadido los datos correctamente.");
                        ReloadDataGrid();
                    }
                    else { g.ShowError("No se ha añadido ninguna fila."); }
                }
            }
        }

        private void ModificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PAlta pMod = new PAlta { Text = g.ModTitle };
                pMod.textBoxCode.ReadOnly = true;
                pMod.textBoxCode.Text = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();
                pMod.textBoxDesc.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
                pMod.textBoxPrice.Text = dataGridView1.SelectedRows[0].Cells[3].Value.ToString();
                pMod.textBoxStock.Text = dataGridView1.SelectedRows[0].Cells[4].Value.ToString();
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    if (g.ShowConfirm(g.ModTitle, "¿Son los datos correctos?") == DialogResult.OK)
                    {
                        string idMod = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();

                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();

                        string sql = "UPDATE SET Descripcion=@desc, Precio=@price, Stock=@stck, CodFamilia=@fam" +
                            " FROM articulos WHERE id = @id";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@desc", pMod.textBoxDesc.Text);
                        comando.Parameters.AddWithValue("@price", pMod.textBoxPrice.Text);
                        comando.Parameters.AddWithValue("@stck", pMod.textBoxStock.Text);
                        comando.Parameters.AddWithValue("@fam", pMod.comboBoxFamily.SelectedValue);
                        comando.Parameters.AddWithValue("@id", idMod);
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            g.ShowConfirm(g.ModTitle, "Se han añadido los datos correctamente.");
                            ReloadDataGrid();
                        }
                        else { g.ShowError("No se ha modificado ninguna fila."); }
                    }
                }
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }

        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                if (g.ShowWarning("Borrar Artículo", "¿Seguro que quieres borrar este artículo?") == DialogResult.OK)
                {
                    try
                    {
                        dataGridView1.Rows.RemoveAt(dataGridView1.SelectedRows[0].Index);
                        string idAEliminar = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();

                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();
                        string sql = "DELETE FROM articulos WHERE Codigo=@id";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@id", idAEliminar);
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            g.ShowConfirm("Borrar Artículo", "Se han borrado los datos correctamente.");
                            ReloadDataGrid();
                        }
                        else { g.ShowError("No se ha borrado ninguna fila."); }
                    }
                    catch (MySql.Data.MySqlClient.MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }

        private void CategoríasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PCategorias pCategorias = new PCategorias();
            pCategorias.ShowDialog();
        }

        private void buscadorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                PBuscar pBuscar = new PBuscar();
                pBuscar.ShowDialog();
            }
            else { g.ShowError("No se puede realizar esta acción\nsin seleccionar una fila."); }
        }
    }
}
