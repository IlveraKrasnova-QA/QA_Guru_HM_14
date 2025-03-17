package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormComponents {

    public void openRegisrationForm (String value) {
        $("[class=index-module-sticky-_WN0D]").$(byText(value)).click();
    }

    public void redirectToSection (String value) {
        $("[class=AuthorizationMainScreen-footer-QJLQy]").$(byText(value)).click();
    }

    public void checkWarning(String value) {
        $("[class=EnterPhoneForm-content-WgOcb]").shouldHave(text(value));
    }

    public void checkText(String value) {
        $("[class=EnterPhoneForm-container-xxkr8]").shouldHave(text(value));
    }

    public void checkTitleOf(String value) {
        $("[class=EnterPhoneForm-container-xxkr8]").shouldHave(text(value));
    }

    public void checkTermsTitle(String value) {
        $("[id=b2b-hub-app]").shouldHave(text(value));
    }

    public void checkPrivacyTitle(String value) {
        $("[id=b2b-hub-app]").shouldHave(text(value));
    }

}
