﻿namespace WinForms_Project2
{
    partial class PAlumnosAlta
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxName1 = new System.Windows.Forms.TextBox();
            this.textBoxName2 = new System.Windows.Forms.TextBox();
            this.textBoxPhone = new System.Windows.Forms.TextBox();
            this.buttonOK = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.labelError = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxCode = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(111, 102);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Nombre";
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(111, 143);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Apellidos";
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(111, 183);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Teléfono";
            // 
            // textBoxCode
            // 
            this.textBoxCode.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxCode.Location = new System.Drawing.Point(179, 61);
            this.textBoxCode.Name = "textBoxCode";
            this.textBoxCode.Size = new System.Drawing.Size(135, 20);
            this.textBoxCode.TabIndex = 3;
            this.textBoxCode.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.checkOnlyLetters_KeyPress);
            // 
            // textBoxName1
            // 
            this.textBoxName1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxName1.Location = new System.Drawing.Point(179, 99);
            this.textBoxName1.Name = "textBoxName1";
            this.textBoxName1.Size = new System.Drawing.Size(135, 20);
            this.textBoxName1.TabIndex = 4;
            this.textBoxName1.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.checkOnlyLetters_KeyPress);
            // 
            // textBoxName2
            // 
            this.textBoxName2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxName2.Location = new System.Drawing.Point(179, 140);
            this.textBoxName2.Name = "textBoxName2";
            this.textBoxName2.Size = new System.Drawing.Size(135, 20);
            this.textBoxName2.TabIndex = 5;
            this.textBoxName2.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.checkOnlyLetters_KeyPress);
            // 
            // textBoxPhone
            // 
            this.textBoxPhone.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxPhone.Location = new System.Drawing.Point(179, 180);
            this.textBoxPhone.Name = "textBoxPhone";
            this.textBoxPhone.Size = new System.Drawing.Size(135, 20);
            this.textBoxPhone.TabIndex = 6;
            this.textBoxPhone.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.checkOnlyNumbers_KeyPress);
            // 
            // buttonOK
            // 
            this.buttonOK.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonOK.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.buttonOK.Location = new System.Drawing.Point(127, 239);
            this.buttonOK.Name = "buttonOK";
            this.buttonOK.Size = new System.Drawing.Size(70, 29);
            this.buttonOK.TabIndex = 7;
            this.buttonOK.Text = "OK";
            this.buttonOK.UseVisualStyleBackColor = true;
            this.buttonOK.Click += new System.EventHandler(this.buttonOK_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonCancel.Location = new System.Drawing.Point(214, 239);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(70, 29);
            this.buttonCancel.TabIndex = 8;
            this.buttonCancel.Text = "Cancelar";
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // labelError
            // 
            this.labelError.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelError.AutoSize = true;
            this.labelError.Location = new System.Drawing.Point(124, 223);
            this.labelError.Name = "labelError";
            this.labelError.Size = new System.Drawing.Size(0, 13);
            this.labelError.TabIndex = 9;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(111, 64);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(40, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Código";
            // 
            // PAlta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(421, 345);
            this.Controls.Add(this.textBoxCode);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.labelError);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonOK);
            this.Controls.Add(this.textBoxPhone);
            this.Controls.Add(this.textBoxName2);
            this.Controls.Add(this.textBoxName1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "PAlta";
            this.Text = "Alta a alumno";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        public System.Windows.Forms.TextBox textBoxCode;
        public System.Windows.Forms.TextBox textBoxName1;
        public System.Windows.Forms.TextBox textBoxName2;
        public System.Windows.Forms.TextBox textBoxPhone;
        private System.Windows.Forms.Button buttonOK;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.Label labelError;
        private System.Windows.Forms.Label label4;
    }
}