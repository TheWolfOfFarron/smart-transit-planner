package GUI;

import GUI.Interfaces.IStartUp;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUp extends JFrame implements IStartUp {
    private JButton guestButton;
    private JButton logInButton;
    private JPanel contentPane;


    public StartUp() {

        setContentPane(contentPane);
        setTitle("StartPage");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }


    public JButton getGuestButton() {
        return guestButton;
    }

    public void setGuestButton(JButton guestButton) {
        this.guestButton = guestButton;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public void setLogInButton(JButton logInButton) {
        this.logInButton = logInButton;
    }

    @Override
    public void disposeJ() {
        dispose();
    }
}
