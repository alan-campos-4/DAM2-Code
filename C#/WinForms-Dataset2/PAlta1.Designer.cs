using System.Data;
using System.Reflection.Emit;
using System.Runtime.InteropServices;
using System.Windows.Forms;

namespace WinForms_Dataset2
{
    partial class PAlta1
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
        private void InitializeComponent(DataTable DT)
        {
            int size = DT.Columns.Count;
            this.labels = new System.Windows.Forms.Label[size];
            this.textBoxes = new System.Windows.Forms.TextBox[size];
            for (int i = 0; i < labels.Length; i++)
                {labels[i] = new System.Windows.Forms.Label();}
            for (int i = 0; i < textBoxes.Length; i++)
                {textBoxes[i] = new System.Windows.Forms.TextBox();}
            this.buttonOk = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.SuspendLayout();

            // 
            // Labels
            //
            int TabIndex = 0;
            int modheight = 26;   
            string[] names = new string[size];
            for (int i = 0; i < size; i++) 
                {names[i] = DT.Columns[i].ColumnName;}

            int L_XPos = 110;
            int L_YPos = 65;
            for (int i = 0; i < size; i++)
            {
                labels[i].Anchor = System.Windows.Forms.AnchorStyles.None;
                labels[i].AutoSize = true;
                labels[i].Location = new System.Drawing.Point(L_XPos, L_YPos);
                labels[i].Name = "label"+(i+1);
                labels[i].Size = new System.Drawing.Size(50, 13);
                labels[i].TabIndex = TabIndex;
                labels[i].Text = names[i];
                L_YPos += modheight;
                TabIndex++;
            }
            // 
            // TextBoxes
            //
            int TB_XPos = 183;
            int TB_YPos = 62;
            for (int i = 0; i < size; i++)
            {
                textBoxes[i].Anchor = System.Windows.Forms.AnchorStyles.None;
                textBoxes[i].Location = new System.Drawing.Point(TB_XPos, TB_YPos);
                textBoxes[i].Name = "textBox"+(i+1);
                textBoxes[i].Size = new System.Drawing.Size(100, 20);
                textBoxes[i].TabIndex = TabIndex;
                TB_YPos += modheight;
                TabIndex++;
            }
            //
            // buttonOk
            // 
            this.buttonOk.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonOk.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.buttonOk.Location = new System.Drawing.Point(87, 210);
            this.buttonOk.Name = "buttonOk";
            this.buttonOk.Size = new System.Drawing.Size(104, 39);
            this.buttonOk.TabIndex = TabIndex;
            this.buttonOk.Text = "OK";
            this.buttonOk.UseVisualStyleBackColor = true;
            this.buttonOk.Click += new System.EventHandler(this.buttonOk_Click);
            TabIndex++;
            // 
            // buttonCancel
            // 
            this.buttonCancel.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonCancel.Location = new System.Drawing.Point(197, 210);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(104, 39);
            this.buttonCancel.TabIndex = TabIndex;
            this.buttonCancel.Text = "Cancelar";
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);

            // 
            // PAlta1
            // 
            this.ClientSize = new System.Drawing.Size(384, 311);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonOk);
            foreach (TextBox textBox in textBoxes)
            {
                this.Controls.Add(textBox);
            }
            foreach (System.Windows.Forms.Label label in labels)
            {
                this.Controls.Add(label);
            }
            this.Name = "PAlta1";
            this.Text = "PAlta1";
            this.ResumeLayout(false);
            this.PerformLayout();
        }

        #endregion

        public System.Windows.Forms.TextBox[] textBoxes;
        private System.Windows.Forms.Label[] labels;
        private System.Windows.Forms.Button buttonOk;
        private System.Windows.Forms.Button buttonCancel;

        
    }
}