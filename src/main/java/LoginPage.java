import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

public class LoginPage {   // Локатор для заголовка страницы
    private final SelenideElement loginTitle = $("h1");

    // Метод для проверки текста заголовка
    public void checkLoginTitle(String expectedTitle) {
        loginTitle.shouldHave(text(expectedTitle));
    }

    // Метод для проверки, что заголовок виден в течение 10 секунд
    public void checkLoginTitleVisible() {
        loginTitle.shouldBe(visible, ofSeconds(10));
    }

    // Локатор кнопки отправки формы
    private final SelenideElement submitButton = $("button[type='submit']");

    // Метод для проверки, что кнопка отправки формы неактивна (disabled)
    public void checkSubmitButtonIsDisabled() {
        submitButton.shouldBe(disabled);  // Проверяем, что кнопка неактивна
    }

    // Локатор поля email (если потребуется)
    private final SelenideElement emailInputField = $("input[name='email']");
    public void enterEmail(String emailValue) {
        emailInputField.setValue(emailValue);
    }

    // Локатор поля пароля (если потребуется)
    private final SelenideElement passwordInputField = $("input[name='password']");
    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }


    // Локатор для кнопки отправки формы (логин)
    private final SelenideElement loginButton = $("button[type='submit']");

    // Метод для клика по кнопке логина
    public void clickOnLoginButton() {
        loginButton.click();
    }

    private final SelenideElement checkErrorMessage = $(".text-error");


    public void checkErrorMessage(String incorrectEmail ) {
        checkErrorMessage.shouldHave(text(incorrectEmail));
    }

    // Проверяем, что кнопка логина отключена
    public void checkLoginButtonDisabled() {
        loginButton.shouldBe(disabled);
    }
}
