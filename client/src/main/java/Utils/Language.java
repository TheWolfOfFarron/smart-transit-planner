package Utils;

import java.util.ArrayList;

public class Language {

    public static String lang = "ge";
    public static String country = "GE";
    private static ArrayList<Observerr> observers;

    public static void change(String l, String c) {
        lang = l;
        country = c;
    }

    public static void add(Observerr o) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(o);

    }

    public static void delete(Observerr o) {
        observers.remove(o);
    }

    public static void update() {

        for (Observerr o : observers) {
            o.language();
        }

    }

}
