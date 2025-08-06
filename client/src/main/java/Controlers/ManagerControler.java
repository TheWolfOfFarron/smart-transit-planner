package Controlers;

import App.Clientt;
import GUI.Interfaces.Controlers;
import GUI.ManagerView;
import Utils.Language;
import Utils.Observerr;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ManagerControler extends Observerr implements Controlers {
    private String command = "rht";
    private boolean used = false;
    private final Clientt clientt;
    private final ManagerView managerView;

    public ManagerControler(Clientt clientt) {
        this.clientt = clientt;
        managerView = new ManagerView();

        init();
        language();
    }

    @Override
    public void language() {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);
        managerView.getFindButton().setText(resourceBundle.getString("find"));
        managerView.getRefreshButton().setText(resourceBundle.getString("refresh"));
        managerView.getUpdateButton().setText(resourceBundle.getString("update"));
        managerView.getInsertButton().setText(resourceBundle.getString("insert"));
        managerView.getDeleteButton().setText(resourceBundle.getString("delete"));
        managerView.getCnp().setText(resourceBundle.getString("cnp"));
        managerView.getIdLabel().setText(resourceBundle.getString("id"));
        managerView.getNrTelefonLabel().setText(resourceBundle.getString("nrtel"));
        managerView.getTip().setText("tip");
        managerView.getUsername().setText("username");
        managerView.getParola().setText("parola");
        managerView.getEmail().setText("emal");
        managerView.getNume().setText("nume");
        managerView.getPrenume().setText("prenume");
    }

    private void refresh() {
        command = "Request tableManager";
        used = false;
        try {
            DefaultTableModel d = (DefaultTableModel) clientt.getObjin().readObject();
            managerView.getTable1().setModel(d);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() {
        managerView.getRefreshButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        managerView.getFindButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Show Guest";
                used = false;
            }
        });
        managerView.getInsertButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request insertManager " + managerView.getUsernameTextField().getText() + " " + managerView.getParolaTextField().getText() + " " + managerView.getEmail()
                        + " " + managerView.getCnpTextField().getText() + " " + managerView.getNrtelefonTextField().getText() + " " + managerView.getNumeTextField().getText() + " " + managerView.getPrenumeTextField().getText() + " " + managerView.getTipTextField().getText();
                used = false;
            }
        });
        managerView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request deleteManager " + managerView.getIdTextField().getText() + " " + managerView.getUsernameTextField().getText() + " " + managerView.getParolaTextField().getText() + " " + managerView.getEmail()
                        + " " + managerView.getCnpTextField().getText() + " " + managerView.getNrtelefonTextField().getText() + " " + managerView.getNumeTextField().getText() + " " + managerView.getPrenumeTextField().getText() + " " + managerView.getTipTextField().getText();
                used = false;
            }
        });

        managerView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request updateManager " + managerView.getIdTextField().getText() + " " + managerView.getUsernameTextField().getText() + " " + managerView.getParolaTextField().getText() + " " + managerView.getEmail()
                        + " " + managerView.getCnpTextField().getText() + " " + managerView.getNrtelefonTextField().getText() + " " + managerView.getNumeTextField().getText() + " " + managerView.getPrenumeTextField().getText() + " " + managerView.getTipTextField().getText();
                used = false;
            }
        });
        managerView.getFiltruButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request filter " + managerView.getTextField1().getText();
                used = false;
                try {
                    DefaultTableModel d = (DefaultTableModel) clientt.getObjin().readObject();
                    managerView.getTable1().setModel(d);
                } catch (IOException | ClassNotFoundException eee) {
                    throw new RuntimeException(eee);
                }
            }
        });

    }


    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public boolean isUsed() {
        return used;
    }

    @Override
    public void setUsed(boolean used) {
        this.used = used;
    }
}
