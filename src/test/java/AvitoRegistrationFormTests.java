import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvitoRegistrationFormTests extends TestBase {

    @Test
    @DisplayName("Неуспешная регистрация без ввода номера телефона")
    void unsuccessfulRegistrationWithoutNumberTest() {
        open("");
        $("[class=index-module-sticky-_WN0D]").$(byText("Вход и регистрация")).click();
        $("[data-marker=registration-link]").click();
        $("[class=ChoosingAccountTypeComponent-type-SgQVO]").click();
        $("[class=css-1kdcmzd]").click();
        $("[class=EnterPhoneForm-content-WgOcb]").shouldHave(text("Заполните поле"));
    }

    @Test
    @DisplayName("Проверяем редирект на форму входа через форму регистрации")
    void redirectToLoginFromRegistrationFormTest() {
        open("");
        $("[class=index-module-sticky-_WN0D]").$(byText("Вход и регистрация")).click();
        $("[data-marker=registration-link]").click();
        $("[class=ChoosingAccountTypeComponent-type-SgQVO]").click();
        $("[class=EnterPhoneForm-container-xxkr8]").shouldHave(text("Уже есть профиль? "));
        $("[class=EnterPhoneForm-container-xxkr8]").shouldHave(text("Войти"));
        $("[class=css-19geruh]").click();
        $("[class=css-12fgjfr]").shouldBe(visible);
    }

    @Test
    @DisplayName("Проверяем редирект на условия пользования")
    void termsOfUseTest() {
        open("");
        $("[class=index-module-sticky-_WN0D]").$(byText("Вход и регистрация")).click();
        $("[class=AuthorizationMainScreen-footer-QJLQy]").$(byText("условиями использования Авито")).click();
        $("[id=b2b-hub-app]").shouldHave(text("Условия использования Авито"));
    }

    @Test
    @DisplayName("Проверяем редирект на политику конфиденциальности")
    void  privacyPolicyTest() {
        open("");
        $("[class=index-module-sticky-_WN0D]").$(byText("Вход и регистрация")).click();
        $("[class=AuthorizationMainScreen-footer-QJLQy]").$(byText("политикой конфиденциальности")).click();
        $("[id=b2b-hub-app]").shouldHave(text("Политика конфиденциальности"));
    }

}
