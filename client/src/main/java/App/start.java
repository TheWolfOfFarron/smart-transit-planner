package App;

import java.io.IOException;

public class start {
    public static void main(String[] args) {
        //Used patterns
        //Observer
        //Composite
        //Proxi
        //Singeleton
        //Builder
        Thread th = null;
        try {
            th = new Thread(new Clientt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        th.start();

    }


}
