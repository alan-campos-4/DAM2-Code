namespace WinForms_Project2
{
    partial class PNotas
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.comboBoxStudents = new System.Windows.Forms.ComboBox();
            this.dataGridScores1 = new System.Windows.Forms.DataGridView();
            this.Codigo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Asignatura = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Nota = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridScores1)).BeginInit();
            this.SuspendLayout();
            // 
            // comboBoxStudents
            // 
            this.comboBoxStudents.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.comboBoxStudents.FormattingEnabled = true;
            this.comboBoxStudents.Location = new System.Drawing.Point(103, 74);
            this.comboBoxStudents.Name = "comboBoxStudents";
            this.comboBoxStudents.Size = new System.Drawing.Size(218, 21);
            this.comboBoxStudents.TabIndex = 0;
            this.comboBoxStudents.SelectedIndexChanged += new System.EventHandler(this.comboBoxStudents_SelectedIndexChanged);
            // 
            // dataGridScores1
            // 
            this.dataGridScores1.AllowUserToAddRows = false;
            this.dataGridScores1.AllowUserToDeleteRows = false;
            this.dataGridScores1.AllowUserToResizeColumns = false;
            this.dataGridScores1.AllowUserToResizeRows = false;
            this.dataGridScores1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.dataGridScores1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridScores1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Codigo,
            this.Asignatura,
            this.Nota});
            this.dataGridScores1.Location = new System.Drawing.Point(103, 114);
            this.dataGridScores1.Name = "dataGridScores1";
            this.dataGridScores1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridScores1.Size = new System.Drawing.Size(559, 276);
            this.dataGridScores1.TabIndex = 1;
            // 
            // Codigo
            // 
            this.Codigo.HeaderText = "CodigoAlumno";
            this.Codigo.Name = "Codigo";
            this.Codigo.ReadOnly = true;
            // 
            // Asignatura
            // 
            this.Asignatura.HeaderText = "Asignatura";
            this.Asignatura.Name = "Asignatura";
            this.Asignatura.ReadOnly = true;
            this.Asignatura.Width = 150;
            // 
            // Nota
            // 
            this.Nota.HeaderText = "Nota";
            this.Nota.Name = "Nota";
            this.Nota.ReadOnly = true;
            // 
            // PNotas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 489);
            this.Controls.Add(this.dataGridScores1);
            this.Controls.Add(this.comboBoxStudents);
            this.Name = "PNotas";
            this.Text = "Gestión de notas";
            this.Load += new System.EventHandler(this.PNotas_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridScores1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ComboBox comboBoxStudents;
        private System.Windows.Forms.DataGridView dataGridScores1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Codigo;
        private System.Windows.Forms.DataGridViewTextBoxColumn Asignatura;
        private System.Windows.Forms.DataGridViewTextBoxColumn Nota;
    }
}