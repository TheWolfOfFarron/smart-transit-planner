package Controlers;

import App.Clientt;
import GUI.Interfaces.Controlers;
import GUI.StartUp;
import Utils.Language;
import Utils.Observerr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class StartUpControler extends Observerr implements Controlers {
    StartUp startUp;
    Clientt clientt;
    private String command = "";
    private boolean used = true;

    public StartUpControler(Clientt clientt) {
        this.clientt = clientt;
        startUp = new StartUp();
        initView();
        language();
    }

    @Override
    public void language() {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);
        startUp.getLogInButton().setText(resourceBundle.getString("login"));
        startUp.getGuestButton().setText(resourceBundle.getString("guest"));
    }

    private void initView() {
        StartUpControler d = this;
        startUp.getGuestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startUp.dispose();
                command = "Change Guest";
                used = false;
                Language.delete(d);
            }
        });

        startUp.getLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Change Login";
                used = false;

                Language.delete(d);
                startUp.dispose();
            }
        });
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
