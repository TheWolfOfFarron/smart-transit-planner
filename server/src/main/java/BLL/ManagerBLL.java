package BLL;

import Database.Utilizator;
import Repo.RepoUtilizator;
import Utils.SendSms;
import Utils.TableBuilder;

import javax.management.Notification;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ManagerBLL {

    public DefaultTableModel refresh(){
        DefaultTableModel dtm =new DefaultTableModel();
        ArrayList<Utilizator> x=new ArrayList<>();
        RepoUtilizator repo=new RepoUtilizator();
        x=repo.findAll();
        dtm.addColumn("index");
        dtm.addColumn("Id");
        dtm.addColumn("nume");
        dtm.addColumn("prenume");
        dtm.addColumn("tip");
        dtm.addColumn("mail");
        dtm.addColumn("username");
        dtm.addColumn("numarTelefon");
        dtm.addColumn("parola");
        dtm.addColumn("cnp");
        int ct=0;
        for(Utilizator i : x){
            ArrayList<Object>show =new ArrayList<>();
            ct++;
            show.add(ct);
            show.add(i.getId());
            show.add(i.getNume());
            show.add(i.getPrenume());
            show.add(i.getTip());
            show.add(i.getMail());
            show.add(i.getUsername());
            show.add(i.getNumarTelefon());
            show.add(i.getParola());
            show.add(i.getCnp());
            dtm.addRow(show.toArray());
        }
        return dtm;
    }

    public DefaultTableModel filtru(String s){

        DefaultTableModel dtm =new DefaultTableModel();
        ArrayList<Utilizator> x=new ArrayList<>();
        RepoUtilizator repo=new RepoUtilizator();
        x=repo.findAll();
        ArrayList<String >p=new ArrayList<>();
        p.add("index");
        p.add("Id");
        p.add("nume");
        p.add("prenume");
        p.add("tip");
        p.add("mail");
        p.add("username");
        p.add("numarTelefon");
        p.add("parola");
        p.add("cnp");
        dtm=new TableBuilder().setFiltru(s).setColums(p).setData(x).build();

        return dtm;
    }

    public void delete(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9){
        RepoUtilizator repoTransport=new RepoUtilizator();
        Utilizator t = new Utilizator();

        t.setId(Integer.parseInt(t1));
        t.setUsername(t2);
        t.setParola(t3);
        t.setMail(t4);
        t.setCnp(t5);
        t.setNumarTelefon(t6);
        t.setNume(t7);
        t.setPrenume(t8);
        t.setTip(t9);
        int x=repoTransport.delete(t);
        SendSms s=SendSms.getInstance();
        s.sendSMS("Data actualizate "+t.toString(),"0");
      sendWhap("ai fost dat afar");
    }

    public void update(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9){
        RepoUtilizator repoTransport=new RepoUtilizator();
        Utilizator t = new Utilizator();

        t.setId(Integer.parseInt(t1));
        t.setUsername(t2);
        t.setParola(t3);
        t.setMail(t4);
        t.setCnp(t5);
        t.setNumarTelefon(t6);
        t.setNume(t7);
        t.setPrenume(t8);
        t.setTip(t9);
        int x=repoTransport.update(t);
        SendSms s=SendSms.getInstance();
        s.sendSMS("Data actualizate "+t.toString(),"0");
        sendWhap("date actualizate "+t.toString());
    }

    public void insert(String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9){
        RepoUtilizator repoTransport=new RepoUtilizator();
        Utilizator t = new Utilizator();


        t.setUsername(t2);
        t.setParola(t3);
        t.setMail(t4);
        t.setCnp(t5);
        t.setNumarTelefon(t6);
        t.setNume(t7);
        t.setPrenume(t8);
        t.setTip(t9);
        int x=repoTransport.update(t);
        SendSms s=SendSms.getInstance();
        s.sendSMS("Data actualizate "+t.toString(),"00000");
        sendWhap("date actualizate "+t.toString());
    }





    private void sendWhap(String msg){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://graph.facebook.com/v13.0/insert id/messages"))
                    .header("Authorization", "Bearer insert token")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \"\", \"type\": \"text\", \"text\": { \"preview_url\": false, \"body\": \""+msg+"\" } }"))
                    .build();
            HttpClient http = HttpClient.newHttpClient();
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
