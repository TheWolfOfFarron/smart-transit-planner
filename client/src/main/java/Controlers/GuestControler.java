package Controlers;

import App.Clientt;
import GUI.ClientView;
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

public class GuestControler extends Observerr implements Controlers {
    private String command = "";
    private boolean used = false;

    private Clientt clientt;
    private ClientView clientView;

    public GuestControler(Clientt clientt) {
        this.clientt = clientt;
        clientView = new ClientView();
        initView();
        language();
    }

    public void initView() {


        clientView.getCautaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request tableLine " + clientView.getTextField1().getText();
                used = false;
                try {
                    DefaultTableModel d = (DefaultTableModel) clientt.getObjin().readObject();
                    clientView.getTable1().setModel(d);
                } catch (IOException ee) {
                    throw new RuntimeException(ee);
                } catch (ClassNotFoundException eee) {
                    throw new RuntimeException(eee);
                }
            }
        });
        clientView.getRefreshButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        clientView.getFindRouteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Show Traseu";
                used = false;
            }
        });


    }

    public void refresh() {
        command = "Request tableLines";
        used = false;
        try {
            DefaultTableModel d = (DefaultTableModel) clientt.getObjin().readObject();
            clientView.getTable2().setModel(d);
        } catch (IOException ee) {
            throw new RuntimeException(ee);
        } catch (ClassNotFoundException eee) {
            throw new RuntimeException(eee);
        }

    }


    @Override
    public void language() {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);
        clientView.getFindRouteButton().setText(resourceBundle.getString("findRoute"));
        clientView.getRefreshButton().setText(resourceBundle.getString("refresh"));
        clientView.getCautaButton().setText(resourceBundle.getString("find"));
        clientView.getLine().setText(resourceBundle.getString("linie"));
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
