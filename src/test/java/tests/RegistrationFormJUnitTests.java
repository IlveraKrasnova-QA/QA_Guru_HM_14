package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationFormPage;
import pages.RulesPage;

import static io.qameta.allure.Allure.step;

@Tag("registration-tests")
public class RegistrationFormJUnitTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    MainPage newMainPage = new MainPage();
    RulesPage newRulesPage = new RulesPage();

    @Test
    @DisplayName("Неуспешная регистрация без ввода номера телефона")
    void unsuccessfulRegistrationWithoutNumberTest() {
        newMainPage.openMainPage()
                   .openRegisrationForm("Вход и регистрация");
        registrationFormPage.clickOnRegistrationButton()
                            .chooseAccountType()
                            .clickOnContinueButton()
                            .checkWarning("Заполните поле");

    }

    @Test
    @DisplayName("Проверяем редирект на форму входа через форму регистрации")
    void redirectToLoginFromRegistrationFormTest() {
        newMainPage.openMainPage()
                   .openRegisrationForm("Вход и регистрация");
        registrationFormPage.clickOnRegistrationButton()
                            .chooseAccountType()
                            .checkText("Уже есть профиль? ")
                            .checkText("Войти")
                            .clickEntryButton()
                            .entryForm();

    }

    @Test
    @DisplayName("Проверяем редирект на условия пользования")
    void termsOfUseTest() {
        newMainPage.openMainPage()
                    .openRegisrationForm("Вход и регистрация");
        registrationFormPage.redirectToSection("условиями использования Авито");
        newRulesPage.checkPageTitle("Условия использования Авито");

    }

    @Test
    @DisplayName("Проверяем редирект на политику конфиденциальности")
    void  privacyPolicyTest() {
        newMainPage.openMainPage()
                   .openRegisrationForm("Вход и регистрация");
        registrationFormPage.redirectToSection("политикой конфиденциальности");
        newRulesPage.checkPageTitle("Политика конфиденциальности");

    }

}
