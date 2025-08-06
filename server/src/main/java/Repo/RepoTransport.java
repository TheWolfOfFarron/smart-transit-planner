package Repo;

import Database.Transport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

public class RepoTransport implements REPO{

    private SessionFactory factory;
    private Session session;

    private Transaction transaction;



    public RepoTransport() {
        Proxi p =new PoxiObj();
        var meta=p.generate();
        factory=meta.getSessionFactoryBuilder().build();
        session=factory.openSession();
    }

    @Override
    public int insert(Object e) {


        try {transaction = session.beginTransaction();
            session.persist("Transport",(Transport) e);
            session.flush();
            session.clear();
            transaction.commit();
            session.close();

            return 0;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return 1;
        }

    }

    @Override
    public int delete(Object e) {
        try {
            session=factory.openSession();
            transaction = session.beginTransaction();
            session.remove((Transport) e);//createQuery("DELETE from Angajat where id = " + Integer.toString(utilizator.getId())).executeUpdate();
            transaction.commit();
            session.close();
            return 0;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return 1;
        }
    }

    @Override
    public Object find(int x) {
        try{
            session=factory.openSession();
            transaction = session.beginTransaction();
            NativeQuery query =  session.getNamedNativeQuery("findA");
            query.setParameter("id",x);
            return (Transport)  query.getSingleResult();}
        catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public Object findS(String x, String y) {
        return null;
    }

    public ArrayList<Transport> findAll() {
        try{
            session=factory.openSession();
            transaction = session.beginTransaction();
            NativeQuery query =  session.getNamedNativeQuery("findALL");

            return (ArrayList<Transport>)  query.getResultList();}
        catch (Exception exception){
            exception.printStackTrace();
            return null;

    }



    }

    @Override
    public int update(Object e) {
        try {
            session=factory.openSession();
            transaction = session.beginTransaction();
            session.update("Transport",(Transport) e);
            transaction.commit();
            session.close();

            return 0;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return 1;
        }
    }
}
