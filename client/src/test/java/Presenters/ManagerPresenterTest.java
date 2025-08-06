package Presenters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerPresenterTest {

    @Test
    void insert() {
        var X = new ManagerPresenter();

        assertDoesNotThrow(()->{X.insert("1","2","3","4","5","6","7","8","9");});
    }

    @Test
    void update() {
        var X = new ManagerPresenter();

        assertDoesNotThrow(()->{X.update("1","2","3","4","5","6","7","8","9");});
    }

    @Test
    void delete() {
        var X = new ManagerPresenter();

       assertDoesNotThrow(()->{X.delete("1","2","3","4","5","6","7","8","9");});
    }

    @Test
    void find() {
        var X = new ManagerPresenter();

        assertDoesNotThrow(()->{X.find();});
    }

    @Test
    void table() {
        var X = new ManagerPresenter();

        assertDoesNotThrow(()->{X.table();});
    }
}