package Repo;

import Database.Transport;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Objects;

public interface REPO<T>   {




    public int delete(Object e);
    public int insert(Object e);
    public Object  find(int x);
    public T findS(String x, String y);
    public int update(Object e);

    public ArrayList<T> findAll();

}
