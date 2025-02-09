package org.telrancourse.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OpenPageTest extends BaseTest {

    @Test
    public void openLoginPageTest() {
        // Відкриваємо сторінку логіну
        open("http://chatty.telran-edu.de:8089/login");

        // Перевіряємо, що сторінка відкрилася, наприклад, за наявністю заголовка або іншого елемента
        $("h1").shouldHave(text("Login"));  // Перевіряємо, чи є заголовок "Login" на сторінці
    }
}
