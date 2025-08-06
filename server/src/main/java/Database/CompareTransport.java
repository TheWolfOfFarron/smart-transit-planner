package Database;

import java.util.Comparator;

public class CompareTransport implements Comparator<Transport> {

    public int compare(Transport o1, Transport o2) {
        if(o1.getNrStatie()<o2.getNrStatie())return -1;
        else
        if(o1.getNrStatie()<o2.getNrStatie()) return 1;
        else return 0;
    }
}
