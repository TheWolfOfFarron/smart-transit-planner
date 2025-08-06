package Presenters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginPresenterTest {

    @Test
    void login() {
        var X = new LoginPresenter();
        assertDoesNotThrow(()->{X.login("sda","Da");});
    }


}