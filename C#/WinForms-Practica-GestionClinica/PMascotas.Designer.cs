namespace WinForms_Practica_GestionClinica
{
    partial class PMascotas
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
            this.dataGridPets = new System.Windows.Forms.DataGridView();
            this.label1 = new System.Windows.Forms.Label();
            this.menuStripPets = new System.Windows.Forms.MenuStrip();
            this.añadirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.modificiarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.borrarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.textBoxSearch = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridPets)).BeginInit();
            this.menuStripPets.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridPets
            // 
            this.dataGridPets.AllowUserToAddRows = false;
            this.dataGridPets.AllowUserToDeleteRows = false;
            this.dataGridPets.AllowUserToResizeColumns = false;
            this.dataGridPets.AllowUserToResizeRows = false;
            this.dataGridPets.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.dataGridPets.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.AllCells;
            this.dataGridPets.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridPets.Location = new System.Drawing.Point(78, 156);
            this.dataGridPets.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.dataGridPets.MultiSelect = false;
            this.dataGridPets.Name = "dataGridPets";
            this.dataGridPets.ReadOnly = true;
            this.dataGridPets.RowHeadersVisible = false;
            this.dataGridPets.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridPets.Size = new System.Drawing.Size(1056, 525);
            this.dataGridPets.TabIndex = 2;
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Yu Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(115, 118);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(254, 21);
            this.label1.TabIndex = 4;
            this.label1.Text = "Busca el nombre del/la dueño/a:";
            // 
            // menuStripPets
            // 
            this.menuStripPets.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.menuStripPets.Font = new System.Drawing.Font("Segoe UI", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menuStripPets.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.añadirToolStripMenuItem,
            this.modificiarToolStripMenuItem,
            this.borrarToolStripMenuItem});
            this.menuStripPets.Location = new System.Drawing.Point(0, 0);
            this.menuStripPets.Name = "menuStripPets";
            this.menuStripPets.Padding = new System.Windows.Forms.Padding(17, 7, 0, 7);
            this.menuStripPets.Size = new System.Drawing.Size(1220, 38);
            this.menuStripPets.TabIndex = 5;
            // 
            // añadirToolStripMenuItem
            // 
            this.añadirToolStripMenuItem.Name = "añadirToolStripMenuItem";
            this.añadirToolStripMenuItem.Size = new System.Drawing.Size(65, 24);
            this.añadirToolStripMenuItem.Text = "Añadir";
            this.añadirToolStripMenuItem.Click += new System.EventHandler(this.AñadirToolStripMenuItem_Click);
            // 
            // modificiarToolStripMenuItem
            // 
            this.modificiarToolStripMenuItem.Name = "modificiarToolStripMenuItem";
            this.modificiarToolStripMenuItem.Size = new System.Drawing.Size(85, 24);
            this.modificiarToolStripMenuItem.Text = "Modificar";
            this.modificiarToolStripMenuItem.Click += new System.EventHandler(this.ModificiarToolStripMenuItem_Click);
            // 
            // borrarToolStripMenuItem
            // 
            this.borrarToolStripMenuItem.Name = "borrarToolStripMenuItem";
            this.borrarToolStripMenuItem.Size = new System.Drawing.Size(62, 24);
            this.borrarToolStripMenuItem.Text = "Borrar";
            this.borrarToolStripMenuItem.Click += new System.EventHandler(this.BorrarToolStripMenuItem_Click);
            // 
            // textBoxSearch
            // 
            this.textBoxSearch.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxSearch.Location = new System.Drawing.Point(380, 115);
            this.textBoxSearch.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.textBoxSearch.Name = "textBoxSearch";
            this.textBoxSearch.Size = new System.Drawing.Size(220, 33);
            this.textBoxSearch.TabIndex = 6;
            this.textBoxSearch.TextChanged += new System.EventHandler(this.TextBoxSearch_TextChanged);
            // 
            // PMascotas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 21F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1220, 736);
            this.Controls.Add(this.textBoxSearch);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dataGridPets);
            this.Controls.Add(this.menuStripPets);
            this.Font = new System.Drawing.Font("Yu Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.MainMenuStrip = this.menuStripPets;
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "PMascotas";
            this.Text = "Gestión de Mascotas";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.PMascotas_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridPets)).EndInit();
            this.menuStripPets.ResumeLayout(false);
            this.menuStripPets.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridPets;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MenuStrip menuStripPets;
        private System.Windows.Forms.ToolStripMenuItem añadirToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem modificiarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem borrarToolStripMenuItem;
        private System.Windows.Forms.TextBox textBoxSearch;
    }
}