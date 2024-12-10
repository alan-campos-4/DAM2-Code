namespace WinForms_Practica_GestionClinica
{
    partial class PCitas
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
            this.menuStripAppoint = new System.Windows.Forms.MenuStrip();
            this.NuevaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.EliminarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.AlterarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.monthCalendar1 = new System.Windows.Forms.MonthCalendar();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.menuStripAppoint.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStripAppoint
            // 
            this.menuStripAppoint.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.menuStripAppoint.Font = new System.Drawing.Font("Segoe UI", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menuStripAppoint.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.NuevaToolStripMenuItem,
            this.AlterarToolStripMenuItem,
            this.EliminarToolStripMenuItem});
            this.menuStripAppoint.Location = new System.Drawing.Point(0, 0);
            this.menuStripAppoint.Name = "menuStripAppoint";
            this.menuStripAppoint.Padding = new System.Windows.Forms.Padding(17, 7, 0, 7);
            this.menuStripAppoint.Size = new System.Drawing.Size(1220, 38);
            this.menuStripAppoint.TabIndex = 0;
            // 
            // NuevaToolStripMenuItem
            // 
            this.NuevaToolStripMenuItem.Name = "NuevaToolStripMenuItem";
            this.NuevaToolStripMenuItem.Size = new System.Drawing.Size(63, 24);
            this.NuevaToolStripMenuItem.Text = "Nueva";
            this.NuevaToolStripMenuItem.Click += new System.EventHandler(this.NuevaToolStripMenuItem_Click);
            // 
            // EliminarToolStripMenuItem
            // 
            this.EliminarToolStripMenuItem.Name = "EliminarToolStripMenuItem";
            this.EliminarToolStripMenuItem.Size = new System.Drawing.Size(75, 24);
            this.EliminarToolStripMenuItem.Text = "Eliminar";
            this.EliminarToolStripMenuItem.Click += new System.EventHandler(this.EliminarToolStripMenuItem_Click);
            // 
            // AlterarToolStripMenuItem
            // 
            this.AlterarToolStripMenuItem.Name = "AlterarToolStripMenuItem";
            this.AlterarToolStripMenuItem.Size = new System.Drawing.Size(66, 24);
            this.AlterarToolStripMenuItem.Text = "Alterar";
            this.AlterarToolStripMenuItem.Click += new System.EventHandler(this.AlterarToolStripMenuItem_Click);
            // 
            // monthCalendar1
            // 
            this.monthCalendar1.Location = new System.Drawing.Point(83, 184);
            this.monthCalendar1.Margin = new System.Windows.Forms.Padding(10, 12, 10, 12);
            this.monthCalendar1.Name = "monthCalendar1";
            this.monthCalendar1.TabIndex = 3;
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.AllowUserToResizeColumns = false;
            this.dataGridView1.AllowUserToResizeRows = false;
            this.dataGridView1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(585, 184);
            this.dataGridView1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.dataGridView1.MultiSelect = false;
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowHeadersVisible = false;
            this.dataGridView1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView1.Size = new System.Drawing.Size(562, 404);
            this.dataGridView1.TabIndex = 4;
            // 
            // PCitas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 21F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1220, 736);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.monthCalendar1);
            this.Controls.Add(this.menuStripAppoint);
            this.Font = new System.Drawing.Font("Yu Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.MainMenuStrip = this.menuStripAppoint;
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "PCitas";
            this.Text = "Gestión de Citas";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.PCitas_Load);
            this.menuStripAppoint.ResumeLayout(false);
            this.menuStripAppoint.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStripAppoint;
        private System.Windows.Forms.ToolStripMenuItem NuevaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem AlterarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem EliminarToolStripMenuItem;
        private System.Windows.Forms.MonthCalendar monthCalendar1;
        private System.Windows.Forms.DataGridView dataGridView1;
    }
}