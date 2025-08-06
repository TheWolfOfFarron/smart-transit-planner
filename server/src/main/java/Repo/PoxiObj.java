package Repo;

import org.hibernate.boot.Metadata;

public class PoxiObj implements Proxi {

    private static Proxi object;

    @Override
    public Metadata generate() {
        if (object == null) {
            object = new ProxiImp();
        }
       return object.generate();
    }
}
