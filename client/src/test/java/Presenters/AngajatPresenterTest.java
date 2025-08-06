package Presenters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngajatPresenterTest {

    @Test
    void insert() {
        var X = new AngajatPresenter();

        assertDoesNotThrow(()->{X.insert("10","2","3","4");});
        assertThrows(NumberFormatException.class,()->{X.insert("10","2","3","b");});
    }

    @Test
    void update() {
        var X = new AngajatPresenter();

        assertDoesNotThrow(()->{X.update("10","2","3","4");});
        assertThrows(NumberFormatException.class,()->{X.insert("10","2","3","b");});

    }

    @Test
    void delete() {
        var X = new AngajatPresenter();

        assertDoesNotThrow(()->{X.delete("10","2","3","4");});
        assertThrows(NumberFormatException.class,()->{X.insert("10","2","3","b");});
    }

    @Test
    void find() {
        var X=new AngajatPresenter();

        assertDoesNotThrow(()->{X.find();});
    }
}