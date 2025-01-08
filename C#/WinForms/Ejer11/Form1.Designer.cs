namespace WinForms_Ejer11
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
            this.button1 = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.radioButtonYes = new System.Windows.Forms.RadioButton();
            this.radioButtonNo = new System.Windows.Forms.RadioButton();
            this.radioButtonOther = new System.Windows.Forms.RadioButton();
            this.labelVotesYes = new System.Windows.Forms.Label();
            this.labelVotesNo = new System.Windows.Forms.Label();
            this.labelVotesOther = new System.Windows.Forms.Label();
            this.labelVotesTotal = new System.Windows.Forms.Label();
            this.progressBarYes = new System.Windows.Forms.ProgressBar();
            this.progressBarNo = new System.Windows.Forms.ProgressBar();
            this.progressBarOther = new System.Windows.Forms.ProgressBar();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(275, 258);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(98, 53);
            this.button1.TabIndex = 0;
            this.button1.Text = "Votar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.radioButtonOther);
            this.panel1.Controls.Add(this.radioButtonNo);
            this.panel1.Controls.Add(this.radioButtonYes);
            this.panel1.Location = new System.Drawing.Point(275, 141);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(98, 99);
            this.panel1.TabIndex = 1;
            // 
            // radioButtonYes
            // 
            this.radioButtonYes.AutoSize = true;
            this.radioButtonYes.Location = new System.Drawing.Point(20, 18);
            this.radioButtonYes.Name = "radioButtonYes";
            this.radioButtonYes.Size = new System.Drawing.Size(35, 17);
            this.radioButtonYes.TabIndex = 0;
            this.radioButtonYes.TabStop = true;
            this.radioButtonYes.Text = "SÍ";
            this.radioButtonYes.UseVisualStyleBackColor = true;
            // 
            // radioButtonNo
            // 
            this.radioButtonNo.AutoSize = true;
            this.radioButtonNo.Location = new System.Drawing.Point(20, 41);
            this.radioButtonNo.Name = "radioButtonNo";
            this.radioButtonNo.Size = new System.Drawing.Size(41, 17);
            this.radioButtonNo.TabIndex = 2;
            this.radioButtonNo.TabStop = true;
            this.radioButtonNo.Text = "NO";
            this.radioButtonNo.UseVisualStyleBackColor = true;
            // 
            // radioButtonOther
            // 
            this.radioButtonOther.AutoSize = true;
            this.radioButtonOther.Location = new System.Drawing.Point(20, 64);
            this.radioButtonOther.Name = "radioButtonOther";
            this.radioButtonOther.Size = new System.Drawing.Size(60, 17);
            this.radioButtonOther.TabIndex = 3;
            this.radioButtonOther.TabStop = true;
            this.radioButtonOther.Text = "NS/NC";
            this.radioButtonOther.UseVisualStyleBackColor = true;
            // 
            // labelVotesYes
            // 
            this.labelVotesYes.AutoSize = true;
            this.labelVotesYes.Location = new System.Drawing.Point(403, 153);
            this.labelVotesYes.Name = "labelVotesYes";
            this.labelVotesYes.Size = new System.Drawing.Size(56, 13);
            this.labelVotesYes.TabIndex = 2;
            this.labelVotesYes.Text = "0 votos Sí";
            // 
            // labelVotesNo
            // 
            this.labelVotesNo.AutoSize = true;
            this.labelVotesNo.Location = new System.Drawing.Point(403, 177);
            this.labelVotesNo.Name = "labelVotesNo";
            this.labelVotesNo.Size = new System.Drawing.Size(59, 13);
            this.labelVotesNo.TabIndex = 3;
            this.labelVotesNo.Text = "0 votos No";
            // 
            // labelVotesOther
            // 
            this.labelVotesOther.AutoSize = true;
            this.labelVotesOther.Location = new System.Drawing.Point(403, 202);
            this.labelVotesOther.Name = "labelVotesOther";
            this.labelVotesOther.Size = new System.Drawing.Size(80, 13);
            this.labelVotesOther.TabIndex = 4;
            this.labelVotesOther.Text = "0 votos NC/NS";
            // 
            // labelVotesTotal
            // 
            this.labelVotesTotal.AutoSize = true;
            this.labelVotesTotal.Location = new System.Drawing.Point(403, 227);
            this.labelVotesTotal.Name = "labelVotesTotal";
            this.labelVotesTotal.Size = new System.Drawing.Size(65, 13);
            this.labelVotesTotal.TabIndex = 5;
            this.labelVotesTotal.Text = "0 votos total";
            // 
            // progressBarYes
            // 
            this.progressBarYes.Location = new System.Drawing.Point(504, 156);
            this.progressBarYes.Name = "progressBarYes";
            this.progressBarYes.Size = new System.Drawing.Size(100, 10);
            this.progressBarYes.TabIndex = 6;
            // 
            // progressBarNo
            // 
            this.progressBarNo.Location = new System.Drawing.Point(504, 180);
            this.progressBarNo.Name = "progressBarNo";
            this.progressBarNo.Size = new System.Drawing.Size(100, 10);
            this.progressBarNo.TabIndex = 7;
            // 
            // progressBarOther
            // 
            this.progressBarOther.Location = new System.Drawing.Point(504, 205);
            this.progressBarOther.Name = "progressBarOther";
            this.progressBarOther.Size = new System.Drawing.Size(100, 10);
            this.progressBarOther.TabIndex = 8;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.progressBarOther);
            this.Controls.Add(this.progressBarNo);
            this.Controls.Add(this.progressBarYes);
            this.Controls.Add(this.labelVotesTotal);
            this.Controls.Add(this.labelVotesOther);
            this.Controls.Add(this.labelVotesNo);
            this.Controls.Add(this.labelVotesYes);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.RadioButton radioButtonOther;
        private System.Windows.Forms.RadioButton radioButtonNo;
        private System.Windows.Forms.RadioButton radioButtonYes;
        private System.Windows.Forms.Label labelVotesYes;
        private System.Windows.Forms.Label labelVotesNo;
        private System.Windows.Forms.Label labelVotesOther;
        private System.Windows.Forms.Label labelVotesTotal;
        private System.Windows.Forms.ProgressBar progressBarYes;
        private System.Windows.Forms.ProgressBar progressBarNo;
        private System.Windows.Forms.ProgressBar progressBarOther;
    }
}

