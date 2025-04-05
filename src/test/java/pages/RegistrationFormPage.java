package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private SelenideElement
            registrationButtonInput = $("[data-marker=registration-link]"),
            personalAccountInput = $("[class=ChoosingAccountTypeComponent-type-SgQVO]"),
            continueButtonInput = $("[class=css-1kdcmzd]"),
            entryButtonInput = $("[class=css-19geruh]"),
            entryFormInput = $("[class=css-12fgjfr]"),
            bottomOfFormInput = $("[class=AuthorizationMainScreen-footer-QJLQy]"),
            enterPhoneInput = $("[class=EnterPhoneForm-content-WgOcb]"),
            phoneForm = $("[class=EnterPhoneForm-container-xxkr8]");


    @Step("Кликаем на форму регистрации")
    public RegistrationFormPage clickOnRegistrationButton() {
        registrationButtonInput.click();

        return this;
    }

    @Step("Выбираем вид нового аккаунта")
    public RegistrationFormPage chooseAccountType() {
        personalAccountInput.click();

        return this;
    }

    @Step("Нажимаем на кнопку 'Продолжить'")
    public RegistrationFormPage clickOnContinueButton() {
        continueButtonInput.click();

        return this;
    }

    @Step("Проверяем появление ошибки")
    public RegistrationFormPage checkWarning (String value) {
        enterPhoneInput.shouldHave(text(value));

        return this;
    }

    @Step("Проверяем отображение текста на странице регистрации")
    public RegistrationFormPage checkText (String value) {
        phoneForm.shouldHave(text(value));

        return this;
    }

    @Step("Нажимаем на кнопку 'Войти'")
    public RegistrationFormPage clickEntryButton() {
        entryButtonInput.click();

        return this;
    }

    @Step("Проверяем отображение формы регистрации")
    public RegistrationFormPage entryForm () {
        entryFormInput.shouldBe(visible);

        return this;

    }

    @Step("Переходим на страницу с правилами")
    public RegistrationFormPage redirectToSection (String value) {
        bottomOfFormInput.$(byText(value)).click();

        return this;
    }

}
