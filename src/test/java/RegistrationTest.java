import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RegistrationTest extends BaseTest {

    @Test
    public void checkNoDropdownForRoles() {



        // Negative test!!!

        $x("//form[@class='form']//select").should(exist);  // Пошук дропдауну всередині форми за допомогою XPath

    }


        @Test
        public void successfulRegistrationTest() {


            // Заповнюємо поле email
            $("input[name='email']").setValue("Krychkovsk@gmail.com");

            // Заповнюємо поле пароль
            $("input[name='password']").setValue("Testpassword!1");

            // Заповнюємо поле підтвердження пароля
            $("input[name='confirmPassword']").setValue("Testpassword!1");

            // Натискаємо кнопку реєстрації
            $("button[type='submit']").click();

        }

    @Test
    public void emptyFieldsRegistrationTest() {
        // тест на порожні поля


        $("button[type='submit']").shouldBe(disabled);
    }

    @Test
    public void invalidEmailRegistrationTest() {


        // Вводимо некоректний email (без символу @ і домену)
        $("input[name='email']").setValue("Krychkovski1");  // Використовуємо ID для поля email

        // Вводимо валідний пароль
        $("input[name='password']" ).setValue("Testpassword!1");  // Використовуємо ID для поля пароль

        // Заповнюємо поле підтвердження пароля
        $("input[name='confirmPassword']").setValue("Testpassword!1");

        $("button[type='submit']").shouldBe(disabled);
    }


    @Test
    public void passwordTooShortTest() {


        // Вводим правильный username
        $("input[name='email']").setValue("Krychkov@gmail.com");  // Вводим правильный username

        // Вводим неправильный пароль
        $("input[name='password']").setValue("Wrong1!");  // Вводим неправильный пароль

        // Заповнюємо поле підтвердження пароля
        $("input[name='confirmPassword']").setValue("Wrong1!");


        // Нажимаем на кнопку логина
        $("button[type='submit']").shouldBe(disabled);

    }





}
