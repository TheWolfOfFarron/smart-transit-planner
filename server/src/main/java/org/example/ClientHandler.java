package org.example;

import BLL.AngajatBLL;
import BLL.ClientBLL;
import BLL.ManagerBLL;
import BLL.StartBLL;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    String line;
    PrintWriter out = null;
    BufferedReader in = null;
    private ObjectOutputStream objout;
    private ObjectInputStream objin;

    private AngajatBLL angajatBLL;
    private ClientBLL clientBLL;
    private ManagerBLL managerBLL;
    private StartBLL startBLL;
   public ClientHandler(Socket socket){
       this.clientSocket = socket;

       angajatBLL=new AngajatBLL();
       clientBLL=new ClientBLL();
       managerBLL=new ManagerBLL();
       startBLL=new StartBLL();

       try {

           // get the outputstream of client
           out = new PrintWriter(
                   clientSocket.getOutputStream(), true);

           // get the inputstream of client
           in = new BufferedReader(
                   new InputStreamReader(
                           clientSocket.getInputStream()));

           objout = new ObjectOutputStream(socket.getOutputStream());

           objin = new ObjectInputStream(socket.getInputStream());
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }

    @Override
    public void run() {
            while (true){
                try {
                    if (!((line = in.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(line);
                String[] insts=line.split(" ");

                if(insts[1].equals("updateTransport")){
                    angajatBLL.update(insts[2],insts[3],insts[4],insts[5]);

                }
                if(insts[1].equals("deleteTransport")){
                    angajatBLL.delete(insts[2],insts[3],insts[4],insts[5]);

                }
                if(insts[1].equals("insertTransport")){
                    angajatBLL.insert(insts[2],insts[3],insts[4]);

                }
                if(insts[1].equals("Save")){
                    angajatBLL.save();
                }
                if(insts[1].equals("tableLine")){
                   DefaultTableModel d= clientBLL.findLinie(insts[2]);
                    try {
                        objout.writeObject(d);
                        objout.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                if(insts[1].equals("tableLines")){
                    DefaultTableModel d= clientBLL.refresh();
                    try {
                        objout.writeObject(d);
                        objout.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(insts[1].equals("traseu")){
                    DefaultTableModel d=  clientBLL.line(insts[2],insts[3]);
                    try {
                        objout.writeObject(d);
                        objout.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(insts[1].equals("Login")){
                    String ret=startBLL.login(insts[2],insts[3]);
                    out.println(ret);
                    out.flush();
                }
                if(insts[1].equals("insertManager")){
                    managerBLL.insert(insts[2],insts[3],insts[4],insts[5],insts[6],insts[7],insts[8],insts[9]);

                }
                if(insts[1].equals("deleteManager")){
                    managerBLL.delete(insts[2],insts[3],insts[4],insts[5],insts[6],insts[7],insts[8],insts[9],insts[10]);

                }
                if(insts[1].equals("updateManager")){
                    managerBLL.update(insts[2],insts[3],insts[4],insts[5],insts[6],insts[7],insts[8],insts[9],insts[10]);
                }
                if(insts[1].equals("filter")){
                  DefaultTableModel d=  managerBLL.filtru(insts[2]);
                    try {
                        objout.writeObject(d);
                        objout.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(insts[1].equals("tableManager")){
                    DefaultTableModel d=  managerBLL.refresh();
                    try {
                        objout.writeObject(d);
                        objout.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
    }
}
