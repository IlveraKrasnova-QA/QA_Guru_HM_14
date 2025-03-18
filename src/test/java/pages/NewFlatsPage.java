package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewFlatsPage {

    private SelenideElement
            novostroykiButtonInput = $("[data-catalog-slug=catalog_novostroyki]"),
            searchInput = $("[id=bx_search"),
            openMapInput = $("[class=main-richTitleWrapper-bl4mK]"),
            mapSearchInput = $("[class=styles-module-crossIcon__size_m-_ltMx]"),
            cityInput = $("[class=styles-module-searchInput-DS602]"),
            resultsButtonInput = $("[class=popup-buttons-WICnh]"),
            tooltipInput = $("[role=tooltip]"),
            navBarInput = $("[class=index-module-sticky-_WN0D]"),
            cityDropdownInput = $("[class=styles-module-root-IwkAQ]"),
            filtersColumnInput = $("[data-marker=search-filters]"),
            titleInput = $("[class=styles-titleBlock-yPN3m]"),
            pageTitleInput = $("[data-marker=page-title]"),
            breadcrumbsInput = $("[data-marker=breadcrumbs]"),
            mapTitleInput = $("[class=styles-module-root-SzJd4]"),
            cityNameInput = $("[class=central-rubricator-root-fWbVy]");

    public NewFlatsPage openMainPage() {
        open("");

        return this;
    }

    public NewFlatsPage navBarSection (String value) {
        navBarInput.$(byText(value)).hover();

        return this;
    }

    public NewFlatsPage redirectToSectionFromNavBar() {
        novostroykiButtonInput.click();

        return this;
    }

    public NewFlatsPage checkTitle (String value) {
        titleInput.shouldHave(text(value));

        return this;
    }

    public NewFlatsPage redirectToSectionFromSearch(String value) {
        searchInput.setValue(value).pressEnter();

       return this;
    }

    public NewFlatsPage checkPageTitle (String value) {
        pageTitleInput.shouldHave(text(value));

        return this;
    }

    public NewFlatsPage checkBreadcrumbs (String value) {
        breadcrumbsInput.shouldHave(text(value));

        return this;
    }

    public NewFlatsPage openMap () {
        openMapInput.click();

        return this;
    }

    public NewFlatsPage checkMapTitle (String value) {
        mapTitleInput.shouldHave(text(value));

        return this;
    }

    public NewFlatsPage clickOnMapSearch () {
        mapSearchInput.click();

        return this;
    }

    public NewFlatsPage setCity (String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public NewFlatsPage clickOnCity (String value) {
        cityDropdownInput.$(byText(value)).click();

        return this;
    }

    public NewFlatsPage showResults () {
        resultsButtonInput.click();

        return this;
    }

    public NewFlatsPage checkCityResults (String value) {
        cityNameInput.shouldHave(text(value));

        return this;
    }

    public NewFlatsPage scrollToTooltip (String value) {
        filtersColumnInput.$(byText(value)).scrollTo();

        return this;

    }

    public NewFlatsPage checkTooltipText (String value) {
        tooltipInput.shouldHave(text(value));

        return this;
    }

    public NewFlatsPage checkTooltip () {
        tooltipInput.shouldBe(visible);

        return this;

    }






}
