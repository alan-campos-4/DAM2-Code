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
            this.comboBoxOwners = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.menuStripPets = new System.Windows.Forms.MenuStrip();
            this.añadirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.modificiarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.borrarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
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
            this.dataGridPets.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridPets.Location = new System.Drawing.Point(173, 155);
            this.dataGridPets.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.dataGridPets.MultiSelect = false;
            this.dataGridPets.Name = "dataGridPets";
            this.dataGridPets.ReadOnly = true;
            this.dataGridPets.RowHeadersVisible = false;
            this.dataGridPets.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridPets.Size = new System.Drawing.Size(733, 308);
            this.dataGridPets.TabIndex = 2;
            this.dataGridPets.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridPets_CellContentClick);
            // 
            // comboBoxOwners
            // 
            this.comboBoxOwners.FormattingEnabled = true;
            this.comboBoxOwners.Location = new System.Drawing.Point(453, 123);
            this.comboBoxOwners.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.comboBoxOwners.Name = "comboBoxOwners";
            this.comboBoxOwners.Size = new System.Drawing.Size(251, 24);
            this.comboBoxOwners.TabIndex = 3;
            this.comboBoxOwners.SelectedIndexChanged += new System.EventHandler(this.comboBoxOwners_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(392, 126);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 16);
            this.label1.TabIndex = 4;
            this.label1.Text = "Dueñ@";
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
            this.menuStripPets.Padding = new System.Windows.Forms.Padding(15, 5, 0, 5);
            this.menuStripPets.Size = new System.Drawing.Size(1084, 34);
            this.menuStripPets.TabIndex = 5;
            // 
            // añadirToolStripMenuItem
            // 
            this.añadirToolStripMenuItem.Name = "añadirToolStripMenuItem";
            this.añadirToolStripMenuItem.Size = new System.Drawing.Size(65, 24);
            this.añadirToolStripMenuItem.Text = "Añadir";
            this.añadirToolStripMenuItem.Click += new System.EventHandler(this.añadirToolStripMenuItem_Click);
            // 
            // modificiarToolStripMenuItem
            // 
            this.modificiarToolStripMenuItem.Name = "modificiarToolStripMenuItem";
            this.modificiarToolStripMenuItem.Size = new System.Drawing.Size(85, 24);
            this.modificiarToolStripMenuItem.Text = "Modificar";
            // 
            // borrarToolStripMenuItem
            // 
            this.borrarToolStripMenuItem.Name = "borrarToolStripMenuItem";
            this.borrarToolStripMenuItem.Size = new System.Drawing.Size(62, 24);
            this.borrarToolStripMenuItem.Text = "Borrar";
            // 
            // PMascotas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1084, 561);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBoxOwners);
            this.Controls.Add(this.dataGridPets);
            this.Controls.Add(this.menuStripPets);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.MainMenuStrip = this.menuStripPets;
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "PMascotas";
            this.Text = "Gestión de Mascotas";
            this.Load += new System.EventHandler(this.PMascotas_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridPets)).EndInit();
            this.menuStripPets.ResumeLayout(false);
            this.menuStripPets.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.DataGridView dataGridPets;
        private System.Windows.Forms.ComboBox comboBoxOwners;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MenuStrip menuStripPets;
        private System.Windows.Forms.ToolStripMenuItem añadirToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem modificiarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem borrarToolStripMenuItem;
    }
}