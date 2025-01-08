using System.Windows.Forms;

namespace WinForms_Facturacion
{
    partial class PAlta
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
            this.textBoxDesc = new System.Windows.Forms.TextBox();
            this.textBoxQuant = new System.Windows.Forms.TextBox();
            this.textBoxPrice = new System.Windows.Forms.TextBox();
            this.buttonOk = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.labelCode = new System.Windows.Forms.Label();
            this.labelDesc = new System.Windows.Forms.Label();
            this.labelQuant = new System.Windows.Forms.Label();
            this.labelPrice = new System.Windows.Forms.Label();
            this.labelError = new System.Windows.Forms.Label();
            this.numericUpDownCode = new System.Windows.Forms.NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownCode)).BeginInit();
            this.SuspendLayout();
            // 
            // textBoxDesc
            // 
            this.textBoxDesc.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxDesc.Location = new System.Drawing.Point(162, 75);
            this.textBoxDesc.Name = "textBoxDesc";
            this.textBoxDesc.ReadOnly = true;
            this.textBoxDesc.Size = new System.Drawing.Size(100, 20);
            this.textBoxDesc.TabIndex = 1;
            // 
            // textBoxQuant
            // 
            this.textBoxQuant.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxQuant.Location = new System.Drawing.Point(162, 155);
            this.textBoxQuant.Name = "textBoxQuant";
            this.textBoxQuant.Size = new System.Drawing.Size(100, 20);
            this.textBoxQuant.TabIndex = 3;
            this.textBoxQuant.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.checkInteger_KeyPress);
            // 
            // textBoxPrice
            // 
            this.textBoxPrice.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.textBoxPrice.Location = new System.Drawing.Point(162, 115);
            this.textBoxPrice.Name = "textBoxPrice";
            this.textBoxPrice.ReadOnly = true;
            this.textBoxPrice.Size = new System.Drawing.Size(100, 20);
            this.textBoxPrice.TabIndex = 2;
            // 
            // buttonOk
            // 
            this.buttonOk.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonOk.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.buttonOk.Location = new System.Drawing.Point(103, 210);
            this.buttonOk.Name = "buttonOk";
            this.buttonOk.Size = new System.Drawing.Size(67, 35);
            this.buttonOk.TabIndex = 4;
            this.buttonOk.Text = "OK";
            this.buttonOk.UseVisualStyleBackColor = true;
            this.buttonOk.Click += new System.EventHandler(this.ButtonOk_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonCancel.Location = new System.Drawing.Point(176, 210);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(67, 35);
            this.buttonCancel.TabIndex = 5;
            this.buttonCancel.Text = "Cancelar";
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // labelCode
            // 
            this.labelCode.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelCode.AutoSize = true;
            this.labelCode.Location = new System.Drawing.Point(87, 37);
            this.labelCode.Name = "labelCode";
            this.labelCode.Size = new System.Drawing.Size(40, 13);
            this.labelCode.TabIndex = 6;
            this.labelCode.Text = "Código";
            // 
            // labelDesc
            // 
            this.labelDesc.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelDesc.AutoSize = true;
            this.labelDesc.Location = new System.Drawing.Point(87, 78);
            this.labelDesc.Name = "labelDesc";
            this.labelDesc.Size = new System.Drawing.Size(63, 13);
            this.labelDesc.TabIndex = 7;
            this.labelDesc.Text = "Descripción";
            // 
            // labelQuant
            // 
            this.labelQuant.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelQuant.AutoSize = true;
            this.labelQuant.Location = new System.Drawing.Point(87, 158);
            this.labelQuant.Name = "labelQuant";
            this.labelQuant.Size = new System.Drawing.Size(49, 13);
            this.labelQuant.TabIndex = 8;
            this.labelQuant.Text = "Cantidad";
            // 
            // labelPrice
            // 
            this.labelPrice.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelPrice.AutoSize = true;
            this.labelPrice.Location = new System.Drawing.Point(87, 118);
            this.labelPrice.Name = "labelPrice";
            this.labelPrice.Size = new System.Drawing.Size(37, 13);
            this.labelPrice.TabIndex = 9;
            this.labelPrice.Text = "Precio";
            // 
            // labelError
            // 
            this.labelError.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.labelError.AutoSize = true;
            this.labelError.Location = new System.Drawing.Point(100, 194);
            this.labelError.Name = "labelError";
            this.labelError.Size = new System.Drawing.Size(16, 13);
            this.labelError.TabIndex = 10;
            this.labelError.Text = "...";
            // 
            // numericUpDownCode
            // 
            this.numericUpDownCode.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.numericUpDownCode.Location = new System.Drawing.Point(162, 35);
            this.numericUpDownCode.Name = "numericUpDownCode";
            this.numericUpDownCode.Size = new System.Drawing.Size(100, 20);
            this.numericUpDownCode.TabIndex = 0;
            this.numericUpDownCode.ValueChanged += new System.EventHandler(this.numericUpDownCode_ValueChanged);
            // 
            // PAlta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(351, 273);
            this.Controls.Add(this.numericUpDownCode);
            this.Controls.Add(this.labelError);
            this.Controls.Add(this.labelPrice);
            this.Controls.Add(this.labelQuant);
            this.Controls.Add(this.labelDesc);
            this.Controls.Add(this.labelCode);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonOk);
            this.Controls.Add(this.textBoxPrice);
            this.Controls.Add(this.textBoxQuant);
            this.Controls.Add(this.textBoxDesc);
            this.Name = "PAlta";
            this.Text = "Alta";
            this.Load += new System.EventHandler(this.PAlta_Load);
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownCode)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        public System.Windows.Forms.NumericUpDown numericUpDownCode;
        public System.Windows.Forms.TextBox textBoxDesc;
        public System.Windows.Forms.TextBox textBoxQuant;
        public System.Windows.Forms.TextBox textBoxPrice;
        private System.Windows.Forms.Button buttonOk;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.Label labelCode;
        private System.Windows.Forms.Label labelDesc;
        private System.Windows.Forms.Label labelQuant;
        private System.Windows.Forms.Label labelPrice;
        private System.Windows.Forms.Label labelError;
        
    }
}