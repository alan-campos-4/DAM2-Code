namespace WinForms_Project2
{
    partial class PAlumnos
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
            this.dataGridStudents = new System.Windows.Forms.DataGridView();
            this.Codigo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Nombre = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Apellidos = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Telefono = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridScores = new System.Windows.Forms.DataGridView();
            this.CodigoA = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Asignatura = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Nota = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.altaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.modificarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.borrarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.buttonScoreAdd = new System.Windows.Forms.Button();
            this.buttonScoreMod = new System.Windows.Forms.Button();
            this.buttonScoreDelete = new System.Windows.Forms.Button();
            this.labelAvg = new System.Windows.Forms.Label();
            this.labelError = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridStudents)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridScores)).BeginInit();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridStudents
            // 
            this.dataGridStudents.AllowUserToAddRows = false;
            this.dataGridStudents.AllowUserToDeleteRows = false;
            this.dataGridStudents.AllowUserToResizeColumns = false;
            this.dataGridStudents.AllowUserToResizeRows = false;
            this.dataGridStudents.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.dataGridStudents.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridStudents.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Codigo,
            this.Nombre,
            this.Apellidos,
            this.Telefono});
            this.dataGridStudents.Location = new System.Drawing.Point(99, 60);
            this.dataGridStudents.MultiSelect = false;
            this.dataGridStudents.Name = "dataGridStudents";
            this.dataGridStudents.ReadOnly = true;
            this.dataGridStudents.RowHeadersVisible = false;
            this.dataGridStudents.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridStudents.Size = new System.Drawing.Size(610, 189);
            this.dataGridStudents.TabIndex = 0;
            this.dataGridStudents.MouseClick += new System.Windows.Forms.MouseEventHandler(this.dataGridStudents_MouseClick);
            // 
            // Codigo
            // 
            this.Codigo.HeaderText = "Codigo";
            this.Codigo.Name = "Codigo";
            this.Codigo.ReadOnly = true;
            // 
            // Nombre
            // 
            this.Nombre.HeaderText = "Nombre";
            this.Nombre.Name = "Nombre";
            this.Nombre.ReadOnly = true;
            // 
            // Apellidos
            // 
            this.Apellidos.HeaderText = "Apellidos";
            this.Apellidos.Name = "Apellidos";
            this.Apellidos.ReadOnly = true;
            // 
            // Telefono
            // 
            this.Telefono.HeaderText = "Telefono";
            this.Telefono.Name = "Telefono";
            this.Telefono.ReadOnly = true;
            // 
            // dataGridScores
            // 
            this.dataGridScores.AllowUserToAddRows = false;
            this.dataGridScores.AllowUserToDeleteRows = false;
            this.dataGridScores.AllowUserToResizeColumns = false;
            this.dataGridScores.AllowUserToResizeRows = false;
            this.dataGridScores.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.dataGridScores.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridScores.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.CodigoA,
            this.Asignatura,
            this.Nota});
            this.dataGridScores.Location = new System.Drawing.Point(99, 266);
            this.dataGridScores.MultiSelect = false;
            this.dataGridScores.Name = "dataGridScores";
            this.dataGridScores.ReadOnly = true;
            this.dataGridScores.RowHeadersVisible = false;
            this.dataGridScores.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridScores.Size = new System.Drawing.Size(442, 184);
            this.dataGridScores.TabIndex = 1;
            // 
            // CodigoA
            // 
            this.CodigoA.HeaderText = "CodigoA";
            this.CodigoA.Name = "CodigoA";
            this.CodigoA.ReadOnly = true;
            // 
            // Asignatura
            // 
            this.Asignatura.HeaderText = "Asignatura";
            this.Asignatura.Name = "Asignatura";
            this.Asignatura.ReadOnly = true;
            // 
            // Nota
            // 
            this.Nota.HeaderText = "Nota";
            this.Nota.Name = "Nota";
            this.Nota.ReadOnly = true;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.altaToolStripMenuItem,
            this.modificarToolStripMenuItem,
            this.borrarToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(832, 24);
            this.menuStrip1.TabIndex = 2;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // altaToolStripMenuItem
            // 
            this.altaToolStripMenuItem.Name = "altaToolStripMenuItem";
            this.altaToolStripMenuItem.Size = new System.Drawing.Size(40, 20);
            this.altaToolStripMenuItem.Text = "Alta";
            this.altaToolStripMenuItem.Click += new System.EventHandler(this.altaToolStripMenuItem_Click);
            // 
            // modificarToolStripMenuItem
            // 
            this.modificarToolStripMenuItem.Name = "modificarToolStripMenuItem";
            this.modificarToolStripMenuItem.Size = new System.Drawing.Size(70, 20);
            this.modificarToolStripMenuItem.Text = "Modificar";
            this.modificarToolStripMenuItem.Click += new System.EventHandler(this.modificarToolStripMenuItem_Click);
            // 
            // borrarToolStripMenuItem
            // 
            this.borrarToolStripMenuItem.Name = "borrarToolStripMenuItem";
            this.borrarToolStripMenuItem.Size = new System.Drawing.Size(51, 20);
            this.borrarToolStripMenuItem.Text = "Borrar";
            this.borrarToolStripMenuItem.Click += new System.EventHandler(this.borrarToolStripMenuItem_Click);
            // 
            // buttonScoreAdd
            // 
            this.buttonScoreAdd.Location = new System.Drawing.Point(547, 319);
            this.buttonScoreAdd.Name = "buttonScoreAdd";
            this.buttonScoreAdd.Size = new System.Drawing.Size(75, 23);
            this.buttonScoreAdd.TabIndex = 3;
            this.buttonScoreAdd.Text = "Alta";
            this.buttonScoreAdd.UseVisualStyleBackColor = true;
            this.buttonScoreAdd.Click += new System.EventHandler(this.buttonScoreAdd_Click);
            // 
            // buttonScoreMod
            // 
            this.buttonScoreMod.Location = new System.Drawing.Point(547, 348);
            this.buttonScoreMod.Name = "buttonScoreMod";
            this.buttonScoreMod.Size = new System.Drawing.Size(75, 23);
            this.buttonScoreMod.TabIndex = 4;
            this.buttonScoreMod.Text = "Modificar";
            this.buttonScoreMod.UseVisualStyleBackColor = true;
            this.buttonScoreMod.Click += new System.EventHandler(this.buttonScoreMod_Click);
            // 
            // buttonScoreDelete
            // 
            this.buttonScoreDelete.Location = new System.Drawing.Point(547, 377);
            this.buttonScoreDelete.Name = "buttonScoreDelete";
            this.buttonScoreDelete.Size = new System.Drawing.Size(75, 23);
            this.buttonScoreDelete.TabIndex = 5;
            this.buttonScoreDelete.Text = "Borrar";
            this.buttonScoreDelete.UseVisualStyleBackColor = true;
            this.buttonScoreDelete.Click += new System.EventHandler(this.buttonScoreDelete_Click);
            // 
            // labelAvg
            // 
            this.labelAvg.AutoSize = true;
            this.labelAvg.Location = new System.Drawing.Point(547, 269);
            this.labelAvg.Name = "labelAvg";
            this.labelAvg.Size = new System.Drawing.Size(13, 13);
            this.labelAvg.TabIndex = 6;
            this.labelAvg.Text = "_";
            // 
            // labelError
            // 
            this.labelError.AutoSize = true;
            this.labelError.Location = new System.Drawing.Point(715, 117);
            this.labelError.Name = "labelError";
            this.labelError.Size = new System.Drawing.Size(13, 13);
            this.labelError.TabIndex = 7;
            this.labelError.Text = "_";
            // 
            // PAlumnos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(832, 492);
            this.Controls.Add(this.labelError);
            this.Controls.Add(this.labelAvg);
            this.Controls.Add(this.buttonScoreDelete);
            this.Controls.Add(this.buttonScoreMod);
            this.Controls.Add(this.buttonScoreAdd);
            this.Controls.Add(this.dataGridScores);
            this.Controls.Add(this.dataGridStudents);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "PAlumnos";
            this.Text = "Gestión de Alumnos";
            this.Load += new System.EventHandler(this.PAlumnos_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridStudents)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridScores)).EndInit();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridStudents;
        private System.Windows.Forms.DataGridView dataGridScores;
        private System.Windows.Forms.DataGridViewTextBoxColumn Codigo;
        private System.Windows.Forms.DataGridViewTextBoxColumn Nombre;
        private System.Windows.Forms.DataGridViewTextBoxColumn Apellidos;
        private System.Windows.Forms.DataGridViewTextBoxColumn Telefono;
        private System.Windows.Forms.DataGridViewTextBoxColumn CodigoA;
        private System.Windows.Forms.DataGridViewTextBoxColumn Asignatura;
        private System.Windows.Forms.DataGridViewTextBoxColumn Nota;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem altaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem modificarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem borrarToolStripMenuItem;
        private System.Windows.Forms.Button buttonScoreAdd;
        private System.Windows.Forms.Button buttonScoreMod;
        private System.Windows.Forms.Button buttonScoreDelete;
        private System.Windows.Forms.Label labelAvg;
        private System.Windows.Forms.Label labelError;
    }
}