/**
** Title:                EtClientGUI.java
**/
import javax.swing.*;

public class EtClientGUI {

    public static void main(String[] args) {

        int answer;
        String msg;

        do {

            // Determine whether the user wants to keep going or exit
            // via the use of a JOptionPane. We'll give the user two (2) options
            // and only exit the enclosing forever loop if they decide to "Stop".
            Object[] opts = {
                "Continue Entering Expenses",
                "Stop"
            };

            answer = JOptionPane.showOptionDialog(null,
                    "Continue entering expenses or stop?",
                    "Expense Tracker GUI Client",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opts,
                    opts[0]);

            // If the user selected the "Stop" option, and integer value of 
            // "1" will be returned. In that case, break out of the enclosing 
            // "forever" loop. Otherwise, go through again.
            if (answer == 1) {

                break;
            }

        } while (true);
    }
}
