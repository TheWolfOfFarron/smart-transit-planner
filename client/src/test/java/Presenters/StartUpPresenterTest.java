package Presenters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartUpPresenterTest {

    @Test
    void newLogin() {
        var R =new StartUpPresenter();
        assertDoesNotThrow(()->{R.newLogin();});

    }

    @Test
    void newGuest() {
        var R =new StartUpPresenter();
        assertDoesNotThrow(()->{R.newGuest();});
    }
}