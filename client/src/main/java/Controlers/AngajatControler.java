package Controlers;

import App.Clientt;
import GUI.AngajatView;
import GUI.Interfaces.Controlers;
import Utils.Language;
import Utils.Observerr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class AngajatControler extends Observerr implements Controlers {

    AngajatView angajatView;
    private String command = "sdf";
    private boolean used = false;

    public AngajatControler(Clientt clientt) {
        angajatView = new AngajatView();
        init();
        language();
    }

    @Override
    public void language() {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);

        angajatView.getId().setText(resourceBundle.getString("id"));
        angajatView.getNrLinie().setText(resourceBundle.getString("nrLinie"));
        angajatView.getNrStatie().setText(resourceBundle.getString("nrStatie"));
        angajatView.getStatie().setText(resourceBundle.getString("statie"));
        angajatView.getUpdateButton().setText(resourceBundle.getString("update"));
        angajatView.getDeleteButton().setText(resourceBundle.getString("delete"));
        angajatView.getInsertButton().setText(resourceBundle.getString("insert"));
        angajatView.getSaveButton().setText(resourceBundle.getString("save"));
        angajatView.getChartButton().setText(resourceBundle.getString("chart"));
        angajatView.getFindButton().setText(resourceBundle.getString("find"));
    }


    private void init() {
        angajatView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request updateTransport " + angajatView.getTextField1().getText() + " " + angajatView.getTextField2().getText() + " " + angajatView.getTextField3().getText() + " " + angajatView.getTextField4().getText();
                used = false;
            }
        });

        angajatView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request deleteTransport" + angajatView.getTextField1().getText() + " " + angajatView.getTextField2().getText() + " " + angajatView.getTextField3().getText() + " " + angajatView.getTextField4().getText();
                used = false;
            }
        });


        angajatView.getInsertButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request insertTransport" + angajatView.getTextField1().getText() + " " + angajatView.getTextField2().getText() + " " + angajatView.getTextField3().getText() + " " + angajatView.getTextField4().getText();
                used = false;
            }
        });


        angajatView.getFindButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Show Guest";
                used = false;
            }
        });

        angajatView.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request Save";
                used = false;
            }
        });

        angajatView.getChartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request Chart";
                used = false;
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
