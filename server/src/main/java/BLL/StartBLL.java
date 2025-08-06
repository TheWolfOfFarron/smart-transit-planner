package BLL;

import Database.Utilizator;
import Repo.REPO;
import Repo.RepoUtilizator;

public class StartBLL {

    public String login(String name, String pass){

        REPO<Utilizator> persistence = new RepoUtilizator();
        String username = name;
        String parola = pass;

        Utilizator utilizator= persistence.findS(username,parola);
        System.out.println(username+"   "+ parola);
        if(utilizator==null)
            return "error";
        else
            return "succes "+utilizator.getTip();


    }

}
