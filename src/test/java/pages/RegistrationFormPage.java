package pages;

import com.codeborne.selenide.SelenideElement;

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


    public RegistrationFormPage clickOnRegistrationButton() {
        registrationButtonInput.click();

        return this;
    }

    public RegistrationFormPage chooseAccountType() {
        personalAccountInput.click();

        return this;
    }

    public RegistrationFormPage clickOnContinueButton() {
        continueButtonInput.click();

        return this;
    }

    public RegistrationFormPage checkWarning (String value) {
        enterPhoneInput.shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkText (String value) {
        phoneForm.shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage clickEntryButton() {
        entryButtonInput.click();

        return this;
    }

    public RegistrationFormPage entryForm () {
        entryFormInput.shouldBe(visible);

        return this;

    }

    public RegistrationFormPage redirectToSection (String value) {
        bottomOfFormInput.$(byText(value)).click();

        return this;
    }

}
