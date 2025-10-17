package tests.mtsJob;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.ItJobPage;
import tests.TestBase;

@Tags({
        @Tag("regress"),
        @Tag("cookie")
})
@DisplayName("Тестирование Cookie функциональности")
@Owner("Ефремова Анастасия")
@Epic("Функциональность главной страницы")
@Feature("Управление cookies")
public class CookieTests extends TestBase {

    private final ItJobPage itJobPage = new ItJobPage();

    @Test
    @DisplayName("cookie баннер и его компоненты отображаются корректно")
    @Story("Отображение cookie баннера")
    @Severity(SeverityLevel.CRITICAL)
    void shouldDisplayCookieBannerTest() {
        itJobPage.verifyAllCookieBannerElements();
    }

    @Test
    @DisplayName("Проверка текста кнопок cookie баннера")
    @Story("Валидация текста cookie баннера")
    @Severity(SeverityLevel.NORMAL)
    void shouldHaveCorrectCookieButtonsTextTest() {
        itJobPage.verifyCookieButtonsText();
    }

    @Test
    @DisplayName("Проверка кликабельности кнопок cookie")
    @Story("Функциональность cookie баннера")
    @Severity(SeverityLevel.NORMAL)
    void shouldHaveClickableCookieButtonsTest() {
        itJobPage.verifyCookieButtonsClickable();
    }

    @Test
    @DisplayName("Успешное принятие cookies")
    @Story("Принятие cookies")
    @Severity(SeverityLevel.CRITICAL)
    void shouldAcceptCookiesSuccessfullyTest() {
        itJobPage.acceptCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка возможности настроить cookies")
    @Story("Настройка cookies")
    @Severity(SeverityLevel.NORMAL)
    void shouldConfigureCookiesTest() {
        itJobPage.configureCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка поведения при повторном открытии страницы после принятия cookies")
    @Story("Сохранение состояния cookies")
    @Severity(SeverityLevel.NORMAL)
    void shouldNotShowCookieBannerAfterRefreshTest() {
        itJobPage.acceptCookies()
                .refreshPage()
                .verifyCookieBannerNotVisible();
    }
}