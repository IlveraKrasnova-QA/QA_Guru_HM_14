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
        step("Открываем форму входа", () -> {
        newMainPage.openMainPage()
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
        newMainPage.openMainPage()
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
        newMainPage.openMainPage()
                    .openRegisrationForm("Вход и регистрация");
        });
        step("Переходим на страницу с условиями пользования", () -> {
        registrationFormPage.redirectToSection("условиями использования Авито");
        });
        step("Проверяем переход на правильную страницу", () -> {
        newRulesPage.checkPageTitle("Условия использования Авито");
        });

    }

    @Test
    @DisplayName("Проверяем редирект на политику конфиденциальности")
    void  privacyPolicyTest() {
        step("Открываем форму входа", () -> {
        newMainPage.openMainPage()
                    .openRegisrationForm("Вход и регистрация");
        });
        step("Переходим на страницу с политикой конфиденциальности", () -> {
        registrationFormPage.redirectToSection("политикой конфиденциальности");
        });
        step("Проверяем переход на правильную страницу", () -> {
        newRulesPage.checkPageTitle("Политика конфиденциальности");
        });

    }

}
