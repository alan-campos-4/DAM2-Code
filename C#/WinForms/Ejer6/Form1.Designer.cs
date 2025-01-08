namespace WinForms_Ejer6
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxTotal = new System.Windows.Forms.TextBox();
            this.labelTotal = new System.Windows.Forms.Label();
            this.labelGiven = new System.Windows.Forms.Label();
            this.textBoxGiven = new System.Windows.Forms.TextBox();
            this.labelChange = new System.Windows.Forms.Label();
            this.textBoxChange = new System.Windows.Forms.TextBox();
            this.labelExpiration = new System.Windows.Forms.Label();
            this.textBoxExpiration = new System.Windows.Forms.TextBox();
            this.labelCard = new System.Windows.Forms.Label();
            this.textBoxCard = new System.Windows.Forms.TextBox();
            this.panelCredit = new System.Windows.Forms.Panel();
            this.panelCash = new System.Windows.Forms.Panel();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.panelCredit.SuspendLayout();
            this.panelCash.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(249, 129);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(86, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Método de Pago";
            // 
            // textBoxTotal
            // 
            this.textBoxTotal.Location = new System.Drawing.Point(68, 4);
            this.textBoxTotal.Name = "textBoxTotal";
            this.textBoxTotal.Size = new System.Drawing.Size(78, 20);
            this.textBoxTotal.TabIndex = 2;
            // 
            // labelTotal
            // 
            this.labelTotal.AutoSize = true;
            this.labelTotal.Location = new System.Drawing.Point(6, 7);
            this.labelTotal.Name = "labelTotal";
            this.labelTotal.Size = new System.Drawing.Size(31, 13);
            this.labelTotal.TabIndex = 3;
            this.labelTotal.Text = "Total";
            // 
            // labelGiven
            // 
            this.labelGiven.AutoSize = true;
            this.labelGiven.Location = new System.Drawing.Point(6, 48);
            this.labelGiven.Name = "labelGiven";
            this.labelGiven.Size = new System.Drawing.Size(56, 13);
            this.labelGiven.TabIndex = 5;
            this.labelGiven.Text = "Entregado";
            // 
            // textBoxGiven
            // 
            this.textBoxGiven.Location = new System.Drawing.Point(68, 45);
            this.textBoxGiven.Name = "textBoxGiven";
            this.textBoxGiven.Size = new System.Drawing.Size(78, 20);
            this.textBoxGiven.TabIndex = 4;
            // 
            // labelChange
            // 
            this.labelChange.AutoSize = true;
            this.labelChange.Location = new System.Drawing.Point(6, 90);
            this.labelChange.Name = "labelChange";
            this.labelChange.Size = new System.Drawing.Size(42, 13);
            this.labelChange.TabIndex = 7;
            this.labelChange.Text = "Cambio";
            // 
            // textBoxChange
            // 
            this.textBoxChange.Location = new System.Drawing.Point(68, 87);
            this.textBoxChange.Name = "textBoxChange";
            this.textBoxChange.Size = new System.Drawing.Size(78, 20);
            this.textBoxChange.TabIndex = 6;
            // 
            // labelExpiration
            // 
            this.labelExpiration.AutoSize = true;
            this.labelExpiration.Location = new System.Drawing.Point(3, 51);
            this.labelExpiration.Name = "labelExpiration";
            this.labelExpiration.Size = new System.Drawing.Size(91, 13);
            this.labelExpiration.TabIndex = 11;
            this.labelExpiration.Text = "Fecha Caducidad";
            // 
            // textBoxExpiration
            // 
            this.textBoxExpiration.Location = new System.Drawing.Point(100, 48);
            this.textBoxExpiration.Name = "textBoxExpiration";
            this.textBoxExpiration.Size = new System.Drawing.Size(78, 20);
            this.textBoxExpiration.TabIndex = 10;
            // 
            // labelCard
            // 
            this.labelCard.AutoSize = true;
            this.labelCard.Location = new System.Drawing.Point(3, 10);
            this.labelCard.Name = "labelCard";
            this.labelCard.Size = new System.Drawing.Size(55, 13);
            this.labelCard.TabIndex = 9;
            this.labelCard.Text = "Nº Tarjeta";
            // 
            // textBoxCard
            // 
            this.textBoxCard.Location = new System.Drawing.Point(100, 7);
            this.textBoxCard.Name = "textBoxCard";
            this.textBoxCard.Size = new System.Drawing.Size(140, 20);
            this.textBoxCard.TabIndex = 8;
            // 
            // panelCredit
            // 
            this.panelCredit.Controls.Add(this.labelChange);
            this.panelCredit.Controls.Add(this.textBoxChange);
            this.panelCredit.Controls.Add(this.labelGiven);
            this.panelCredit.Controls.Add(this.textBoxGiven);
            this.panelCredit.Controls.Add(this.labelTotal);
            this.panelCredit.Controls.Add(this.textBoxTotal);
            this.panelCredit.Location = new System.Drawing.Point(233, 181);
            this.panelCredit.Name = "panelCredit";
            this.panelCredit.Size = new System.Drawing.Size(151, 112);
            this.panelCredit.TabIndex = 13;
            // 
            // panelCash
            // 
            this.panelCash.Controls.Add(this.labelExpiration);
            this.panelCash.Controls.Add(this.textBoxExpiration);
            this.panelCash.Controls.Add(this.labelCard);
            this.panelCash.Controls.Add(this.textBoxCard);
            this.panelCash.Location = new System.Drawing.Point(402, 181);
            this.panelCash.Name = "panelCash";
            this.panelCash.Size = new System.Drawing.Size(246, 112);
            this.panelCash.TabIndex = 14;
            // 
            // comboBox1
            // 
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Tarjeta",
            "Efectivo"});
            this.comboBox1.Location = new System.Drawing.Point(339, 126);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(121, 21);
            this.comboBox1.TabIndex = 15;
            this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged_1);
            // 
            // Form1
            // 
            this.AllowDrop = true;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.panelCash);
            this.Controls.Add(this.panelCredit);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.panelCredit.ResumeLayout(false);
            this.panelCredit.PerformLayout();
            this.panelCash.ResumeLayout(false);
            this.panelCash.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxTotal;
        private System.Windows.Forms.Label labelTotal;
        private System.Windows.Forms.Label labelGiven;
        private System.Windows.Forms.TextBox textBoxGiven;
        private System.Windows.Forms.Label labelChange;
        private System.Windows.Forms.TextBox textBoxChange;
        private System.Windows.Forms.Label labelExpiration;
        private System.Windows.Forms.TextBox textBoxExpiration;
        private System.Windows.Forms.Label labelCard;
        private System.Windows.Forms.TextBox textBoxCard;
        private System.Windows.Forms.Panel panelCredit;
        private System.Windows.Forms.Panel panelCash;
        private System.Windows.Forms.ComboBox comboBox1;
    }
}

