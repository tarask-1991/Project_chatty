import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();


    @Test
    public void openLoginPageTest() {

        // Проверяем заголовок страницы
        loginPage.checkLoginTitle("Login Form");

        // Проверяем, что заголовок виден в течение 10 секунд
        loginPage.checkLoginTitleVisible();
    }


    @Test
    public void emptyFieldsLoginTest() {

        // Проверяем, что кнопка логина неактивна при пустых полях
        loginPage.checkSubmitButtonIsDisabled();
    }

    @Test
    public void validEmailLoginTest() {

        // Вводим валидный email
        loginPage.enterEmail("Krychkovski@gmail.com");

        // Вводим валидный пароль
        loginPage.enterPassword("Admintest1");

        // Нажимаем на кнопку логина
        loginPage.clickOnLoginButton();
    }


    @Test
    public void invalidEmailLoginTest() {

        // Вводим некорректный email (без символа @ и домена)
        loginPage.enterEmail("Krychkovski1");

        // Вводим валидный пароль
        loginPage.enterPassword("Admintest1");

        // Проверяем, что появилось сообщение об ошибке
        loginPage.checkErrorMessage("Incorrect email");

        // Проверяем, что кнопка логина по-прежнему активна
        $("button[type='submit']").shouldBe(disabled);
    }

    @Test
    public void emailWithTwoCharactersTest() {
        loginPage.enterEmail("K1");

        // Вводим валидный пароль
        loginPage.enterPassword("Admintest1");

        // Проверяем, что появилось сообщение об ошибке
        loginPage.checkErrorMessage("Incorrect email");

        // Проверяем, что кнопка логина по-прежнему активна
        $("button[type='submit']").shouldBe(disabled);
    }


    @Test
    public void passwordTooShortTest() {

        // Вводим правильный email
        loginPage.enterEmail("Krychkovski@gmail.com");

        // Вводим неправильный слишком короткий пароль
        loginPage.enterPassword("Wrong1!");

        // Проверяем, что кнопка логина отключена
        loginPage.checkLoginButtonDisabled();
    }

}
