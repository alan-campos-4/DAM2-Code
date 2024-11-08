using MySql.Data.MySqlClient;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Database
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public static string connectionString = "Server=localhost;Database=instituto;User ID=root;Password=root;SslMode=none";

        private void Form1_Load(object sender, EventArgs e)
        {
            // 
            // Initial connection
            // 
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();


            // 
            // Load colummns and items in DataGridViews
            // 
            string query1 = "SELECT * FROM alumnos";
            MySqlCommand comando = new MySqlCommand(query1, connection);
            MySqlDataReader reader1 = comando.ExecuteReader();
            while (reader1.Read())
            {
                object[] newrow = new object[reader1.FieldCount];
                for (var cell = 0; cell < reader1.FieldCount; cell++)
                {
                    newrow[cell] = reader1.GetValue(cell);
                }
                dataGridStudents.Rows.Add(newrow);
            }
            reader1.Close();


            // 
            // Load colummns and items in DataGridScores
            //
            string query2 = "SELECT * FROM notas";
            MySqlCommand comando2 = new MySqlCommand(query2, connection);
            MySqlDataReader reader2 = comando2.ExecuteReader();
            while (reader2.Read())
            {
                object[] newrow = new object[reader2.FieldCount];
                for (var cell = 0; cell < reader2.FieldCount; cell++)
                {
                    newrow[cell] = reader2.GetValue(cell);
                }
                dataGridScores.Rows.Add(newrow);
            }
            reader2.Close();
            

            // 
            // Load Provincias in ComboBox
            // 
            string queryCombo = "SELECT DISTINCT Provincia FROM alumnos";
            MySqlCommand comando3 = new MySqlCommand(queryCombo, connection);
            MySqlDataReader reader3 = comando3.ExecuteReader();
            comboBox1.Items.Add("Todas las provincias");
            while (reader3.Read())
            {
                comboBox1.Items.Add(reader3["provincia"]);
            }
            reader3.Close();


            dataGridStudents.ClearSelection();
            dataGridScores.ClearSelection();

            toolStripStatusLabel1.Text = "";
        }



        


        private void BorrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();

            if (dataGridStudents.SelectedRows.Count > 0)
            {
                // Define el ID del registro que deseas eliminar
                int idAEliminar = int.Parse(dataGridStudents.SelectedRows[0].Cells[0].Value.ToString());

                // Crea la consulta SQL
                string sql = "DELETE FROM alumnos WHERE codigo = @id";
                MySqlCommand comando = new MySqlCommand(sql, connection);
                comando.Parameters.AddWithValue("@id", idAEliminar);
                comando.ExecuteNonQuery();

                //UpdateDataGrid();

                MessageBox.Show("Fila borrada");
            }
            else {MessageBox.Show("Ninguna fila seleccionada");}

            connection.Close();
        }

        private void ModificarToolStripMenu_Click(object sender, EventArgs e)
        {
            if (dataGridStudents.SelectedRows.Count > 0)
            {
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                int idSeleccion = int.Parse(dataGridStudents.SelectedRows[0].Cells[0].Value.ToString());
                
                string selectQuery = "SELECT * FROM alumnos WHERE codigo = @ID";
                MySqlCommand selectCommand = new MySqlCommand(selectQuery, connection);
                selectCommand.Parameters.AddWithValue("@ID", idSeleccion);
                MySqlDataReader reader = selectCommand.ExecuteReader();

                PMod PantallaMod = new PMod();
                while (reader.Read())
                {
                    PantallaMod.textBoxCode.Text = reader["codigo"].ToString();
                    PantallaMod.textBoxName.Text = reader["nombre"].ToString();
                    PantallaMod.textBoxLName.Text = reader["apellidos"].ToString();
                    PantallaMod.textBoxPhone.Text = reader["telefono"].ToString();
                    PantallaMod.textBoxProvince.Text = reader["provincia"].ToString();
                }
                reader.Close();
                
                if (PantallaMod.ShowDialog() == DialogResult.OK) 
                {
                    string updateQuery = "UPDATE alumnos SET nombre=@Nom, apellidos=@Apel, telefono=@Tele, provincia=@Prov WHERE codigo=@ID";
                    MySqlCommand updateCommand = new MySqlCommand(updateQuery, connection);
                    updateCommand.Parameters.AddWithValue("@Nom",   PantallaMod.textBoxName.Text);
                    updateCommand.Parameters.AddWithValue("@Apel",  PantallaMod.textBoxLName.Text);
                    updateCommand.Parameters.AddWithValue("@Tele",  PantallaMod.textBoxPhone.Text);
                    updateCommand.Parameters.AddWithValue("@Prov",  PantallaMod.textBoxProvince.Text);
                    updateCommand.Parameters.AddWithValue("@ID",    idSeleccion);

                    try
                    {
                        int filasAfectadas = updateCommand.ExecuteNonQuery();

                        if (filasAfectadas > 0)
                            { MessageBox.Show("Registro modificado correctamente."); }
                        else
                            { MessageBox.Show("Registro no encontrado."); }
                    }
                    catch (Exception ex) { MessageBox.Show($"Error al modificar el registro: {ex.Message}"); }
                }
                
                UpdateAverage();
                connection.Close();
            }
            else {MessageBox.Show("Ninguna fila seleccionada");}
        }






        private void ComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            foreach (DataGridViewRow row in dataGridStudents.Rows)
            {
                row.Visible = true;
            }
            if (comboBox1.SelectedIndex != 0)
            {
                for (int i = 0; i < dataGridStudents.Rows.Count; i++)
                {
                    if (!dataGridStudents.Rows[i].Cells[4].Value.Equals(comboBox1.SelectedItem.ToString()))
                    {
                        dataGridStudents.Rows[i].Visible = false;
                    }
                }
            }
        }

        private void DataGridStudents_MouseClick(object sender, MouseEventArgs e)
        {
            ReloadDataGrid();
        }

        private void ReloadDataGrid()
        {
            if (dataGridStudents.SelectedRows.Count > 0)
            {
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                int idSeleccion = int.Parse(dataGridStudents.SelectedRows[0].Cells[0].Value.ToString());

                string selectQuery = "SELECT * FROM notas WHERE CodigoAlumno = @ID";
                MySqlCommand selectCommand = new MySqlCommand(selectQuery, connection);
                selectCommand.Parameters.AddWithValue("@ID", idSeleccion);
                MySqlDataReader reader = selectCommand.ExecuteReader();

                dataGridScores.Rows.Clear();
                while (reader.Read())
                {
                    object[] newrow = new object[reader.FieldCount];
                    for (var cell = 0; cell < reader.FieldCount; cell++)
                    {
                        newrow[cell] = reader.GetValue(cell);
                    }
                    dataGridScores.Rows.Add(newrow);
                }
                reader.Close();
                connection.Close();

                dataGridScores.ClearSelection();
                UpdateAverage();
            }
        }

        public void UpdateAverage()
        {
            double sum = 0.0;
            int total = 0;
            foreach (DataGridViewRow row in dataGridScores.Rows)
            {
                sum += (double)row.Cells[3].Value;
                total++;
            }
            toolStripStatusLabel1.Text = (sum / total).ToString();
        }






        private void buttonAddScore_Click(object sender, EventArgs e)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            PModNota PantallaMod = new PModNota();

            if (PantallaMod.ShowDialog() == DialogResult.OK)
            {
                string insertQuery = "INSERT INTO notas (Codigo, CodigoAlumno, Asignatura, Nota) VALUES (@Cod, @CodAl, @Asig, @Nota)";
                MySqlCommand updateCommand = new MySqlCommand(insertQuery, connection);
                updateCommand.Parameters.AddWithValue("@Cod", PantallaMod.textBoxCode1.Text);
                updateCommand.Parameters.AddWithValue("@CodAl", PantallaMod.textBoxCode2.Text);
                updateCommand.Parameters.AddWithValue("@Asig", PantallaMod.textBoxSubject.Text);
                updateCommand.Parameters.AddWithValue("@Nota", PantallaMod.textBoxScore.Text);

                try
                {
                    int filasAfectadas = updateCommand.ExecuteNonQuery();

                    if (filasAfectadas > 0)
                        { MessageBox.Show("Registro añadido correctamente."); }
                    else
                        { MessageBox.Show("Registro no encontrado."); }
                }
                catch (Exception ex) { MessageBox.Show($"Error al modificar el registro: {ex.Message}"); }
            }
            connection.Close();

            ReloadDataGrid();
        }

        private void buttonModScore_Click(object sender, EventArgs e)
        {
            if (dataGridScores.SelectedRows.Count > 0)
            {
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                int idSeleccion = int.Parse(dataGridScores.SelectedRows[0].Cells[0].Value.ToString());

                string selectQuery = "SELECT * FROM notas WHERE CodigoAlumno = @ID";
                MySqlCommand selectCommand = new MySqlCommand(selectQuery, connection);
                selectCommand.Parameters.AddWithValue("@ID", idSeleccion);
                MySqlDataReader reader = selectCommand.ExecuteReader();

                PModNota PantallaMod = new PModNota();
                while (reader.Read())
                {
                    PantallaMod.textBoxCode1.Text = reader["Codigo"].ToString();
                    PantallaMod.textBoxCode2.Text = reader["CodigoAlumno"].ToString();
                    PantallaMod.textBoxSubject.Text = reader["Asignatura"].ToString();
                    PantallaMod.textBoxScore.Text = reader["Nota"].ToString();
                }
                reader.Close();

                if (PantallaMod.ShowDialog() == DialogResult.OK)
                {
                    string updateQuery = "UPDATE notas SET asignatura=@Asig, nota=@Nota WHERE codigo=@ID";
                    MySqlCommand updateCommand = new MySqlCommand(updateQuery, connection);
                    updateCommand.Parameters.AddWithValue("@Asig", PantallaMod.textBoxSubject.Text);
                    updateCommand.Parameters.AddWithValue("@Nota", PantallaMod.textBoxScore.Text);
                    updateCommand.Parameters.AddWithValue("@ID", idSeleccion);

                    try
                    {
                        int filasAfectadas = updateCommand.ExecuteNonQuery();

                        if (filasAfectadas > 0)
                            { MessageBox.Show("Registro modificado correctamente."); }
                        else
                            { MessageBox.Show("Registro no encontrado."); }
                    }
                    catch (Exception ex) { MessageBox.Show($"Error al modificar el registro: {ex.Message}"); }
                }
                connection.Close();

                ReloadDataGrid();
            }
            else { MessageBox.Show("Ninguna fila seleccionada"); }
        }

        private void buttonDeleteScore_Click(object sender, EventArgs e)
        {
            if (dataGridScores.SelectedRows.Count > 0)
            {
                MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                int idSeleccion = int.Parse(dataGridScores.SelectedRows[0].Cells[0].Value.ToString());

                string deleteQuery = "DELETE FROM notas WHERE codigo=@ID";
                MySqlCommand updateCommand = new MySqlCommand(deleteQuery, connection);
                updateCommand.Parameters.AddWithValue("@ID", idSeleccion);

                try
                {
                    int filasAfectadas = updateCommand.ExecuteNonQuery();

                    if (filasAfectadas > 0)
                        { MessageBox.Show("Registro borrado correctamente."); }
                    else
                        { MessageBox.Show("Registro no encontrado."); }
                }
                catch (Exception ex) { MessageBox.Show($"Error al modificar el registro: {ex.Message}"); }
                
                connection.Close();

                ReloadDataGrid();
            }
            else { MessageBox.Show("Ninguna fila seleccionada"); }
        }




    }
}
