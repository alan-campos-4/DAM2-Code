namespace WinForms_Ejer2
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
            this.label2 = new System.Windows.Forms.Label();
            this.WordInput = new System.Windows.Forms.TextBox();
            this.TextInput = new System.Windows.Forms.TextBox();
            this.Search = new System.Windows.Forms.Button();
            this.Result = new System.Windows.Forms.Label();
            this.Title = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(229, 189);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(116, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Introduce una letra";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(229, 230);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(181, 16);
            this.label2.TabIndex = 1;
            this.label2.Text = "Introduce una palabra o frase";
            // 
            // WordInput
            // 
            this.WordInput.Location = new System.Drawing.Point(439, 186);
            this.WordInput.Name = "WordInput";
            this.WordInput.Size = new System.Drawing.Size(100, 22);
            this.WordInput.TabIndex = 2;
            // 
            // TextInput
            // 
            this.TextInput.Location = new System.Drawing.Point(439, 227);
            this.TextInput.Name = "TextInput";
            this.TextInput.Size = new System.Drawing.Size(100, 22);
            this.TextInput.TabIndex = 3;
            // 
            // Search
            // 
            this.Search.Location = new System.Drawing.Point(328, 275);
            this.Search.Name = "Search";
            this.Search.Size = new System.Drawing.Size(115, 47);
            this.Search.TabIndex = 4;
            this.Search.Text = "Buscar";
            this.Search.UseVisualStyleBackColor = true;
            this.Search.Click += new System.EventHandler(this.Search_Click);
            // 
            // Result
            // 
            this.Result.AutoSize = true;
            this.Result.Location = new System.Drawing.Point(333, 348);
            this.Result.Name = "Result";
            this.Result.Size = new System.Drawing.Size(0, 16);
            this.Result.TabIndex = 5;
            // 
            // Title
            // 
            this.Title.AutoSize = true;
            this.Title.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.Title.Location = new System.Drawing.Point(219, 76);
            this.Title.Name = "Title";
            this.Title.Size = new System.Drawing.Size(330, 20);
            this.Title.TabIndex = 6;
            this.Title.Text = "Encontrar cuántas veces aparece una letra";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.Title);
            this.Controls.Add(this.Result);
            this.Controls.Add(this.Search);
            this.Controls.Add(this.TextInput);
            this.Controls.Add(this.WordInput);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox WordInput;
        private System.Windows.Forms.TextBox TextInput;
        private System.Windows.Forms.Button Search;
        private System.Windows.Forms.Label Result;
        private System.Windows.Forms.Label Title;
    }
}

