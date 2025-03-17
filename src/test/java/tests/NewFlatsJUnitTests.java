package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewFlatsJUnitTests extends TestBase {

    @Test
    @DisplayName("Переход на страницу новостроек через  шапку сайта")
    void successfulRedirectToNewBuildingsFromHeaderTest() {
        open("");
        $("[class=index-module-sticky-_WN0D]").$(byText("Каталоги")).hover();
        $("[data-catalog-slug=catalog_novostroyki]").click();
        $("[class=styles-titleBlock-yPN3m]").shouldHave(text("Новостройки"));
    }

    @Test
    @DisplayName("Переход на страницу новостроек через поиск")
    void successfulRedirectToNewBuildingsFromCategoriesTest() {
        open("");
        $("[id=bx_search").click();
        $("[id=bx_search").setValue("новостройки").pressEnter();
        $("[data-marker=page-title]").shouldHave(text("новостройки»"));
        $("[data-marker=breadcrumbs]").shouldHave(text("новостройки"));
    }

    @Test
    @DisplayName("Проверка отображения новостроек для опреденного города")
    void successRegionChangingTest() {
        open("");
        $("[class=index-module-sticky-_WN0D]").$(byText("Каталоги")).hover();
        $("[data-catalog-slug=catalog_novostroyki]").click();
        $("[class=index-rightWrapper-_z7uN]").click();
        $("[class=styles-module-root-SzJd4]").shouldHave(text("Город или регион"));
        $("[class=styles-module-crossIcon__size_m-_ltMx]").click();
        $("[class=styles-module-dropdownScrollWrapper-ugdzU]").shouldBe(visible);
        $("[class=styles-module-searchInput-DS602]").setValue("Казань");
        $("[class=styles-module-root-IwkAQ]").$(byText("Казань")).click();
        $("[class=popup-buttons-WICnh]").click();
        $("[class=central-rubricator-root-fWbVy]").shouldHave(text("Квартиры в новых ЖК в Казани"));
    }

    @Test
    @DisplayName("Проверка отображения подсказки по выбору адреса")
    void chekingCalculatorTest() {
        open("");
        $("[class=index-module-sticky-_WN0D]").$(byText("Каталоги")).hover();
        $("[data-catalog-slug=catalog_novostroyki]").click();
        $("[data-marker=search-filters]").$(byText("Где искать")).scrollTo();
        $("[role=tooltip]").shouldBe(visible);
        $("[role=tooltip]").shouldHave(text("Город и регион можно выбрать тут, а ещё искать по районам и адресам"));
    }



}
