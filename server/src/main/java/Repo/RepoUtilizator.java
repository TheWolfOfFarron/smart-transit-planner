package Repo;


import Database.Transport;
import Database.Utilizator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.Objects;

public class RepoUtilizator implements REPO {







    private SessionFactory factory;
    private Session session;

    private Transaction transaction;


    public RepoUtilizator() {
        Proxi p =new PoxiObj();
        var meta=p.generate();
        factory=meta.getSessionFactoryBuilder().build();
        session=factory.openSession();
    }

    @Override
    public int insert(Object e) {


        try {transaction = session.beginTransaction();
            session.persist("Utilizator",(Utilizator) e);
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
            session.remove((Utilizator) e);//createQuery("DELETE from Angajat where id = " + Integer.toString(utilizator.getId())).executeUpdate();
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
    public Object find(int id) {
        try{
            session=factory.openSession();
            transaction = session.beginTransaction();
            NativeQuery query =  session.getNamedNativeQuery("findB");
            query.setParameter("id",id);
            return (Utilizator)  query.getSingleResult();}
        catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public Object findS(String x, String y) {
        try{
            session=factory.openSession();
            transaction = session.beginTransaction();
            NativeQuery query =  session.getNamedNativeQuery("findUserAndPass");
            query.setParameter("username",x);
            query.setParameter("parola",y);
            return (Utilizator)  query.getSingleResult();}
        catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Utilizator> findAll() {
        try{
            session=factory.openSession();
            transaction = session.beginTransaction();
            NativeQuery query =  session.getNamedNativeQuery("findALLU");
            return (ArrayList<Utilizator>)  query.getResultList();}
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
            session.update("Utilizator",(Utilizator) e);
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
