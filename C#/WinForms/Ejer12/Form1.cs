using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Ejer12
{
    public partial class Form1 : Form
    {
        int countWords = 0;
        int countChars = 0;
        int countSpaces = 0;

        public Form1()
        {
            InitializeComponent();
            updateStats();
        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            if (checkBoxRepeat.Checked || !listWords.Items.Contains(wordInput.Text))
            {
                foreach (char c in wordInput.Text.ToCharArray())
                {
                    if (c.Equals(' '))  { countSpaces++; }
                    else                { countChars++; }
                }
                countWords++;
                listWords.Items.Add(wordInput.Text);
                updateStats();
            }
        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
            listWords.Items.Clear();
            countWords = 0;
            countChars = 0;
            countSpaces = 0;
            updateStats();
        }
        
        public void updateStats()
        {
            if (listStats.Items.Count > 0)
            {
                listStats.Items.Clear();
            }
            listStats.Items.Add("Palabras  \t\t" + countWords);
            listStats.Items.Add("Carácteres\t\t" + countChars);
            listStats.Items.Add("Espacios en blanco \t" + countSpaces);
        }
    }
}
