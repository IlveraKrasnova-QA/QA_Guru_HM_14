package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.NewFlatsPage;

import static io.qameta.allure.Allure.step;

public class NewFlatsJUnitTests extends TestBase {

    NewFlatsPage newFlatsPage = new NewFlatsPage();

    @Test
    @DisplayName("Переход на страницу новостроек через  шапку сайта")
    void successfulRedirectToNewBuildingsFromHeaderTest() {
        step("Кликаем на каталог новостроек в навбаре", () -> {
        newFlatsPage.openMainPage()
                    .navBarSection("Каталоги");
        });
        step("Переходим на страницу с новостройками", () -> {
        newFlatsPage.redirectToSectionFromNavBar()
                    .checkTitle("Новостройки");
        });

    }

    @Test
    @DisplayName("Переход на страницу новостроек через поиск")
    void successfulRedirectToNewBuildingsFromCategoriesTest() {
        step("Вводим в поиске название категории и переходим по результату", () -> {
        newFlatsPage.openMainPage()
                    .redirectToSectionFromSearch("новостройки");
        });
        step("Проверяем отображение корректного заголовка и 'хлебных крошек'", () -> {
        newFlatsPage.checkPageTitle("новостройки")
                    .checkBreadcrumbs("новостройки");
        });

    }

    @Test
    @DisplayName("Проверка отображения новостроек для опреденного города")
    void successRegionChangingTest() {
        step("Открываем попап с выбором города и региона", () -> {
        newFlatsPage.openMainPage()
                    .navBarSection("Каталоги")
                    .redirectToSectionFromNavBar()
                    .openMap()
                    .checkMapTitle("Город или регион");
        });
        step("Выбираем город", () -> {
        newFlatsPage.clickOnMapSearch()
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
        newFlatsPage.openMainPage()
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
