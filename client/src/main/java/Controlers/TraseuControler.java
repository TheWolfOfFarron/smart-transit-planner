package Controlers;

import App.Clientt;
import GUI.Interfaces.Controlers;
import GUI.Traseu;
import Utils.Language;
import Utils.Observerr;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class TraseuControler extends Observerr implements Controlers {
    private String command = "";
    private boolean used = false;

    private Clientt clientt;
    private Traseu traseu;

    public TraseuControler(Clientt clientt) {
        this.clientt = clientt;
        traseu = new Traseu();
        init();
        language();
    }

    private void init() {
        traseu.getFindButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request traseu " + traseu.getTextField1().getText() + " " + traseu.getTextField2().getText();
                used = false;
                try {
                    DefaultTableModel d = (DefaultTableModel) clientt.getObjin().readObject();
                    traseu.getTable1().setModel(d);
                } catch (IOException ee) {
                    throw new RuntimeException(ee);
                } catch (ClassNotFoundException eee) {
                    throw new RuntimeException(eee);
                }
            }
        });

    }

    @Override
    public void language() {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);
        traseu.getFindButton().setText(resourceBundle.getString("find"));
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

    public Clientt getClientt() {
        return clientt;
    }

    public void setClientt(Clientt clientt) {
        this.clientt = clientt;
    }

    public Traseu getTraseu() {
        return traseu;
    }

    public void setTraseu(Traseu traseu) {
        this.traseu = traseu;
    }
}
