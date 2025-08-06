package GUI;


import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {


    private JTextField userField;

    private JButton logInButton;
    private JPanel contentPane;


    private JTextField passField;




    public LogIn(){


        setContentPane(contentPane);
        setTitle("Login");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);





    }

    public JTextField getUserField() {
        return userField;
    }

    public void setUserField(JTextField userField) {
        this.userField = userField;
    }

    public JTextField getPassField() {
        return passField;
    }

    public void setPassField(JTextField passField) {
        this.passField = passField;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public void setLogInButton(JButton logInButton) {
        this.logInButton = logInButton;
    }
}
