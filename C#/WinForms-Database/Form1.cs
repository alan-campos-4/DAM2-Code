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
        public static string table1 = "alumnos";
        public static string table2 = "notas";

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
            dataGridStudents.Columns.Clear();
            for (var col = 0; col < reader1.FieldCount; col++)
            {
                dataGridStudents.Columns.Add(reader1.GetName(col), reader1.GetName(col));
            }
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
            dataGridScores.Columns.Clear();
            for (var col = 0; col < reader2.FieldCount; col++)
            {
                dataGridScores.Columns.Add(reader2.GetName(col), reader2.GetName(col));
            }
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
            foreach (DataGridViewRow row in dataGridScores.Rows)
            {
                row.Visible = true;
            }

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

            UpdateAverage();

            connection.Close();
        }

        public void UpdateDataGrid(DataGridView dgv, string tablename)
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT * FROM "+tablename;
            MySqlCommand comando = new MySqlCommand(query, connection);
            MySqlDataReader reader = comando.ExecuteReader();

            while (reader.Read())
            {
                object[] newrow = new object[reader.FieldCount];
                for (var cell = 0; cell < reader.FieldCount; cell++)
                {
                    newrow[cell] = reader.GetValue(cell);
                }
                dgv.Rows.Add(newrow);
            }
            reader.Close();
            connection.Close();
        }

        public void UpdateAverage()
        {
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            string query = "SELECT * FROM notas";
            MySqlCommand comando = new MySqlCommand(query, connection);
            MySqlDataReader reader = comando.ExecuteReader();

            double sum = 0.0;
            int total = 0;

            while (reader.Read())
            {
                foreach (DataGridViewRow row in dataGridScores.Rows)
                {
                    if (row.Visible == true)
                    {
                        sum += (double)reader["nota"];
                        total++;
                    }
                }
            }
            toolStripStatusLabel1.Text = (sum / total).ToString();

            reader.Close();
            connection.Close();
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
            UpdateAverage();
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
                    PantallaMod.textBoxScore.Text = reader["nota"].ToString();
                }
                reader.Close();
                
                if (PantallaMod.ShowDialog() == DialogResult.OK) 
                {
                    string updateQuery = "UPDATE alumnos SET nombre=@Nom, apellidos=@Apel, telefono=@Tele, provincia=@Prov, nota=@Note WHERE codigo=@ID";
                    MySqlCommand updateCommand = new MySqlCommand(updateQuery, connection);
                    updateCommand.Parameters.AddWithValue("@Nom",   PantallaMod.textBoxName.Text);
                    updateCommand.Parameters.AddWithValue("@Apel",  PantallaMod.textBoxLName.Text);
                    updateCommand.Parameters.AddWithValue("@Tele",  PantallaMod.textBoxPhone.Text);
                    updateCommand.Parameters.AddWithValue("@Prov",  PantallaMod.textBoxProvince.Text);
                    updateCommand.Parameters.AddWithValue("@Note",  PantallaMod.textBoxScore.Text);
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
                
                //UpdateDataGrid();
                UpdateAverage();
                connection.Close();
            }
            else {MessageBox.Show("Ninguna fila seleccionada");}
        }
    }
}
