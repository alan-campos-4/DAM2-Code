using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Windows.Forms;

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
            ReloadGrid(); 
            dataGridCars.ClearSelection();
        }


        public void ReloadGrid()
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
            connection.Close();
        }


        private void CreateToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string title = "Añadir Coche";
            PModificar pAdd = new PModificar { Text = title };
            pAdd.labelNecessary.Visible = false;
            pAdd.NecessaryFieldsFull = true;
            pAdd.comboBoxFuel.SelectedIndex = 0;
            pAdd.numericUpDownDoors.Value = 5;
            pAdd.radioButtonAuto.Checked = true;
            pAdd.checkBoxAct.Checked = true;
            pAdd.dateTimePicker1.Value = DateTime.Now;

            if (pAdd.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    MySqlConnection connection = new MySqlConnection(connectionString);
                    connection.Open();

                    string sql = "INSERT INTO coches " +
                        "(marca, modelo, año, precio, color, kilometraje, combustible, transmisión, puertas, stock, descripcion) VALUES " +
                        "(@marc, @model, @ano, @price, @col, @kilom, @fuel, @trans, @doors, @stck, @desc, @date, @act)";
                    var comando = new MySqlCommand(sql, connection);
                    comando.Parameters.AddWithValue("@marc", pAdd.textBoxMaker.Text);
                    comando.Parameters.AddWithValue("@model", pAdd.textBoxModel.Text);
                    comando.Parameters.AddWithValue("@ano", pAdd.textBoxYear.Text);
                    comando.Parameters.AddWithValue("@price", pAdd.textBoxPrice.Text.Replace(',', '.'));
                    comando.Parameters.AddWithValue("@col", pAdd.textBoxColor.Text);
                    comando.Parameters.AddWithValue("@kilom", pAdd.textBoxKilom.Text);
                    comando.Parameters.AddWithValue("@fuel", pAdd.comboBoxFuel.Text);
                    comando.Parameters.AddWithValue("@trans", (pAdd.radioButtonAuto.Checked) ? "Automático" : "Manual");
                    comando.Parameters.AddWithValue("@doors", pAdd.numericUpDownDoors.Value);
                    comando.Parameters.AddWithValue("@stck", pAdd.textBoxStock.Text);
                    comando.Parameters.AddWithValue("@desc", pAdd.richTextBox1.Text);
                    comando.Parameters.AddWithValue("@date", pAdd.dateTimePicker1.Text);
                    comando.Parameters.AddWithValue("@act", pAdd.checkBoxAct.Checked.ToString());
                    int filasAfectadas = comando.ExecuteNonQuery();
                    connection.Close();

                    if (filasAfectadas > 0)
                    {
                        g.ShowConfirm(title, "Se han añadido los datos correctamente.");
                        ReloadGrid();
                    }
                    else { g.ShowError("No se ha añadido ninguna fila."); }
                }
                catch (MySqlException ex) { g.ShowError(ex.Message); }
            }
        }


        private void ModificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridCars.SelectedRows.Count > 0)
            {
                string title = "Modificar Coche";
                PModificar pMod = new PModificar { Text = title };
                pMod.labelNecessary.Visible = false;
                pMod.NecessaryFieldsFull = true;
                pMod.textBoxMaker.Text = dataGridCars.SelectedRows[0].Cells[1].Value.ToString();
                pMod.textBoxModel.Text = dataGridCars.SelectedRows[0].Cells[2].Value.ToString();
                pMod.textBoxYear.Text = dataGridCars.SelectedRows[0].Cells[3].Value.ToString();
                pMod.textBoxPrice.Text = dataGridCars.SelectedRows[0].Cells[4].Value.ToString();
                pMod.textBoxColor.Text = dataGridCars.SelectedRows[0].Cells[5].Value.ToString();
                pMod.textBoxKilom.Text = dataGridCars.SelectedRows[0].Cells[6].Value.ToString();
                pMod.comboBoxFuel.Text = dataGridCars.SelectedRows[0].Cells[7].Value.ToString();
                pMod.numericUpDownDoors.Text = dataGridCars.SelectedRows[0].Cells[9].Value.ToString();
                pMod.textBoxStock.Text = dataGridCars.SelectedRows[0].Cells[10].Value.ToString();
                pMod.richTextBox1.Text = dataGridCars.SelectedRows[0].Cells[11].Value.ToString();
                pMod.dateTimePicker1.Text = dataGridCars.SelectedRows[0].Cells[12].Value.ToString();
                if (dataGridCars.SelectedRows[0].Cells[13].Value.Equals(true))
                { pMod.checkBoxAct.Checked = true; }
                if (dataGridCars.SelectedRows[0].Cells[8].Value.ToString().Equals("Automático"))
                { pMod.radioButtonAuto.Checked = true; }
                else
                { pMod.radioButtonManual.Checked = true; }
                
                if (pMod.ShowDialog() == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();

                        string sql = "UPDATE coches SET " +
                            "marca=@marc, modelo=@model, año=@ano, precio=@price, " +
                            "color=@col, kilometraje=@kilom, combustible=@fuel, transmisión=@trans, puertas=@doors, " +
                            "stock=@stck, descripcion=@desc, fecha_ingreso=@date, activo=@act " +
                            "WHERE id=@codigo";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@codigo", dataGridCars.SelectedRows[0].Cells[0].Value.ToString());
                        comando.Parameters.AddWithValue("@marc", pMod.textBoxMaker.Text);
                        comando.Parameters.AddWithValue("@model", pMod.textBoxModel.Text);
                        comando.Parameters.AddWithValue("@ano", pMod.textBoxYear.Text);
                        comando.Parameters.AddWithValue("@price", pMod.textBoxPrice.Text.Replace(',', '.'));
                        comando.Parameters.AddWithValue("@col", pMod.textBoxColor.Text);
                        comando.Parameters.AddWithValue("@kilom", pMod.textBoxKilom.Text);
                        comando.Parameters.AddWithValue("@fuel", pMod.comboBoxFuel.Text);
                        comando.Parameters.AddWithValue("@trans", (pMod.radioButtonAuto.Checked)? "Automático" : "Manual" );
                        comando.Parameters.AddWithValue("@doors", pMod.numericUpDownDoors.Value);
                        comando.Parameters.AddWithValue("@stck", pMod.textBoxStock.Text);
                        comando.Parameters.AddWithValue("@desc", pMod.richTextBox1.Text);
                        comando.Parameters.AddWithValue("@date", pMod.dateTimePicker1.Value);
                        comando.Parameters.AddWithValue("@act", pMod.checkBoxAct.Checked);
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            g.ShowConfirm(title, "Se han modificado los datos correctamente.");
                            ReloadGrid();
                        }
                        else { g.ShowError("No se ha modificado ninguna fila."); }
                    }
                    catch (MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
            else { g.ShowError("Debes seleccionar una fila."); }
        }


        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridCars.SelectedRows.Count > 0)
            {
                string title = "Borrar coche";
                string car = dataGridCars.SelectedRows[0].Cells[1].Value.ToString() + " " + dataGridCars.SelectedRows[0].Cells[2].Value.ToString();
                if (g.ShowWarning(title, "¿Estás seguro de que quieres borrar \neste coche "+car+"?") == DialogResult.OK)
                {
                    try
                    {
                        MySqlConnection connection = new MySqlConnection(connectionString);
                        connection.Open();
                        string sql = "DELETE FROM coches WHERE id=@codigo";
                        var comando = new MySqlCommand(sql, connection);
                        comando.Parameters.AddWithValue("@codigo", dataGridCars.SelectedRows[0].Cells[0].Value.ToString());
                        int filasAfectadas = comando.ExecuteNonQuery();
                        connection.Close();

                        if (filasAfectadas > 0)
                        {
                            g.ShowConfirm(title, "Se han borrado los datos correctamente.");
                            ReloadGrid();
                        }
                        else { g.ShowError("No se ha borrado ninguna fila."); }
                    }
                    catch (MySqlException ex) { g.ShowError(ex.Message); }
                }
            }
        }
        

        private void TextBoxSearch_TextChanged(object sender, EventArgs e)
        {
            dataGridCars.ClearSelection();
            foreach (DataGridViewRow row in dataGridCars.Rows)
            {
                row.Visible = true;
            }
            if (!String.IsNullOrEmpty(textBoxSearch.Text))
            {
                foreach (DataGridViewRow row in dataGridCars.Rows)
                {
                    string content = row.Cells[1].Value.ToString().ToLower() + " " + row.Cells[2].Value.ToString().ToLower();
                    string search = textBoxSearch.Text.ToLower();
                    if ( !content.Contains(search) )
                    {
                        CurrencyManager manager1 = (CurrencyManager)BindingContext[dataGridCars.DataSource];
                        manager1.SuspendBinding();
                        row.Visible = false;
                        manager1.ResumeBinding();
                    }
                }
            }
        }
        

        private void DataGridCars_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (dataGridCars.SelectedRows.Count > 0)
            {
                string title = "Mostrar Coche";
                PModificar Mostrar = new PModificar { Text = title };
                Mostrar.textBoxMaker.Text = dataGridCars.SelectedRows[0].Cells[1].Value.ToString();
                Mostrar.textBoxModel.Text = dataGridCars.SelectedRows[0].Cells[2].Value.ToString();
                Mostrar.textBoxYear.Text = dataGridCars.SelectedRows[0].Cells[3].Value.ToString();
                Mostrar.textBoxPrice.Text = dataGridCars.SelectedRows[0].Cells[4].Value.ToString();
                Mostrar.textBoxColor.Text = dataGridCars.SelectedRows[0].Cells[5].Value.ToString();
                Mostrar.textBoxKilom.Text = dataGridCars.SelectedRows[0].Cells[6].Value.ToString();
                Mostrar.comboBoxFuel.Text = dataGridCars.SelectedRows[0].Cells[7].Value.ToString();
                Mostrar.numericUpDownDoors.Text = dataGridCars.SelectedRows[0].Cells[9].Value.ToString();
                Mostrar.textBoxStock.Text = dataGridCars.SelectedRows[0].Cells[10].Value.ToString();
                Mostrar.richTextBox1.Text = dataGridCars.SelectedRows[0].Cells[11].Value.ToString();
                Mostrar.dateTimePicker1.Text = dataGridCars.SelectedRows[0].Cells[12].Value.ToString();
                if (dataGridCars.SelectedRows[0].Cells[13].Value.Equals(true))
                { Mostrar.checkBoxAct.Checked = true; }
                if (dataGridCars.SelectedRows[0].Cells[8].Value.ToString().Equals("Automático"))
                { Mostrar.radioButtonAuto.Checked = true; }
                else
                { Mostrar.radioButtonManual.Checked = true; }
                Mostrar.ShowDialog();
            }
        }
    }
}
