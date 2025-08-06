package Repo;

import Database.Transport;
import junit.framework.TestCase;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class RepoTransportTest extends TestCase {
    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

    public void testInsert() {
        RepoTransport repoTransport=new RepoTransport();
        Transport transport=new Transport();
        transport.setNrLinie("23b");
        transport.setNrStatie(2);
        transport.setStatie("Lalele");
        assertEquals(0,repoTransport.insert(transport));
    }


    public void testFind() {
        RepoTransport repoTransport=new RepoTransport();
        Transport transport=new Transport();
        transport.setId(1);
        transport.setNrLinie("24b");
        transport.setNrStatie(1);
        transport.setStatie("Lalelee");
        assertEquals(transport,repoTransport.find(1));

    }

    public void testFindall() {

        RepoTransport repoTransport=new RepoTransport();
        Transport transport=new Transport();
        transport.setId(1);
        transport.setNrLinie("24b");
        transport.setNrStatie(1);
        transport.setStatie("Lalelee");
        ArrayList<Transport> t= new ArrayList<>();
        t.add(transport);
        assertEquals(t, repoTransport.findAll());
    }

    public void testUpdate() {

        RepoTransport repoTransport=new RepoTransport();
        Transport transport=new Transport();
        transport.setId(1);
        transport.setNrLinie("24b");
        transport.setNrStatie(1);
        transport.setStatie("Lalelee");
        assertEquals(0,repoTransport.update(transport));

    }
    public void testDelete() {
        RepoTransport repoTransport=new RepoTransport();
        Transport transport=new Transport();
        transport.setId(1);
        transport.setNrLinie("24b");
        transport.setNrStatie(1);
        transport.setStatie("Lalele");
        assertEquals(0,repoTransport.delete(transport));
    }

}