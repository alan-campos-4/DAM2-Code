namespace App2
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
            this.Generator = new System.Windows.Forms.Button();
            this.NumGenerated = new System.Windows.Forms.Label();
            this.Comparer = new System.Windows.Forms.Button();
            this.UserInput = new System.Windows.Forms.TextBox();
            this.Result = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // Generator
            // 
            this.Generator.Location = new System.Drawing.Point(252, 247);
            this.Generator.Name = "Generator";
            this.Generator.Size = new System.Drawing.Size(85, 44);
            this.Generator.TabIndex = 0;
            this.Generator.Text = "Generar";
            this.Generator.UseVisualStyleBackColor = true;
            this.Generator.Click += new System.EventHandler(this.Generator_Click);
            // 
            // NumGenerated
            // 
            this.NumGenerated.AutoSize = true;
            this.NumGenerated.Location = new System.Drawing.Point(290, 220);
            this.NumGenerated.Name = "NumGenerated";
            this.NumGenerated.Size = new System.Drawing.Size(14, 16);
            this.NumGenerated.TabIndex = 1;
            this.NumGenerated.Text = "0";
            // 
            // Comparer
            // 
            this.Comparer.Location = new System.Drawing.Point(386, 247);
            this.Comparer.Name = "Comparer";
            this.Comparer.Size = new System.Drawing.Size(82, 43);
            this.Comparer.TabIndex = 2;
            this.Comparer.Text = "Comparar";
            this.Comparer.UseVisualStyleBackColor = true;
            this.Comparer.Click += new System.EventHandler(this.Comparer_Click);
            // 
            // UserInput
            // 
            this.UserInput.Location = new System.Drawing.Point(402, 219);
            this.UserInput.Name = "UserInput";
            this.UserInput.Size = new System.Drawing.Size(52, 22);
            this.UserInput.TabIndex = 3;
            // 
            // Result
            // 
            this.Result.AutoSize = true;
            this.Result.Location = new System.Drawing.Point(531, 247);
            this.Result.Name = "Result";
            this.Result.Size = new System.Drawing.Size(14, 16);
            this.Result.TabIndex = 4;
            this.Result.Text = "_";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.Result);
            this.Controls.Add(this.UserInput);
            this.Controls.Add(this.Comparer);
            this.Controls.Add(this.NumGenerated);
            this.Controls.Add(this.Generator);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button Generator;
        private System.Windows.Forms.Label NumGenerated;
        private System.Windows.Forms.Button Comparer;
        private System.Windows.Forms.TextBox UserInput;
        private System.Windows.Forms.Label Result;
    }
}

