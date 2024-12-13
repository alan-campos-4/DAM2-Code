namespace WinForms_Examen2
{
    partial class PStats
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
            this.components = new System.ComponentModel.Container();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.comboBoxFamily = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.labelListado = new System.Windows.Forms.Label();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.labelQuantity = new System.Windows.Forms.Label();
            this.labelAverage = new System.Windows.Forms.Label();
            this.labelExpensive = new System.Windows.Forms.Label();
            this.labelCheapest = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // comboBoxFamily
            // 
            this.comboBoxFamily.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.comboBoxFamily.FormattingEnabled = true;
            this.comboBoxFamily.Location = new System.Drawing.Point(281, 55);
            this.comboBoxFamily.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.comboBoxFamily.Name = "comboBoxFamily";
            this.comboBoxFamily.Size = new System.Drawing.Size(199, 24);
            this.comboBoxFamily.TabIndex = 2;
            this.comboBoxFamily.SelectedIndexChanged += new System.EventHandler(this.comboBoxFamily_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(114, 59);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(148, 16);
            this.label1.TabIndex = 3;
            this.label1.Text = "Selecciona una familia: ";
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(55, 179);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(180, 16);
            this.label2.TabIndex = 4;
            this.label2.Text = "Número de artículos en stock";
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(55, 214);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(107, 16);
            this.label3.TabIndex = 5;
            this.label3.Text = "Precio promedio";
            // 
            // label4
            // 
            this.label4.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(55, 249);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(110, 16);
            this.label4.TabIndex = 6;
            this.label4.Text = "Artículo más caro";
            // 
            // label5
            // 
            this.label5.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(55, 285);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(122, 16);
            this.label5.TabIndex = 7;
            this.label5.Text = "Artículo más barato";
            // 
            // labelListado
            // 
            this.labelListado.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelListado.AutoSize = true;
            this.labelListado.Location = new System.Drawing.Point(356, 137);
            this.labelListado.Name = "labelListado";
            this.labelListado.Size = new System.Drawing.Size(16, 16);
            this.labelListado.TabIndex = 8;
            this.labelListado.Text = "...";
            // 
            // listBox1
            // 
            this.listBox1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.listBox1.FormattingEnabled = true;
            this.listBox1.ItemHeight = 16;
            this.listBox1.Location = new System.Drawing.Point(359, 179);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(227, 132);
            this.listBox1.TabIndex = 9;
            // 
            // labelQuantity
            // 
            this.labelQuantity.AutoSize = true;
            this.labelQuantity.Location = new System.Drawing.Point(262, 179);
            this.labelQuantity.Name = "labelQuantity";
            this.labelQuantity.Size = new System.Drawing.Size(16, 16);
            this.labelQuantity.TabIndex = 10;
            this.labelQuantity.Text = "...";
            // 
            // labelAverage
            // 
            this.labelAverage.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelAverage.AutoSize = true;
            this.labelAverage.Location = new System.Drawing.Point(262, 214);
            this.labelAverage.Name = "labelAverage";
            this.labelAverage.Size = new System.Drawing.Size(16, 16);
            this.labelAverage.TabIndex = 11;
            this.labelAverage.Text = "...";
            // 
            // labelExpensive
            // 
            this.labelExpensive.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelExpensive.AutoSize = true;
            this.labelExpensive.Location = new System.Drawing.Point(262, 249);
            this.labelExpensive.Name = "labelExpensive";
            this.labelExpensive.Size = new System.Drawing.Size(16, 16);
            this.labelExpensive.TabIndex = 12;
            this.labelExpensive.Text = "...";
            // 
            // labelCheapest
            // 
            this.labelCheapest.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelCheapest.AutoSize = true;
            this.labelCheapest.Location = new System.Drawing.Point(262, 285);
            this.labelCheapest.Name = "labelCheapest";
            this.labelCheapest.Size = new System.Drawing.Size(16, 16);
            this.labelCheapest.TabIndex = 13;
            this.labelCheapest.Text = "...";
            // 
            // PStats
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(645, 444);
            this.Controls.Add(this.labelCheapest);
            this.Controls.Add(this.labelExpensive);
            this.Controls.Add(this.labelAverage);
            this.Controls.Add(this.labelQuantity);
            this.Controls.Add(this.listBox1);
            this.Controls.Add(this.labelListado);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBoxFamily);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "PStats";
            this.Text = "Estadísticas";
            this.Load += new System.EventHandler(this.PStats_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ComboBox comboBoxFamily;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label labelListado;
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.Label labelQuantity;
        private System.Windows.Forms.Label labelAverage;
        private System.Windows.Forms.Label labelExpensive;
        private System.Windows.Forms.Label labelCheapest;
    }
}