package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            novostroykiButtonInput = $("[data-catalog-slug=catalog_novostroyki]"),
            searchInput = $("[id=bx_search"),
            navBarInput = $("[class=index-module-sticky-_WN0D]");

    public MainPage openMainPage() {
        open("");

        return this;
    }

    public MainPage navBarSection (String value) {
        navBarInput.$(byText(value)).hover();

        return this;
    }

    public MainPage redirectToSectionFromNavBar() {
        novostroykiButtonInput.click();

        return this;
    }

    public MainPage redirectToSectionFromSearch(String value) {
        searchInput.setValue(value).pressEnter();

        return this;
    }

    public MainPage openRegisrationForm (String value) {
        navBarInput.$(byText(value)).click();

        return this;
    }

}
