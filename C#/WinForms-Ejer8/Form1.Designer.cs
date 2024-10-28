namespace WinForms_Ejer8
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
            this.buttonCalc = new System.Windows.Forms.Button();
            this.quantity1 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.labelTotal = new System.Windows.Forms.Label();
            this.labelError = new System.Windows.Forms.Label();
            this.quantity2 = new System.Windows.Forms.TextBox();
            this.quantity3 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxCode1 = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.textBoxCode2 = new System.Windows.Forms.TextBox();
            this.textBoxCode3 = new System.Windows.Forms.TextBox();
            this.textBoxPrice3 = new System.Windows.Forms.TextBox();
            this.textBoxPrice2 = new System.Windows.Forms.TextBox();
            this.textBoxPrice1 = new System.Windows.Forms.TextBox();
            this.textBoxSubtotal3 = new System.Windows.Forms.TextBox();
            this.textBoxSubtotal2 = new System.Windows.Forms.TextBox();
            this.textBoxSubtotal1 = new System.Windows.Forms.TextBox();
            this.textBoxDesc1 = new System.Windows.Forms.TextBox();
            this.textBoxDesc2 = new System.Windows.Forms.TextBox();
            this.textBoxDesc3 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.labelTotalIva = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // buttonCalc
            // 
            this.buttonCalc.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonCalc.Location = new System.Drawing.Point(378, 270);
            this.buttonCalc.Name = "buttonCalc";
            this.buttonCalc.Size = new System.Drawing.Size(87, 38);
            this.buttonCalc.TabIndex = 0;
            this.buttonCalc.Text = "Calcular";
            this.buttonCalc.UseVisualStyleBackColor = true;
            this.buttonCalc.Click += new System.EventHandler(this.button1_Click);
            // 
            // quantity1
            // 
            this.quantity1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.quantity1.Location = new System.Drawing.Point(429, 161);
            this.quantity1.Name = "quantity1";
            this.quantity1.Size = new System.Drawing.Size(66, 20);
            this.quantity1.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(436, 144);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Cantidad";
            // 
            // labelTotal
            // 
            this.labelTotal.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelTotal.AutoSize = true;
            this.labelTotal.Location = new System.Drawing.Point(540, 270);
            this.labelTotal.Name = "labelTotal";
            this.labelTotal.Size = new System.Drawing.Size(16, 13);
            this.labelTotal.TabIndex = 5;
            this.labelTotal.Text = "...";
            // 
            // labelError
            // 
            this.labelError.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelError.AutoSize = true;
            this.labelError.Location = new System.Drawing.Point(384, 254);
            this.labelError.Name = "labelError";
            this.labelError.Size = new System.Drawing.Size(16, 13);
            this.labelError.TabIndex = 6;
            this.labelError.Text = "...";
            // 
            // quantity2
            // 
            this.quantity2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.quantity2.Location = new System.Drawing.Point(429, 187);
            this.quantity2.Name = "quantity2";
            this.quantity2.Size = new System.Drawing.Size(66, 20);
            this.quantity2.TabIndex = 8;
            // 
            // quantity3
            // 
            this.quantity3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.quantity3.Location = new System.Drawing.Point(429, 213);
            this.quantity3.Name = "quantity3";
            this.quantity3.Size = new System.Drawing.Size(66, 20);
            this.quantity3.TabIndex = 10;
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(513, 144);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(37, 13);
            this.label3.TabIndex = 11;
            this.label3.Text = "Precio";
            // 
            // label4
            // 
            this.label4.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(582, 145);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(46, 13);
            this.label4.TabIndex = 15;
            this.label4.Text = "Subtotal";
            // 
            // textBoxCode1
            // 
            this.textBoxCode1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxCode1.Location = new System.Drawing.Point(152, 160);
            this.textBoxCode1.Name = "textBoxCode1";
            this.textBoxCode1.Size = new System.Drawing.Size(88, 20);
            this.textBoxCode1.TabIndex = 19;
            // 
            // label5
            // 
            this.label5.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(159, 144);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(40, 13);
            this.label5.TabIndex = 20;
            this.label5.Text = "Código";
            // 
            // textBoxCode2
            // 
            this.textBoxCode2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxCode2.Location = new System.Drawing.Point(152, 187);
            this.textBoxCode2.Name = "textBoxCode2";
            this.textBoxCode2.Size = new System.Drawing.Size(88, 20);
            this.textBoxCode2.TabIndex = 21;
            // 
            // textBoxCode3
            // 
            this.textBoxCode3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxCode3.Location = new System.Drawing.Point(152, 213);
            this.textBoxCode3.Name = "textBoxCode3";
            this.textBoxCode3.Size = new System.Drawing.Size(88, 20);
            this.textBoxCode3.TabIndex = 22;
            // 
            // textBoxPrice3
            // 
            this.textBoxPrice3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxPrice3.Location = new System.Drawing.Point(501, 213);
            this.textBoxPrice3.Name = "textBoxPrice3";
            this.textBoxPrice3.Size = new System.Drawing.Size(66, 20);
            this.textBoxPrice3.TabIndex = 25;
            // 
            // textBoxPrice2
            // 
            this.textBoxPrice2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxPrice2.Location = new System.Drawing.Point(501, 187);
            this.textBoxPrice2.Name = "textBoxPrice2";
            this.textBoxPrice2.Size = new System.Drawing.Size(66, 20);
            this.textBoxPrice2.TabIndex = 24;
            // 
            // textBoxPrice1
            // 
            this.textBoxPrice1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxPrice1.Location = new System.Drawing.Point(501, 161);
            this.textBoxPrice1.Name = "textBoxPrice1";
            this.textBoxPrice1.Size = new System.Drawing.Size(66, 20);
            this.textBoxPrice1.TabIndex = 23;
            // 
            // textBoxSubtotal3
            // 
            this.textBoxSubtotal3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxSubtotal3.Location = new System.Drawing.Point(573, 213);
            this.textBoxSubtotal3.Name = "textBoxSubtotal3";
            this.textBoxSubtotal3.Size = new System.Drawing.Size(66, 20);
            this.textBoxSubtotal3.TabIndex = 28;
            // 
            // textBoxSubtotal2
            // 
            this.textBoxSubtotal2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxSubtotal2.Location = new System.Drawing.Point(573, 187);
            this.textBoxSubtotal2.Name = "textBoxSubtotal2";
            this.textBoxSubtotal2.Size = new System.Drawing.Size(66, 20);
            this.textBoxSubtotal2.TabIndex = 27;
            // 
            // textBoxSubtotal1
            // 
            this.textBoxSubtotal1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxSubtotal1.Location = new System.Drawing.Point(573, 161);
            this.textBoxSubtotal1.Name = "textBoxSubtotal1";
            this.textBoxSubtotal1.Size = new System.Drawing.Size(66, 20);
            this.textBoxSubtotal1.TabIndex = 26;
            // 
            // textBoxDesc1
            // 
            this.textBoxDesc1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxDesc1.Location = new System.Drawing.Point(246, 161);
            this.textBoxDesc1.Name = "textBoxDesc1";
            this.textBoxDesc1.Size = new System.Drawing.Size(177, 20);
            this.textBoxDesc1.TabIndex = 29;
            // 
            // textBoxDesc2
            // 
            this.textBoxDesc2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxDesc2.Location = new System.Drawing.Point(246, 187);
            this.textBoxDesc2.Name = "textBoxDesc2";
            this.textBoxDesc2.Size = new System.Drawing.Size(177, 20);
            this.textBoxDesc2.TabIndex = 30;
            // 
            // textBoxDesc3
            // 
            this.textBoxDesc3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxDesc3.Location = new System.Drawing.Point(246, 213);
            this.textBoxDesc3.Name = "textBoxDesc3";
            this.textBoxDesc3.Size = new System.Drawing.Size(177, 20);
            this.textBoxDesc3.TabIndex = 31;
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(255, 145);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(63, 13);
            this.label1.TabIndex = 32;
            this.label1.Text = "Descripción";
            // 
            // labelTotalIva
            // 
            this.labelTotalIva.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelTotalIva.AutoSize = true;
            this.labelTotalIva.Location = new System.Drawing.Point(540, 295);
            this.labelTotalIva.Name = "labelTotalIva";
            this.labelTotalIva.Size = new System.Drawing.Size(16, 13);
            this.labelTotalIva.TabIndex = 33;
            this.labelTotalIva.Text = "...";
            // 
            // label6
            // 
            this.label6.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(471, 295);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(66, 13);
            this.label6.TabIndex = 34;
            this.label6.Text = "Total + IVA: ";
            // 
            // label7
            // 
            this.label7.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(471, 270);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(37, 13);
            this.label7.TabIndex = 35;
            this.label7.Text = "Total: ";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.labelTotalIva);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBoxDesc3);
            this.Controls.Add(this.textBoxDesc2);
            this.Controls.Add(this.textBoxDesc1);
            this.Controls.Add(this.textBoxSubtotal3);
            this.Controls.Add(this.textBoxSubtotal2);
            this.Controls.Add(this.textBoxSubtotal1);
            this.Controls.Add(this.textBoxPrice3);
            this.Controls.Add(this.textBoxPrice2);
            this.Controls.Add(this.textBoxPrice1);
            this.Controls.Add(this.textBoxCode3);
            this.Controls.Add(this.textBoxCode2);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.textBoxCode1);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.quantity3);
            this.Controls.Add(this.quantity2);
            this.Controls.Add(this.labelError);
            this.Controls.Add(this.labelTotal);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.quantity1);
            this.Controls.Add(this.buttonCalc);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonCalc;
        private System.Windows.Forms.TextBox quantity1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label labelTotal;
        private System.Windows.Forms.Label labelError;
        private System.Windows.Forms.TextBox quantity2;
        private System.Windows.Forms.TextBox quantity3;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxCode1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBoxCode2;
        private System.Windows.Forms.TextBox textBoxCode3;
        private System.Windows.Forms.TextBox textBoxPrice3;
        private System.Windows.Forms.TextBox textBoxPrice2;
        private System.Windows.Forms.TextBox textBoxPrice1;
        private System.Windows.Forms.TextBox textBoxSubtotal3;
        private System.Windows.Forms.TextBox textBoxSubtotal2;
        private System.Windows.Forms.TextBox textBoxSubtotal1;
        private System.Windows.Forms.TextBox textBoxDesc1;
        private System.Windows.Forms.TextBox textBoxDesc2;
        private System.Windows.Forms.TextBox textBoxDesc3;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelTotalIva;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
    }
}

