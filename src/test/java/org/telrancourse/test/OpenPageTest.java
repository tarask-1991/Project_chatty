package org.telrancourse.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OpenPageTest extends BaseTest {

    @Test
    public void openLoginPageTest() {


        // Проверяем, что страница открылась, например, по наличию заголовка или другого элемента
        $("h1").shouldHave(text("Login"));  // Проверяем, есть ли заголовок "Login" на странице
    }

    @Test
    public void emptyFieldsLoginTest() {
        // тест на порожні поля

        $("button[type='submit']").shouldBe(disabled);
    }


        @Test
        public void validEmailLoginTest() {


            // Вводимо валідний email
            $("input[name='email']").setValue("Krychkovski@gmail.com");  // Вводимо правильний email

            // Вводимо валідний пароль
            $("input[name='password']").setValue("Admintest1");  // Вводимо правильний пароль

            // Натискаємо на кнопку логіну
            $("button[type='submit']").click();  // Використовуємо правильний селектор для кнопки входу

        }






    @Test
        public void invalidEmailLoginTest() {


            // Вводимо некоректний email (без символу @ і домену)
            $("input[name='email']").setValue("Krychkovski1");  // Використовуємо ID для поля email

            // Вводимо валідний пароль
            $("input[name='password']" ).setValue("Admintest1");  // Використовуємо ID для поля пароль

            // Перевіряємо, що з'явилося повідомлення про помилку "Incorrect email"
            $(".text-error").shouldHave(text("Incorrect email"));  // Перевіряємо наявність повідомлення про помилку
        }




        @Test
        public void emailWithTwoCharactersTest() {


            // Вводим 2 символа в поле email
            $("input[name='email']").setValue("ab");

            // Вводимо валідний пароль
            $("input[name='password']" ).setValue("Admintest1");  // Використовуємо ID для поля пароль

            $("button[type='submit']").shouldBe(disabled);

        }

        @Test
        public void emailWithTwentyTwoCharactersTest() {


            // Вводим 22 символа в поле email
            $("input[name='email']").setValue("abcdefghijklmnopqrstuv");

            // Вводимо валідний пароль
            $("input[name='password']" ).setValue("Admintest1");  // Використовуємо ID для поля пароль

            $("button[type='submit']").shouldBe(disabled);

        }




        @Test
        public void passwordTooShortTest() {


            // Вводим правильный username
            $("input[name='email']").setValue("Krychkovski@gmail.com");  // Вводим правильный username

            // Вводим неправильный пароль
            $("input[name='password']").setValue("Wrong1!");  // Вводим неправильный пароль

            // Нажимаем на кнопку логина
            $("button[type='submit']").shouldBe(disabled);

        }


    }











