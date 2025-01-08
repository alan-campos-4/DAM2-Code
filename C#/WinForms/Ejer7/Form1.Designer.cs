namespace WinForms_Ejer7
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
            this.radioButtonAdd = new System.Windows.Forms.RadioButton();
            this.radioButtonSubt = new System.Windows.Forms.RadioButton();
            this.radioButtonMult = new System.Windows.Forms.RadioButton();
            this.radioButtonDivide = new System.Windows.Forms.RadioButton();
            this.radioButtonAll = new System.Windows.Forms.RadioButton();
            this.groupBoxRB = new System.Windows.Forms.GroupBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.buttonOk = new System.Windows.Forms.Button();
            this.buttonDelete = new System.Windows.Forms.Button();
            this.buttonOut = new System.Windows.Forms.Button();
            this.labelEnter = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.labelResult = new System.Windows.Forms.Label();
            this.groupBoxRB.SuspendLayout();
            this.SuspendLayout();
            // 
            // radioButtonAdd
            // 
            this.radioButtonAdd.AutoSize = true;
            this.radioButtonAdd.Location = new System.Drawing.Point(17, 22);
            this.radioButtonAdd.Name = "radioButtonAdd";
            this.radioButtonAdd.Size = new System.Drawing.Size(64, 20);
            this.radioButtonAdd.TabIndex = 0;
            this.radioButtonAdd.TabStop = true;
            this.radioButtonAdd.Text = "Sumar";
            this.radioButtonAdd.UseVisualStyleBackColor = true;
            // 
            // radioButtonSubt
            // 
            this.radioButtonSubt.AutoSize = true;
            this.radioButtonSubt.Location = new System.Drawing.Point(17, 48);
            this.radioButtonSubt.Name = "radioButtonSubt";
            this.radioButtonSubt.Size = new System.Drawing.Size(65, 20);
            this.radioButtonSubt.TabIndex = 1;
            this.radioButtonSubt.TabStop = true;
            this.radioButtonSubt.Text = "Restar";
            this.radioButtonSubt.UseVisualStyleBackColor = true;
            // 
            // radioButtonMult
            // 
            this.radioButtonMult.AutoSize = true;
            this.radioButtonMult.Location = new System.Drawing.Point(16, 74);
            this.radioButtonMult.Name = "radioButtonMult";
            this.radioButtonMult.Size = new System.Drawing.Size(85, 20);
            this.radioButtonMult.TabIndex = 2;
            this.radioButtonMult.TabStop = true;
            this.radioButtonMult.Text = "Multiplicar";
            this.radioButtonMult.UseVisualStyleBackColor = true;
            // 
            // radioButtonDivide
            // 
            this.radioButtonDivide.AutoSize = true;
            this.radioButtonDivide.Location = new System.Drawing.Point(16, 100);
            this.radioButtonDivide.Name = "radioButtonDivide";
            this.radioButtonDivide.Size = new System.Drawing.Size(63, 20);
            this.radioButtonDivide.TabIndex = 3;
            this.radioButtonDivide.TabStop = true;
            this.radioButtonDivide.Text = "Dividir";
            this.radioButtonDivide.UseVisualStyleBackColor = true;
            // 
            // radioButtonAll
            // 
            this.radioButtonAll.AutoSize = true;
            this.radioButtonAll.Location = new System.Drawing.Point(17, 126);
            this.radioButtonAll.Name = "radioButtonAll";
            this.radioButtonAll.Size = new System.Drawing.Size(65, 20);
            this.radioButtonAll.TabIndex = 4;
            this.radioButtonAll.TabStop = true;
            this.radioButtonAll.Text = "Todas";
            this.radioButtonAll.UseVisualStyleBackColor = true;
            // 
            // groupBoxRB
            // 
            this.groupBoxRB.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.groupBoxRB.Controls.Add(this.radioButtonAll);
            this.groupBoxRB.Controls.Add(this.radioButtonAdd);
            this.groupBoxRB.Controls.Add(this.radioButtonDivide);
            this.groupBoxRB.Controls.Add(this.radioButtonSubt);
            this.groupBoxRB.Controls.Add(this.radioButtonMult);
            this.groupBoxRB.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBoxRB.Location = new System.Drawing.Point(176, 134);
            this.groupBoxRB.Name = "groupBoxRB";
            this.groupBoxRB.Size = new System.Drawing.Size(107, 159);
            this.groupBoxRB.TabIndex = 5;
            this.groupBoxRB.TabStop = false;
            this.groupBoxRB.Text = "Acciones";
            // 
            // textBox1
            // 
            this.textBox1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBox1.Location = new System.Drawing.Point(294, 158);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(59, 20);
            this.textBox1.TabIndex = 6;
            // 
            // textBox2
            // 
            this.textBox2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBox2.Location = new System.Drawing.Point(373, 158);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(59, 20);
            this.textBox2.TabIndex = 7;
            // 
            // textBox3
            // 
            this.textBox3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBox3.Location = new System.Drawing.Point(448, 158);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(59, 20);
            this.textBox3.TabIndex = 8;
            // 
            // buttonOk
            // 
            this.buttonOk.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonOk.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonOk.Location = new System.Drawing.Point(277, 299);
            this.buttonOk.Name = "buttonOk";
            this.buttonOk.Size = new System.Drawing.Size(76, 23);
            this.buttonOk.TabIndex = 9;
            this.buttonOk.Text = "Aceptar";
            this.buttonOk.UseVisualStyleBackColor = true;
            this.buttonOk.Click += new System.EventHandler(this.buttonOk_Click);
            // 
            // buttonDelete
            // 
            this.buttonDelete.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonDelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonDelete.Location = new System.Drawing.Point(359, 299);
            this.buttonDelete.Name = "buttonDelete";
            this.buttonDelete.Size = new System.Drawing.Size(71, 23);
            this.buttonDelete.TabIndex = 10;
            this.buttonDelete.Text = "Borrar";
            this.buttonDelete.UseVisualStyleBackColor = true;
            this.buttonDelete.Click += new System.EventHandler(this.buttonDelete_Click);
            // 
            // buttonOut
            // 
            this.buttonOut.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonOut.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonOut.Location = new System.Drawing.Point(436, 299);
            this.buttonOut.Name = "buttonOut";
            this.buttonOut.Size = new System.Drawing.Size(71, 23);
            this.buttonOut.TabIndex = 11;
            this.buttonOut.Text = "Salir";
            this.buttonOut.UseVisualStyleBackColor = true;
            this.buttonOut.Click += new System.EventHandler(this.buttonOut_Click);
            // 
            // labelEnter
            // 
            this.labelEnter.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelEnter.AutoSize = true;
            this.labelEnter.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelEnter.Location = new System.Drawing.Point(334, 125);
            this.labelEnter.Name = "labelEnter";
            this.labelEnter.Size = new System.Drawing.Size(138, 18);
            this.labelEnter.TabIndex = 12;
            this.labelEnter.Text = "Ingrese 3 Números:";
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(263, 63);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(209, 24);
            this.label1.TabIndex = 13;
            this.label1.Text = "Sumar Tres Números";
            // 
            // labelResult
            // 
            this.labelResult.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelResult.AutoSize = true;
            this.labelResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelResult.Location = new System.Drawing.Point(291, 198);
            this.labelResult.Name = "labelResult";
            this.labelResult.Size = new System.Drawing.Size(126, 16);
            this.labelResult.TabIndex = 14;
            this.labelResult.Text = "Los resultados son: ";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(239)))), ((int)(((byte)(230)))), ((int)(((byte)(144)))));
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.labelResult);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.labelEnter);
            this.Controls.Add(this.buttonOut);
            this.Controls.Add(this.buttonDelete);
            this.Controls.Add(this.buttonOk);
            this.Controls.Add(this.textBox3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.groupBoxRB);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBoxRB.ResumeLayout(false);
            this.groupBoxRB.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton radioButtonAdd;
        private System.Windows.Forms.RadioButton radioButtonSubt;
        private System.Windows.Forms.RadioButton radioButtonMult;
        private System.Windows.Forms.RadioButton radioButtonDivide;
        private System.Windows.Forms.RadioButton radioButtonAll;
        private System.Windows.Forms.GroupBox groupBoxRB;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.Button buttonOk;
        private System.Windows.Forms.Button buttonDelete;
        private System.Windows.Forms.Button buttonOut;
        private System.Windows.Forms.Label labelEnter;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelResult;
    }
}

