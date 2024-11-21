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
            ((System.ComponentModel.ISupportInitialize)(this.dataGridPets)).BeginInit();
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
            this.dataGridPets.Location = new System.Drawing.Point(134, 127);
            this.dataGridPets.MultiSelect = false;
            this.dataGridPets.Name = "dataGridPets";
            this.dataGridPets.ReadOnly = true;
            this.dataGridPets.RowHeadersVisible = false;
            this.dataGridPets.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridPets.Size = new System.Drawing.Size(550, 250);
            this.dataGridPets.TabIndex = 2;
            // 
            // comboBoxOwners
            // 
            this.comboBoxOwners.FormattingEnabled = true;
            this.comboBoxOwners.Location = new System.Drawing.Point(307, 100);
            this.comboBoxOwners.Name = "comboBoxOwners";
            this.comboBoxOwners.Size = new System.Drawing.Size(189, 21);
            this.comboBoxOwners.TabIndex = 3;
            this.comboBoxOwners.SelectedIndexChanged += new System.EventHandler(this.comboBoxOwners_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(248, 101);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 16);
            this.label1.TabIndex = 4;
            this.label1.Text = "Dueñ@";
            // 
            // PMascotas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(834, 461);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBoxOwners);
            this.Controls.Add(this.dataGridPets);
            this.Name = "PMascotas";
            this.Text = "Mascotas";
            this.Load += new System.EventHandler(this.PMascotas_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridPets)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.DataGridView dataGridPets;
        private System.Windows.Forms.ComboBox comboBoxOwners;
        private System.Windows.Forms.Label label1;
    }
}