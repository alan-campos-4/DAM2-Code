using System.Windows.Forms;

namespace WF_PracticaCRUD 
{ 
    public partial class Form1 : Form
    {
        public string connectionString;

        public Form1()
        {
            connectionString = "Server=localhost;Database=concesionario;User ID=root;Password=QKEBFF;SslMode=none";
        }

        public DialogResult ShowWarning(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);
        }

        public DialogResult ShowYesNo(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.YesNo, MessageBoxIcon.Question);
        }

        public DialogResult ShowConfirm(string title, string message)
        {
            return MessageBox.Show(message, title, MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        public DialogResult ShowError(string message)
        {
            return MessageBox.Show(message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }


        public void CheckLetters_KeyPress(object sender, KeyPressEventArgs e)
        {
            e.Handled = !(char.IsLetter(e.KeyChar) || e.KeyChar == (char)Keys.Back);
        }

        public void CheckInteger_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.') && (e.KeyChar != ','))
            {
                e.Handled = true;
            }
        }

        public void CheckDecimal_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Numbers and one dot allowed
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.'))
            {
                e.Handled = true;
            }
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
        }

        public void CheckModel_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Letters, numbers and dashes allowed
            if ((e.KeyChar == '-') && ((sender as TextBox).Text.IndexOf('-') > -1))
            {
                e.Handled = true;
            }
        }
    }
}
