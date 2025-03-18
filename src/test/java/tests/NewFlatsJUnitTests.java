package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.NewFlatsPage;

public class NewFlatsJUnitTests extends TestBase {

    NewFlatsPage newFlatsPage = new NewFlatsPage();

    @Test
    @DisplayName("Переход на страницу новостроек через  шапку сайта")
    void successfulRedirectToNewBuildingsFromHeaderTest() {
        newFlatsPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar()
                    .checkTitle("Новостройки");

    }

    @Test
    @DisplayName("Переход на страницу новостроек через поиск")
    void successfulRedirectToNewBuildingsFromCategoriesTest() {
        newFlatsPage.openMainPage()
                    .redirectToSectionFromSearch("новостройки")
                    .checkPageTitle("новостройки")
                    .checkBreadcrumbs("новостройки");

    }

    @Test
    @DisplayName("Проверка отображения новостроек для опреденного города")
    void successRegionChangingTest() {
        newFlatsPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar()
                    .openMap()
                    .checkMapTitle("Город или регион")
                    .clickOnMapSearch()
                    .setCity("Казань")
                    .clickOnCity("Казань")
                    .showResults()
                    .checkCityResults("Квартиры в новых ЖК в Казани");

    }

    @Test
    @DisplayName("Проверка отображения подсказки по выбору адреса")
    void chekingCalculatorTest() {
        newFlatsPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar()
                    .scrollToTooltip("Где искать")
                    .checkTooltip()
                    .checkTooltipText("Город и регион можно выбрать тут, а ещё искать по районам и адресам");

    }

}
