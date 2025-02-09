package org.telrancourse.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OpenPageTest extends BaseTest {

    @Test
    public void openLoginPageTest() {
        // Открываем страницу логина
        open("http://chatty.telran-edu.de:8089/login");

        // Проверяем, что страница открылась, например, по наличию заголовка или другого элемента
        $("h1").shouldHave(text("Login"));  // Проверяем, есть ли заголовок "Login" на странице
    }

}
