package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MapPage;
import pages.NewFlatsPage;

import static io.qameta.allure.Allure.step;

@Tag("newFlats-tests")
public class NewFlatsJUnitTests extends TestBase {

    NewFlatsPage newFlatsPage = new NewFlatsPage();
    MainPage newMainPage = new MainPage();
    MapPage newMapPage = new MapPage();

    @Test
    @DisplayName("Переход на страницу новостроек через  шапку сайта")
    void successfulRedirectToNewBuildingsFromHeaderTest() {
        step("Кликаем на каталог новостроек в навбаре", () -> {
        newMainPage.openMainPage()
                    .navBarSection("Каталоги");
        });
        step("Переходим на страницу с новостройками", () -> {
        newMainPage.redirectToSectionFromNavBar();
        });
        step("Проверяем заголовок", () -> {
        newFlatsPage.checkTitle("Новостройки");
        });

    }

    @Test
    @DisplayName("Переход на страницу новостроек через поиск")
    void successfulRedirectToNewBuildingsFromCategoriesTest() {
        step("Вводим в поиске название категории и переходим по результату", () -> {
        newMainPage.openMainPage()
                   .redirectToSectionFromSearch("новостройки");
        });
        step("Проверяем отображение корректного заголовка и 'хлебных крошек'", () -> {
        newFlatsPage.checkPageTitle("новостройки")
                    .checkBreadcrumbs("новостройки");
        });

    }

    @Test
    @DisplayName("Проверка отображения новостроек для определенного города")
    void successRegionChangingTest() {
        step("Переходим в раздел новостроек", () -> {
         newMainPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar();
        });
        step("Открываем попап с выбором города и региона", () -> {
        newFlatsPage.openMap();
        });
        step("Проверяем открытие нужного попапа", () -> {
        newMapPage.checkMapTitle("Город или регион");
        });
        step("Выбираем город", () -> {
        newMapPage.clickOnMapSearch()
                   .setCity("Казань")
                   .clickOnCity("Казань")
                   .showResults();
        });
        step("Проверяем отображение корректных результатов", () -> {
            newFlatsPage.checkCityResults("Квартиры в новых ЖК в Казани");
        });

    }

    @Test
    @DisplayName("Проверка отображения подсказки по выбору адреса")
    void chekingCalculatorTest() {
        step("Переходим в раздел новостроек", () -> {
        newMainPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar();
        });
        step("Проверяем отображение тултипа", () -> {
        newFlatsPage.scrollToTooltip("Где искать")
                    .checkTooltip()
                    .checkTooltipText("Город и регион можно выбрать тут, а ещё искать по районам и адресам");
        });

    }

}
