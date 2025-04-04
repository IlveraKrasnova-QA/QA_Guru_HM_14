package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MapPage {
    private SelenideElement
            mapSearchInput = $("[class=styles-module-crossIcon__size_m-_ltMx]"),
            cityInput = $("[class=styles-module-searchInput-DS602]"),
            resultsButtonInput = $("[class=popup-buttons-WICnh]"),
            cityDropdownInput = $("[class=styles-module-root-IwkAQ]"),
            mapTitleInput = $("[class=styles-module-root-SzJd4]");

    public MapPage checkMapTitle (String value) {
        mapTitleInput.shouldHave(text(value));

        return this;
    }

    public MapPage clickOnMapSearch () {
        mapSearchInput.click();

        return this;
    }

    public MapPage setCity (String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public MapPage clickOnCity (String value) {
        cityDropdownInput.$(byText(value)).click();

        return this;
    }

    public MapPage showResults () {
        resultsButtonInput.click();

        return this;
    }

}
