package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;

@Tag("registration_tests")
public class RegistrationFormJUnitTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Неуспешная регистрация без ввода номера телефона")
    void unsuccessfulRegistrationWithoutNumberTest() {
        step("Открываем форму входа", () -> {
        registrationFormPage.openMainPage()
                            .openRegisrationForm("Вход и регистрация");
        });
        step("Переходим на экран выбора типа нового аккаунта", () -> {
        registrationFormPage.clickOnRegistrationButton();
        });
        step("Выбираем личный тип аккаунта для регистрации", () -> {
        registrationFormPage.chooseAccountType();
        });
        step("Нажимаем на кнопку 'Продолжить' без ввода номера телефона", () -> {
        registrationFormPage.clickOnContinueButton();
        });
        step("Проверяем появление ошибки", () -> {
        registrationFormPage.checkWarning("Заполните поле");
        });
    }

    @Test
    @DisplayName("Проверяем редирект на форму входа через форму регистрации")
    void redirectToLoginFromRegistrationFormTest() {
        step("Открываем форму входа", () -> {
        registrationFormPage.openMainPage()
                            .openRegisrationForm("Вход и регистрация");
        });
        step("Переходим на экран выбора типа нового аккаунта", () -> {
        registrationFormPage.clickOnRegistrationButton();
        });
        step("Выбираем личный тип аккаунта для регистрации", () -> {
            registrationFormPage.chooseAccountType();
        });
        step("Проверяем отображение кнопки 'Войти' на форме регистрации", () -> {
        registrationFormPage.checkText("Уже есть профиль? ")
                            .checkText("Войти");
        });
        step("Переходим на форму входа", () -> {
        registrationFormPage.clickEntryButton()
                            .entryForm();
        });

    }

    @Test
    @DisplayName("Проверяем редирект на условия пользования")
    void termsOfUseTest() {
        step("Открываем форму входа", () -> {
        registrationFormPage.openMainPage()
                            .openRegisrationForm("Вход и регистрация");
        });
        step("Переходим на страницу с условиями пользования", () -> {
        registrationFormPage.redirectToSection("условиями использования Авито")
                            .checkPageTitle("Условия использования Авито");
        });

    }

    @Test
    @DisplayName("Проверяем редирект на политику конфиденциальности")
    void  privacyPolicyTest() {
        step("Открываем форму входа", () -> {
        registrationFormPage.openMainPage()
                                .openRegisrationForm("Вход и регистрация");
        });
        step("Переходим на страницу с политикой конфиденциальности", () -> {
        registrationFormPage.redirectToSection("политикой конфиденциальности")
                            .checkPageTitle("Политика конфиденциальности");
        });

    }

}
