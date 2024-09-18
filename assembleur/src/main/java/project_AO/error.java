
package project_AO;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class error extends JFrame {

    public error() {
        //setSize(400, 300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600, 300);
        setVisible(true);
        
        displayErrorMessage();
    }

    public void displayErrorMessage() {
        String errorMessage = "Syntax error";
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        dispose();    // presse ok se ferme 
    }

}