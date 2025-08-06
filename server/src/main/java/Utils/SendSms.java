package Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendSms {
    private static SendSms instance=new SendSms();
    private SendSms(){};

    public static SendSms getInstance(){
        return  instance;
    }


    public void sendSMS(String msg,String phoone){
        // TODO Auto-generated method stub
        try {


            String message = msg;
            String phone = phoone;
            String username = "username ";
            String password = "parola";
            String address = "addres";
            String port = "8090";

            URL url = new URL(
                    address + ":" + port + "/SendSMS?username=" + username + "&password=" + password +
                            "&phone=" + phone + "&message=" + URLEncoder.encode(message, "UTF-8"));

            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
