package org.telrancourse.test;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RegistrationTest extends BaseTest {

    @Test
    public void checkNoDropdownForRoles() {

        open("http://chatty.telran-edu.de:8089/registration");
        // Negative test!!!

        $x("//form[@class='form']//select").should(exist);  // Пошук дропдауну всередині форми за допомогою XPath

    }
}
