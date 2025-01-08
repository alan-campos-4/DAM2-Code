using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WinForms_Examen2;

namespace WF_PracticaCRUD
{
    public partial class Principal : Form
    {
        public Principal()
        {
            InitializeComponent();
        }

        static Global g = new Global();
        public string connectionString = g.ConnString();

        private void Form1_Load(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            string query = "SELECT * FROM coches ORDER BY 2, 3";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, connection);
            DataTable tableArticulos = new DataTable();
            adapter.Fill(tableArticulos);
            dataGridCars.DataSource = tableArticulos;
            dataGridCars.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dataGridCars.Columns["id"].Visible = false;
            dataGridCars.Columns["stock"].Visible = false;
            dataGridCars.Columns["descripcion"].Visible = false;
            dataGridCars.Columns["fecha_ingreso"].Visible = false;
            dataGridCars.Columns["activo"].Visible = false;

            connection.Close();
            dataGridCars.ClearSelection();
        }

        private void CreateToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string title = "Añadir Coche";
            PModificar pAdd = new PModificar {  Text = title };
            if (pAdd.ShowDialog() == DialogResult.OK)
            {
                if (g.ShowWarning(title, "¿Son los datos correctos?") == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();

                        string sql = "INSERT INTO articulos VALUES " +
                            "(@marc, @model, @ano, @price, @col, @kilom, @fuel, @trans, @doors, @stck, @desc, @date, @act)";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@marc", pAdd.textBoxMaker.Text);
                        comando.Parameters.AddWithValue("@model", pAdd.textBoxModel.Text);
                        comando.Parameters.AddWithValue("@ano", pAdd.textBoxYear.Text);
                        comando.Parameters.AddWithValue("@price", pAdd.textBoxPrice.Text);
                        comando.Parameters.AddWithValue("@col", pAdd.textBoxColor.Text);
                        comando.Parameters.AddWithValue("@kilom", pAdd.textBoxKilom.Text);
                        comando.Parameters.AddWithValue("@fuel", pAdd.comboBoxFuel.Text);
                        comando.Parameters.AddWithValue("@trans", pAdd.comboBoxTrans.Text);
                        comando.Parameters.AddWithValue("@doors", pAdd.comboBoxDoors.Text);
                        comando.Parameters.AddWithValue("@stck", pAdd.textBoxStock.Text);
                        comando.Parameters.AddWithValue("@desc", pAdd.richTextBox1.Text);
                        comando.Parameters.AddWithValue("@date", pAdd.dateTimePicker1.Text);
                        comando.Parameters.AddWithValue("@act", pAdd.comboBoxActive.Text);
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            g.ShowConfirm(title, "Se han añadido los datos correctamente.");
                        }
                        else { g.ShowError("No se ha añadido ninguna fila."); }
                    }
                    catch (MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
        }

        private void ModificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridCars.SelectedRows.Count > 0)
            {
                string title = "Modificar Coche";
                PModificar pMod = new PModificar { Text = title };
                pMod.textBoxMaker.Text = dataGridCars.SelectedRows[0].Cells[1].Value.ToString();
                pMod.textBoxModel.Text = dataGridCars.SelectedRows[0].Cells[2].Value.ToString();
                pMod.textBoxYear.Text = dataGridCars.SelectedRows[0].Cells[3].Value.ToString();
                pMod.textBoxPrice.Text = dataGridCars.SelectedRows[0].Cells[4].Value.ToString();
                pMod.textBoxColor.Text = dataGridCars.SelectedRows[0].Cells[5].Value.ToString();
                pMod.textBoxKilom.Text = dataGridCars.SelectedRows[0].Cells[6].Value.ToString();
                pMod.comboBoxFuel.Text = dataGridCars.SelectedRows[0].Cells[7].Value.ToString();
                pMod.comboBoxTrans.Text = dataGridCars.SelectedRows[0].Cells[8].Value.ToString();
                pMod.comboBoxDoors.Text = dataGridCars.SelectedRows[0].Cells[9].Value.ToString();
                pMod.textBoxStock.Text = dataGridCars.SelectedRows[0].Cells[10].Value.ToString();
                pMod.richTextBox1.Text = dataGridCars.SelectedRows[0].Cells[11].Value.ToString();
                pMod.dateTimePicker1.Text = dataGridCars.SelectedRows[0].Cells[12].Value.ToString();
                pMod.comboBoxActive.Text = dataGridCars.SelectedRows[0].Cells[13].Value.ToString();
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    if (g.ShowWarning(title, "¿Son los datos correctos?") == DialogResult.OK)
                    {
                        try
                        {
                            MySqlConnection connection = new MySqlConnection(connectionString);
                            connection.Open();

                            string sql = "UPDATE coches SET " +
                                "marca=@marc, modelo=@model, año=@ano, precio=@price, " +
                                "color=@col, kilometraje=@kilom, combustible=@fuel, transmisión=@trans, puertas=@doors, " +
                                "stock=@stck, descripcion=@desc, fecha_ingreso=@date, activo=@act) " +
                                "WHERE id=@codigo";
                            var comando = new MySqlCommand(sql, connection);
                            comando.Parameters.AddWithValue("@codigo", dataGridCars.SelectedRows[0].Cells[0].Value.ToString());
                            comando.Parameters.AddWithValue("@marc", pMod.textBoxMaker.Text);
                            comando.Parameters.AddWithValue("@model", pMod.textBoxModel.Text);
                            comando.Parameters.AddWithValue("@ano", pMod.textBoxYear.Text);
                            comando.Parameters.AddWithValue("@price", pMod.textBoxPrice.Text);
                            comando.Parameters.AddWithValue("@col", pMod.textBoxColor.Text);
                            comando.Parameters.AddWithValue("@kilom", pMod.textBoxKilom.Text);
                            comando.Parameters.AddWithValue("@fuel", pMod.comboBoxFuel.Text);
                            comando.Parameters.AddWithValue("@trans", pMod.comboBoxTrans.Text);
                            comando.Parameters.AddWithValue("@doors", pMod.comboBoxDoors.Text);
                            comando.Parameters.AddWithValue("@stck", pMod.textBoxStock.Text);
                            comando.Parameters.AddWithValue("@desc", pMod.richTextBox1.Text);
                            comando.Parameters.AddWithValue("@date", pMod.dateTimePicker1.Text);
                            comando.Parameters.AddWithValue("@act", pMod.comboBoxActive.Text);
                            int filasAfectadas = comando.ExecuteNonQuery();
                            connection.Close();

                            if (filasAfectadas > 0)
                            {
                                g.ShowConfirm(title, "Se han modificado los datos correctamente.");
                            }
                            else { g.ShowError("No se ha modificado ninguna fila."); }
                        }
                        catch (MySqlException ex) { g.ShowError(ex.Message); }
                    }
                }
            }
            else { g.ShowError("Debes seleccionar una fila."); }
        }

        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridCars.SelectedRows.Count > 0)
            {
                string title = "Borrar coche";
                if (g.ShowWarning(title, "¿Estás seguro de que quieres borrar este coche?") == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();

                        string sql = "DELETE FROM coches WHERE id=@codigo";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@codigo", dataGridCars.SelectedRows[0].Cells[0].Value.ToString());
                        dataGridCars.Rows.RemoveAt(dataGridCars.SelectedRows[0].Index);

                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            g.ShowConfirm(title, "Se han borrado los datos correctamente.");
                        }
                        else { g.ShowError("No se ha borrado ninguna fila."); }
                    }
                    catch (MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
        }
    }
}
