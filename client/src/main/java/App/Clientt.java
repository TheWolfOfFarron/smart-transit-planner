package App;

import GUI.Interfaces.Controlers;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import Controlers.StartUpControler;
import Controlers.LoginControler;
import Controlers.GuestControler;
import Utils.Language;
import Controlers.*;

public class Clientt implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String line;
    private ObjectOutputStream objout;
    private ObjectInputStream objin;

    public Clientt() throws IOException {

        try {
            socket = new Socket("localhost", 1235);
            // writing to server
            out = new PrintWriter(
                    socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            // reading from server
            objout = new ObjectOutputStream(socket.getOutputStream());
            objin = new ObjectInputStream(socket.getInputStream());
            line = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        ArrayList<Controlers> controlers = new ArrayList<>();
        StartUpControler c = new StartUpControler(this);
        controlers.add(c);
        Controlers actual = c;
        Language.add(c);
        new MVCLanguage();

        while (!"exit".equalsIgnoreCase(line)) {
            String line = null;
            if (controlers.isEmpty())
                line = "exit";
            else {
                for (Controlers co : controlers) {
                    if (co.getCommand() != null && co.isUsed() == false) {
                        line = co.getCommand();
                        actual = co;
                        break;
                    }
                }
            }
            if (line != null) {
                String[] instructions = line.split(" ");
                if (instructions[0].equals("Change")) {
                    switch (instructions[1]) {
                        case "Login":
                            controlers.add(new LoginControler(this));
                            controlers.remove(actual);
                            break;
                        case "Guest":
                            controlers.add(new GuestControler(this));
                            controlers.remove(actual);
                            break;
                        case "angajat":
                            AngajatControler s = new AngajatControler(this);
                            controlers.add(s);
                            Language.add(s);
                            controlers.remove(actual);
                            break;
                        case "manager":
                            ManagerControler m = new ManagerControler(this);
                            controlers.add(m);
                            Language.add(m);
                            controlers.remove(actual);
                            break;
                    }
                }
                if (instructions[0].equals("Show")) {
                    switch (instructions[1]) {
                        case "Guest":
                            controlers.add(new GuestControler(this));
                            break;
                        case "Traseu":
                            controlers.add(new TraseuControler(this));
                            break;

                    }
                }
                if (instructions[0].equals("Request")) {
                    if (!actual.isUsed()) {
                        actual.setUsed(true);
                        out.println(line);
                        out.flush();
                    }
                }
                actual.setUsed(true);
            }
        }
    }

    public ObjectOutputStream getObjout() {
        return objout;
    }

    public void setObjout(ObjectOutputStream objout) {
        this.objout = objout;
    }

    public ObjectInputStream getObjin() {
        return objin;
    }

    public void setObjin(ObjectInputStream objin) {
        this.objin = objin;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }
}
