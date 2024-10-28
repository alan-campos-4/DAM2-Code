namespace WinForms_Ejer1
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
            this.Num1 = new System.Windows.Forms.TextBox();
            this.Num2 = new System.Windows.Forms.TextBox();
            this.Adder = new System.Windows.Forms.Button();
            this.Title = new System.Windows.Forms.Label();
            this.Result = new System.Windows.Forms.Label();
            this.Num1Label = new System.Windows.Forms.Label();
            this.Num2Label = new System.Windows.Forms.Label();
            this.ResultLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // Num1
            // 
            this.Num1.Location = new System.Drawing.Point(383, 161);
            this.Num1.Name = "Num1";
            this.Num1.Size = new System.Drawing.Size(60, 22);
            this.Num1.TabIndex = 0;
            // 
            // Num2
            // 
            this.Num2.Location = new System.Drawing.Point(383, 201);
            this.Num2.Name = "Num2";
            this.Num2.Size = new System.Drawing.Size(60, 22);
            this.Num2.TabIndex = 1;
            // 
            // Adder
            // 
            this.Adder.Location = new System.Drawing.Point(303, 247);
            this.Adder.Name = "Adder";
            this.Adder.Size = new System.Drawing.Size(140, 49);
            this.Adder.TabIndex = 2;
            this.Adder.Text = "Suma";
            this.Adder.UseVisualStyleBackColor = true;
            this.Adder.Click += new System.EventHandler(this.Adder_Click);
            // 
            // Title
            // 
            this.Title.AutoSize = true;
            this.Title.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.Title.Location = new System.Drawing.Point(273, 57);
            this.Title.Name = "Title";
            this.Title.Size = new System.Drawing.Size(197, 20);
            this.Title.TabIndex = 3;
            this.Title.Text = "Suma entre dos números";
            // 
            // Result
            // 
            this.Result.AutoSize = true;
            this.Result.Location = new System.Drawing.Point(380, 319);
            this.Result.Name = "Result";
            this.Result.Size = new System.Drawing.Size(14, 16);
            this.Result.TabIndex = 4;
            this.Result.Text = "0";
            // 
            // Num1Label
            // 
            this.Num1Label.AutoSize = true;
            this.Num1Label.Location = new System.Drawing.Point(300, 164);
            this.Num1Label.Name = "Num1Label";
            this.Num1Label.Size = new System.Drawing.Size(65, 16);
            this.Num1Label.TabIndex = 5;
            this.Num1Label.Text = "Número 1";
            // 
            // Num2Label
            // 
            this.Num2Label.AutoSize = true;
            this.Num2Label.Location = new System.Drawing.Point(300, 204);
            this.Num2Label.Name = "Num2Label";
            this.Num2Label.Size = new System.Drawing.Size(65, 16);
            this.Num2Label.TabIndex = 6;
            this.Num2Label.Text = "Número 2";
            // 
            // ResultLabel
            // 
            this.ResultLabel.AutoSize = true;
            this.ResultLabel.Location = new System.Drawing.Point(300, 319);
            this.ResultLabel.Name = "ResultLabel";
            this.ResultLabel.Size = new System.Drawing.Size(69, 16);
            this.ResultLabel.TabIndex = 7;
            this.ResultLabel.Text = "Resultado";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.ResultLabel);
            this.Controls.Add(this.Num2Label);
            this.Controls.Add(this.Num1Label);
            this.Controls.Add(this.Result);
            this.Controls.Add(this.Title);
            this.Controls.Add(this.Adder);
            this.Controls.Add(this.Num2);
            this.Controls.Add(this.Num1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox Num1;
        private System.Windows.Forms.TextBox Num2;
        private System.Windows.Forms.Button Adder;
        private System.Windows.Forms.Label Title;
        private System.Windows.Forms.Label Result;
        private System.Windows.Forms.Label Num1Label;
        private System.Windows.Forms.Label Num2Label;
        private System.Windows.Forms.Label ResultLabel;
    }
}

