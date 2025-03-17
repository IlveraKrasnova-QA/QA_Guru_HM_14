package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.RegistrationFormComponents;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private SelenideElement
            registrationButtonInput = $("[data-marker=registration-link]"),
            personalAccountInput = $("[class=ChoosingAccountTypeComponent-type-SgQVO]"),
            continueButtonInput = $("[class=css-1kdcmzd]"),
            entryButtonInput = $("[class=css-19geruh]"),
            entryFormInput = $("[class=css-12fgjfr]");

    RegistrationFormComponents registrationFormComponents = new RegistrationFormComponents();

    public RegistrationFormPage openMainPage() {
        open("");

        return this;
    }

    public RegistrationFormPage openRegisrationForm (String value) {
        registrationFormComponents.openRegisrationForm(value);

        return this;
    }

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
        registrationFormComponents.checkWarning(value);

        return this;
    }

    public RegistrationFormPage checkText (String value) {
        registrationFormComponents.checkText(value);

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
        registrationFormComponents.redirectToSection(value);

        return this;
    }

    public RegistrationFormPage checkTermsTitle (String value) {
        registrationFormComponents.checkTermsTitle(value);

        return this;
    }

    public RegistrationFormPage checkPrivacyTitle (String value) {
        registrationFormComponents.checkPrivacyTitle(value);

        return this;
    }







}
