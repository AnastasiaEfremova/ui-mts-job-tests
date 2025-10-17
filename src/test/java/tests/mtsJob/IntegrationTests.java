package tests.mtsJob;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.ItJobPage;
import tests.TestBase;

@Tags({
        @Tag("regress"),
        @Tag("integration")
})
@DisplayName("Интеграционные тесты главной страницы")
@Owner("Ефремова Анастасия")
@Epic("Функциональность главной страницы")
@Feature("Интеграционные сценарии")
public class IntegrationTests extends TestBase {

    private final ItJobPage itJobPage = new ItJobPage();

    @Test
    @DisplayName("Принятие cookies и подтверждение города по дефолту")
    @Story("Полный поток работы с интерфейсом")
    @Severity(SeverityLevel.BLOCKER)
    void fullFlowCookiesAndCityTest() {
        itJobPage.verifyAllCookieBannerElements()
                .acceptCookies()
                .verifyCookieBannerNotVisible()
                .verifyAllCityBannerElements()
                .acceptDefaultCity()
                .verifyCityInHeader("Москва");
    }

    @Test
    @DisplayName("Проверка возможности настроить cookies + выбор другого города")
    @Story("Альтернативный поток работы")
    @Severity(SeverityLevel.NORMAL)
    void configureCookiesAndChooseCityTest() {
        itJobPage.configureCookies()
                .verifyCookieBannerNotVisible()
                .chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }
}