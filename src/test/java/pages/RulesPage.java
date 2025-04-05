package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RulesPage {

    private SelenideElement
            pageTitle = $("[id=b2b-hub-app]");

    @Step("Проверяем заголовок раздела")
    public RulesPage checkPageTitle (String value) {
        pageTitle.shouldHave(text(value));

        return this;
    }
}
