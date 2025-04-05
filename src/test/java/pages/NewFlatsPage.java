package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewFlatsPage {

    private SelenideElement
            openMapInput = $("[class=main-richTitleWrapper-bl4mK]"),
            tooltipInput = $("[role=tooltip]"),
            filtersColumnInput = $("[data-marker=search-filters]"),
            titleInput = $("[class=styles-titleBlock-yPN3m]"),
            pageTitleInput = $("[data-marker=page-title]"),
            breadcrumbsInput = $("[data-marker=breadcrumbs]"),
            cityNameInput = $("[class=central-rubricator-root-fWbVy]");


    @Step("Проверяем заголовок раздела")
    public NewFlatsPage checkTitle (String value) {
        titleInput.shouldHave(text(value));

        return this;
    }

    @Step("Проверяем заголовок раздела")
    public NewFlatsPage checkPageTitle (String value) {
        pageTitleInput.shouldHave(text(value));

        return this;
    }

    @Step("Проверяем корректные 'хлебные крошки'")
    public NewFlatsPage checkBreadcrumbs (String value) {
        breadcrumbsInput.shouldHave(text(value));

        return this;
    }

    @Step("Открываем карту")
    public NewFlatsPage openMap () {
        openMapInput.click();

        return this;
    }

    @Step("Проверяем отображение товаров для выбранного города")
    public NewFlatsPage checkCityResults (String value) {
        cityNameInput.shouldHave(text(value));

        return this;
    }

    @Step("Скроллим страницу до тултипа")
    public NewFlatsPage scrollToTooltip (String value) {
        filtersColumnInput.$(byText(value)).scrollTo();

        return this;

    }

    @Step("Проверяем текст в тултипе")
    public NewFlatsPage checkTooltipText (String value) {
        tooltipInput.shouldHave(text(value));

        return this;
    }

    @Step("Проверяем отображение тултипа")
    public NewFlatsPage checkTooltip () {
        tooltipInput.shouldBe(visible);

        return this;

    }

}
