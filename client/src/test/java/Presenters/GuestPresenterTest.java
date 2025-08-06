package Presenters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestPresenterTest {

    @Test
    void find() {
        var X = new GuestPresenter();

        assertDoesNotThrow(()->{X.find("4");});
    }

    @Test
    void back() {
        var X = new GuestPresenter();

        assertDoesNotThrow(()->{X.back();});
    }
}