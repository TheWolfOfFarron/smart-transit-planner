package GUI;

import GUI.Interfaces.IManagerView;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ManagerView extends JFrame implements IManagerView {

    private JTextField numeTextField;

    private JTextField prenumeTextField;

    private JTextField tipTextField;

    private JTextField emailTextField;

    private JTextField parolaTextField;

    private JTextField cnpTextField;

    private JTextField idTextField;
    private JButton insertButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton findButton;

    private JTextField usernameTextField;

    private JTable table1;
    private JPanel contentPane;

    private JTextField nrtelefonTextField;
    private JButton refreshButton;
    private JLabel Nume;
    private JLabel Prenume;
    private JLabel Tip;
    private JLabel username;
    private JLabel parola;
    private JLabel cnp;
    private JLabel idLabel;
    private JLabel nrTelefonLabel;
    private JLabel email;
    private JTextField textField1;
    private JButton filtruButton;


    public ManagerView(){


        setContentPane(contentPane);
        setTitle("Manager");
        setSize(900, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



    }

    @Override
    public void succes() {
        numeTextField.setText("succes");
    }

    @Override
    public void error() {
        numeTextField.setText("eroare");
    }

    @Override
    public void disposee() {
            dispose();
    }

    @Override
    public void refresh(DefaultTableModel x) {
        table1.setModel(x);
    }


    public JTextField getNumeTextField() {
        return numeTextField;
    }

    public void setNumeTextField(JTextField numeTextField) {
        this.numeTextField = numeTextField;
    }

    public JTextField getPrenumeTextField() {
        return prenumeTextField;
    }

    public void setPrenumeTextField(JTextField prenumeTextField) {
        this.prenumeTextField = prenumeTextField;
    }

    public JTextField getTipTextField() {
        return tipTextField;
    }

    public void setTipTextField(JTextField tipTextField) {
        this.tipTextField = tipTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JTextField getParolaTextField() {
        return parolaTextField;
    }

    public void setParolaTextField(JTextField parolaTextField) {
        this.parolaTextField = parolaTextField;
    }

    public JTextField getCnpTextField() {
        return cnpTextField;
    }

    public void setCnpTextField(JTextField cnpTextField) {
        this.cnpTextField = cnpTextField;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
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

    public JButton getFindButton() {
        return findButton;
    }

    public void setFindButton(JButton findButton) {
        this.findButton = findButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getFiltruButton() {
        return filtruButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public void setFiltruButton(JButton filtruButton) {
        this.filtruButton = filtruButton;
    }

    public JTextField getNrtelefonTextField() {
        return nrtelefonTextField;
    }

    public void setNrtelefonTextField(JTextField nrtelefonTextField) {
        this.nrtelefonTextField = nrtelefonTextField;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(JButton refreshButton) {
        this.refreshButton = refreshButton;
    }

    public JLabel getNume() {
        return Nume;
    }

    public JLabel getPrenume() {
        return Prenume;
    }

    public JLabel getTip() {
        return Tip;
    }

    public JLabel getUsername() {
        return username;
    }

    public JLabel getParola() {
        return parola;
    }

    public JLabel getCnp() {
        return cnp;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JLabel getNrTelefonLabel() {
        return nrTelefonLabel;
    }

    public JLabel getEmail() {
        return email;
    }
}
