package tests.mtsJob;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.ItJobPage;
import tests.TestBase;
import utils.FakerTestData;

@Tags({
        @Tag("regress"),
        @Tag("city")
})
@DisplayName("Тестирование выбора города")
@Owner("Ефремова Анастасия")
@Epic("Функциональность главной страницы")
@Feature("Управление локацией")
public class CityTests extends TestBase {

    private final ItJobPage itJobPage = new ItJobPage();

    @BeforeEach
    void acceptCookies() {
        itJobPage.acceptCookies();
    }

    @Test
    @DisplayName("Проверка отображения баннера выбора города")
    @Story("Отображение баннера города")
    @Severity(SeverityLevel.CRITICAL)
    void shouldDisplayCityBannerTest() {
        itJobPage.verifyAllCityBannerElements();
    }

    @Test
    @DisplayName("Подтверждение города по умолчанию")
    @Story("Подтверждение города по умолчанию")
    @Severity(SeverityLevel.CRITICAL)
    void shouldAcceptDefaultCityMoscowTest() {
        itJobPage.acceptDefaultCity()
                .verifyCityInHeader("Москва");
    }

    @Test
    @DisplayName("Выбор города")
    @Story("Выбор альтернативного города")
    @Severity(SeverityLevel.NORMAL)
    void shouldChooseKazanCityTest() {
        itJobPage.chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }

    @Test
    @DisplayName("Выбор случайного города")
    @Story("Выбор альтернативного города")
    @Severity(SeverityLevel.NORMAL)
    void shouldChooseRandomCityTest() {
        String randomCity = FakerTestData.getRandomCity();
        itJobPage.chooseCity(randomCity)
                .verifyCityInHeader(randomCity);
    }

    @Test
    @DisplayName("Проверка кликабельности кнопок выбора города")
    @Story("Функциональность баннера города")
    @Severity(SeverityLevel.NORMAL)
    void shouldHaveClickableCityButtonsTest() {
        itJobPage.verifyCityButtonsClickable();
    }

    @Test
    @DisplayName("Проверка сохранения выбора города после перезагрузки")
    @Story("Сохранение выбора города")
    @Severity(SeverityLevel.NORMAL)
    void shouldRememberCityChoiceAfterRefreshTest() {
        itJobPage.chooseCity("Казань")
                .refreshPage()
                .verifyCityInHeader("Казань");
    }
}