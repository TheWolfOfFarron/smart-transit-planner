package GUI;


import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Traseu extends JFrame{

    private JTextField textField1;

    private JTextField textField2;

    private JTable table1;
    private JButton findButton;
    private JPanel contentPane;



    public Traseu(){

        setContentPane(contentPane);
        setTitle("Traseu");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);




    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(DefaultTableModel table1) {
        this.table1.setModel(table1);
    }

    public JButton getFindButton() {
        return findButton;
    }

    public void setFindButton(JButton findButton) {
        this.findButton = findButton;
    }
}
