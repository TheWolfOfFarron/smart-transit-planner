package Controlers;

import App.Clientt;
import GUI.Interfaces.Controlers;
import GUI.LogIn;
import Utils.Language;
import Utils.Observerr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginControler extends Observerr implements Controlers {
    private String command = "";
    private boolean used = false;
    private LogIn Login;
    private Clientt clientt;

    public LoginControler(Clientt clientt) {
        Login = new LogIn();
        this.clientt = clientt;
        init();
        language();
    }

    private void init() {
        LoginControler d = this;
        Login.getLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = "Request Login " + Login.getUserField().getText() + " " + Login.getPassField().getText();
                used = false;
                try {
                    String input = clientt.getIn().readLine();
                    String[] split = input.split(" ");
                    if (split.length == 2) {
                        if (split[1].equals("angajat")) {
                            command = "Change angajat";
                            used = false;
                            Login.dispose();
                            Language.delete(d);
                        }
                        if (split[1].equals("manager")) {
                            command = "Change manager";
                            used = false;
                            Login.dispose();
                            Language.delete(d);
                        }
                    } else
                        Login.getUserField().setText("error");
                } catch (Exception ee) {
                    ee.printStackTrace();
                }

            }
        });
    }

    @Override
    public void language() {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);
        Login.getLogInButton().setText(resourceBundle.getString("login"));
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
