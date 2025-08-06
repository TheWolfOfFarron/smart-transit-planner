package GUI;

import GUI.Interfaces.ITransportView;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientView extends JFrame implements ITransportView {
    private JPanel contentPane;
    private JButton refreshButton;
    private JTable table1;
    private JTextField textField1;
    private JTable table2;
    private JButton cautaButton;
    private JButton findRouteButton;
    private JLabel Line;


    public ClientView(){

        setContentPane(contentPane);
        setTitle("Client");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



    }

    public JLabel getLine() {
        return Line;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(JButton refreshButton) {
        this.refreshButton = refreshButton;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(DefaultTableModel table1) {
        this.table1.setModel (table1);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTable getTable2() {
        return table2;
    }

    public void setTable2(DefaultTableModel table2) {
        this.table2.setModel(table2);
    }

    public JButton getCautaButton() {
        return cautaButton;
    }

    public void setCautaButton(JButton cautaButton) {
        this.cautaButton = cautaButton;
    }

    public JButton getFindRouteButton() {
        return findRouteButton;
    }

    public void setFindRouteButton(JButton findRouteButton) {
        this.findRouteButton = findRouteButton;
    }

    @Override
    public void oncreat(DefaultTableModel x) {
        table1.setModel(x);
    }

    @Override
    public void lini(DefaultTableModel x){
        table2.setModel(x);
    }

    @Override
    public void disposee() {
        dispose();
    }
}
