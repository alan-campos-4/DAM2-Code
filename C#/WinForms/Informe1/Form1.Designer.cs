namespace Informe1
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
            this.components = new System.ComponentModel.Container();
            Microsoft.Reporting.WinForms.ReportDataSource reportDataSource4 = new Microsoft.Reporting.WinForms.ReportDataSource();
            this.cochesBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.coches = new Informe1.Coches();
            this.cochesTableAdapter = new Informe1.CochesTableAdapters.cochesTableAdapter();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.verPorMarcaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            ((System.ComponentModel.ISupportInitialize)(this.cochesBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.coches)).BeginInit();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // cochesBindingSource
            // 
            this.cochesBindingSource.DataMember = "coches";
            this.cochesBindingSource.DataSource = this.coches;
            // 
            // coches
            // 
            this.coches.DataSetName = "Coches";
            this.coches.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // cochesTableAdapter
            // 
            this.cochesTableAdapter.ClearBeforeFill = true;
            // 
            // reportViewer1
            // 
            reportDataSource4.Name = "DataSetCoches";
            reportDataSource4.Value = this.cochesBindingSource;
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource4);
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "Informe1.ListadoCoches.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(28, 87);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(730, 350);
            this.reportViewer1.TabIndex = 0;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.verPorMarcaToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(784, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // verPorMarcaToolStripMenuItem
            // 
            this.verPorMarcaToolStripMenuItem.Name = "verPorMarcaToolStripMenuItem";
            this.verPorMarcaToolStripMenuItem.Size = new System.Drawing.Size(92, 20);
            this.verPorMarcaToolStripMenuItem.Text = "Ver por marca";
            this.verPorMarcaToolStripMenuItem.Click += new System.EventHandler(this.VerPorMarcaToolStripMenuItem_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 461);
            this.Controls.Add(this.reportViewer1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.cochesBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.coches)).EndInit();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private Coches coches;
        private System.Windows.Forms.BindingSource cochesBindingSource;
        private CochesTableAdapters.cochesTableAdapter cochesTableAdapter;
        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem verPorMarcaToolStripMenuItem;
    }
}

