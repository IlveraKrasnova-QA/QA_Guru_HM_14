package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MapPage;
import pages.NewFlatsPage;


@Tag("newFlats-tests")
public class NewFlatsJUnitTests extends TestBase {

    NewFlatsPage newFlatsPage = new NewFlatsPage();
    MainPage newMainPage = new MainPage();
    MapPage newMapPage = new MapPage();

    @Test
    @DisplayName("Переход на страницу новостроек через  шапку сайта")
    void successfulRedirectToNewBuildingsFromHeaderTest() {
        newMainPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar();
        newFlatsPage.checkTitle("Новостройки");

    }

    @Test
    @DisplayName("Переход на страницу новостроек через поиск")
    void successfulRedirectToNewBuildingsFromCategoriesTest() {
        newMainPage.openMainPage()
                   .redirectToSectionFromSearch("новостройки");
        newFlatsPage.checkPageTitle("новостройки")
                    .checkBreadcrumbs("новостройки");


    }

    @Test
    @DisplayName("Проверка отображения новостроек для определенного города")
    void successRegionChangingTest() {
         newMainPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar();
         newFlatsPage.openMap();
         newMapPage.checkMapTitle("Город или регион")
                    .clickOnMapSearch()
                    .setCity("Казань")
                    .clickOnCity("Казань")
                    .showResults();
         newFlatsPage.checkCityResults("Квартиры в новых ЖК в Казани");

    }

    @Test
    @DisplayName("Проверка отображения подсказки по выбору адреса")
    void chekingCalculatorTest() {
        newMainPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar();
        newFlatsPage.scrollToTooltip("Где искать")
                    .checkTooltip()
                    .checkTooltipText("Город и регион можно выбрать тут, а ещё искать по районам и адресам");

    }

}
