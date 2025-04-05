package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            novostroykiButtonInput = $("[data-catalog-slug=catalog_novostroyki]"),
            searchInput = $("[id=bx_search"),
            navBarInput = $("[class=index-module-sticky-_WN0D]");

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("");

        return this;
    }

    @Step("Открываем каталог в навбаре")
    public MainPage navBarSection (String value) {
        navBarInput.$(byText(value)).hover();

        return this;
    }

    @Step("Переходим на страницу выбранной категории через навбар")
    public MainPage redirectToSectionFromNavBar() {
        novostroykiButtonInput.click();

        return this;
    }

    @Step("Переходим на страницу выбранной категории через поиск")
    public MainPage redirectToSectionFromSearch(String value) {
        searchInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Открываем форму регистрации")
    public MainPage openRegisrationForm (String value) {
        navBarInput.$(byText(value)).click();

        return this;
    }

}
