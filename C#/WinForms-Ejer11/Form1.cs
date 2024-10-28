using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinForms_Ejer11
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        int countYes = 0;
        int countNo = 0;
        int countOther = 0;
        int countTotalVotes = 0;
        int increment = 0;

        private void button1_Click(object sender, EventArgs e)
        {
            if (radioButtonYes.Checked || radioButtonNo.Checked || radioButtonOther.Checked)
            { 
                if (radioButtonYes.Checked)
                {
                    countYes++;
                    labelVotesYes.Text = countYes + " votos Sí";
                }
                else if (radioButtonNo.Checked)
                {
                    countNo++;
                    labelVotesNo.Text = countNo + " votos No";
                }
                else
                {
                    countOther++;
                    labelVotesOther.Text = countOther + " votos NC/NS";
                }
                countTotalVotes++;
                labelVotesTotal.Text = countTotalVotes + " votos total";

                int maxCount = Math.Max(Math.Max(countYes, countNo), countOther); ;
                progressBarYes.Maximum = maxCount;
                progressBarNo.Maximum = maxCount;
                progressBarOther.Maximum = maxCount;

                if (radioButtonYes.Checked)         { progressBarYes.Increment(1); }
                else if (radioButtonNo.Checked)     { progressBarNo.Increment(1); }
                else if (radioButtonOther.Checked)  { progressBarOther.Increment(1); }
            }
        }
    }
}
