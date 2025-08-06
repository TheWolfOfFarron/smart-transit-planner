package GUI;

import App.Clientt;
import GUI.Interfaces.IAngajatView;
import com.sun.net.httpserver.Request;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AngajatView extends JFrame implements IAngajatView {
    private JButton updateButton;
    private JButton deleteButton;
    private JButton insertButton;
    private JButton findButton;

    private JTextField textField1;

    private JTextField textField2;

    private JTextField textField3;

    private JTextField textField4;
    private JPanel contentPane;
    private JButton saveButton;
    private JButton chartButton;
    private JLabel id;
    private JLabel nrLinie;
    private JLabel statie;
    private JLabel nrStatie;


    Clientt clientt;



    public AngajatView(){



        setContentPane(contentPane);
        setTitle("Angajat");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }




    @Override
    public void succes() {
        textField1.setText("succes");
    }

    @Override
    public void error() {
    textField1.setText("error");
    }

    @Override
    public void disposee() {
        dispose();
    }

    public JButton getChartButton() {
        return chartButton;
    }

    public void setChartButton(JButton chartButton) {
        this.chartButton = chartButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }

    public JButton getFindButton() {
        return findButton;
    }

    public void setFindButton(JButton findButton) {
        this.findButton = findButton;
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

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }


    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getNrLinie() {
        return nrLinie;
    }

    public void setNrLinie(JLabel nrLinie) {
        this.nrLinie = nrLinie;
    }

    public JLabel getStatie() {
        return statie;
    }

    public void setStatie(JLabel statie) {
        this.statie = statie;
    }

    public JLabel getNrStatie() {
        return nrStatie;
    }

    public void setNrStatie(JLabel nrStatie) {
        this.nrStatie = nrStatie;
    }
}
