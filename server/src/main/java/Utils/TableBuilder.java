package Utils;

import Database.Utilizator;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableBuilder {

    private ArrayList<String> colums=new ArrayList<>();

    private ArrayList<Utilizator> data=new ArrayList<>();
    private  String s;
    private DefaultTableModel defaultTableModel=new DefaultTableModel();

    public TableBuilder(){

    }
    public TableBuilder setFiltru(String dd){
    s=dd;
    return this;
    }

    public TableBuilder setColums(ArrayList<String> s){
        for(String i :s){
            defaultTableModel.addColumn(i);
        }
        return this;
    }
    public TableBuilder setData(ArrayList<Utilizator> x){

        int ct=0;
        for(Utilizator i : x) {
            if (i.getTip().equals(s)) {
                ArrayList<Object> show = new ArrayList<>();
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
                defaultTableModel.addRow(show.toArray());
            }

        }
        return this;
    }

    public DefaultTableModel build(){
        return defaultTableModel;
    }

}
