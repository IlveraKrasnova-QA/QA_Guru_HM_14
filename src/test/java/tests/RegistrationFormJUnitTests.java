package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormJUnitTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Неуспешная регистрация без ввода номера телефона")
    void unsuccessfulRegistrationWithoutNumberTest() {
        registrationFormPage.openMainPage()
                            .openRegisrationForm("Вход и регистрация")
                            .clickOnRegistrationButton()
                            .chooseAccountType()
                            .clickOnContinueButton()
                            .checkWarning("Заполните поле");
    }

    @Test
    @DisplayName("Проверяем редирект на форму входа через форму регистрации")
    void redirectToLoginFromRegistrationFormTest() {
        registrationFormPage.openMainPage()
                            .openRegisrationForm("Вход и регистрация")
                            .clickOnRegistrationButton()
                            .chooseAccountType()
                            .checkText("Уже есть профиль? ")
                            .checkText("Войти")
                            .clickEntryButton()
                            .entryForm();

    }

    @Test
    @DisplayName("Проверяем редирект на условия пользования")
    void termsOfUseTest() {
        registrationFormPage.openMainPage()
                            .openRegisrationForm("Вход и регистрация")
                            .redirectToSection("условиями использования Авито")
                            .checkPageTitle("Условия использования Авито");

    }

    @Test
    @DisplayName("Проверяем редирект на политику конфиденциальности")
    void  privacyPolicyTest() {
        registrationFormPage.openMainPage()
                            .openRegisrationForm("Вход и регистрация")
                            .redirectToSection("политикой конфиденциальности")
                            .checkPageTitle("Политика конфиденциальности");

    }

}
