package org.telrancourse.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";  // Вибір браузера
        Configuration.timeout = 10000;
        open("http://chatty.telran-edu.de:8089/login");  // Відкриваємо сторінку
    }

}
