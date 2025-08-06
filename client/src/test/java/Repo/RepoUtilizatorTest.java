package Repo;

import Database.Utilizator;
import junit.framework.TestCase;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class RepoUtilizatorTest extends TestCase {
    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
    public void testDelete() {
        Utilizator utilizator=new Utilizator();
        utilizator.setId(9);
        utilizator.setCnp("dasada");
        utilizator.setMail("dasdada@F");
        utilizator.setParola("Dsadas");
        RepoUtilizator repoUtilizator=new RepoUtilizator();

        assertEquals(0,repoUtilizator.delete(utilizator));
    }




    public void testFind() {
        Utilizator utilizator=new Utilizator();
        utilizator.setId(9);
        utilizator.setCnp("dasada");
        utilizator.setMail("a@F");
        utilizator.setParola("Dsadas");
        RepoUtilizator repoUtilizator=new RepoUtilizator();

        assertEquals(utilizator,repoUtilizator.find(9));
    }

    public void testUpdate() {
        Utilizator utilizator=new Utilizator();
        utilizator.setId(9);
        utilizator.setCnp("dasada");
        utilizator.setMail("a@F");
        utilizator.setParola("Dsadas");
        RepoUtilizator repoUtilizator=new RepoUtilizator();

        assertEquals(0,repoUtilizator.update(utilizator));
    }
    public void testInsert() {
        Utilizator utilizator=new Utilizator();
        utilizator.setCnp("dasada");
        utilizator.setMail("dasdada@F");
        utilizator.setParola("Plutoniu");
        utilizator.setUsername("Plutoniu");
        utilizator.setTip("manager");
        RepoUtilizator repoUtilizator=new RepoUtilizator();

        assertEquals(0,repoUtilizator.insert(utilizator));

    }
}