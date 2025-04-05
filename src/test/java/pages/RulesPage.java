package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RulesPage {

    private SelenideElement
            pageTitle = $("[id=b2b-hub-app]");

    public RulesPage checkPageTitle (String value) {
        pageTitle.shouldHave(text(value));

        return this;
    }
}
