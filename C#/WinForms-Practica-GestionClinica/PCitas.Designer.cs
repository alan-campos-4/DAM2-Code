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
            this.AlterarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.EliminarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.monthCalendar1 = new System.Windows.Forms.MonthCalendar();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.labelPet = new System.Windows.Forms.Label();
            this.labelClient = new System.Windows.Forms.Label();
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
            // AlterarToolStripMenuItem
            // 
            this.AlterarToolStripMenuItem.Name = "AlterarToolStripMenuItem";
            this.AlterarToolStripMenuItem.Size = new System.Drawing.Size(66, 24);
            this.AlterarToolStripMenuItem.Text = "Alterar";
            this.AlterarToolStripMenuItem.Click += new System.EventHandler(this.AlterarToolStripMenuItem_Click);
            // 
            // EliminarToolStripMenuItem
            // 
            this.EliminarToolStripMenuItem.Name = "EliminarToolStripMenuItem";
            this.EliminarToolStripMenuItem.Size = new System.Drawing.Size(75, 24);
            this.EliminarToolStripMenuItem.Text = "Eliminar";
            this.EliminarToolStripMenuItem.Click += new System.EventHandler(this.EliminarToolStripMenuItem_Click);
            // 
            // monthCalendar1
            // 
            this.monthCalendar1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.monthCalendar1.CalendarDimensions = new System.Drawing.Size(2, 2);
            this.monthCalendar1.Location = new System.Drawing.Point(69, 235);
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
            this.dataGridView1.Location = new System.Drawing.Point(513, 188);
            this.dataGridView1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.dataGridView1.MultiSelect = false;
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowHeadersVisible = false;
            this.dataGridView1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView1.Size = new System.Drawing.Size(628, 265);
            this.dataGridView1.TabIndex = 4;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(531, 469);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(72, 21);
            this.label1.TabIndex = 5;
            this.label1.Text = "Cliente: ";
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(531, 507);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 21);
            this.label2.TabIndex = 6;
            this.label2.Text = "Mascota: ";
            // 
            // labelPet
            // 
            this.labelPet.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelPet.AutoSize = true;
            this.labelPet.Location = new System.Drawing.Point(621, 507);
            this.labelPet.Name = "labelPet";
            this.labelPet.Size = new System.Drawing.Size(22, 21);
            this.labelPet.TabIndex = 8;
            this.labelPet.Text = "...";
            // 
            // labelClient
            // 
            this.labelClient.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelClient.AutoSize = true;
            this.labelClient.Location = new System.Drawing.Point(621, 469);
            this.labelClient.Name = "labelClient";
            this.labelClient.Size = new System.Drawing.Size(22, 21);
            this.labelClient.TabIndex = 7;
            this.labelClient.Text = "...";
            // 
            // PCitas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 21F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1220, 736);
            this.Controls.Add(this.labelPet);
            this.Controls.Add(this.labelClient);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
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
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label labelPet;
        private System.Windows.Forms.Label labelClient;
    }
}