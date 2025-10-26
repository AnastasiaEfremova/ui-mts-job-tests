package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import components.CityConfirmComponent;
import components.CookieNoticeComponent;
import components.SearchComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ItJobPage {

    private final CookieNoticeComponent cookieNoticeComponent = new CookieNoticeComponent();
    private final CityConfirmComponent cityConfirmComponent = new CityConfirmComponent();
    private final SearchComponent searchComponent = new SearchComponent();

    private final SelenideElement locationButton = $(".LocationButton_locationButton_text__UFX5G");
    private final static String ACCEPT_COOKIE_TEXT = "принять cookie";
    private final static String CONFIGURE_COOKIE_TEXT = "настроить cookie";

    @Step("Принять cookies")
    public ItJobPage acceptCookies() {
        cookieNoticeComponent.acceptCookies();
        return this;
    }

    @Step("Настроить cookies")
    public ItJobPage configureCookies() {
        cookieNoticeComponent.configureCookies();
        return this;
    }

    @Step("Проверить, что cookie баннер скрыт")
    public ItJobPage verifyCookieBannerNotVisible() {
        cookieNoticeComponent.cookieBannerShouldNotBeVisible();
        return this;
    }

    @Step("Проверить все элементы cookie баннера")
    public ItJobPage verifyAllCookieBannerElements() {
        cookieNoticeComponent.verifyAllCookieBannerElements();
        return this;
    }

    @Step("Проверить текст кнопок cookie баннера")
    public void verifyCookieButtonsText() {
        cookieNoticeComponent.shouldHaveButtonsText(ACCEPT_COOKIE_TEXT, CONFIGURE_COOKIE_TEXT);
    }

    @Step("Проверить кликабельность кнопок cookie")
    public void verifyCookieButtonsClickable() {
        cookieNoticeComponent.acceptButtonShouldBeVisible();
        cookieNoticeComponent.configureButtonShouldBeVisible();
    }

    @Step("Подтвердить город по умолчанию")
    public ItJobPage acceptDefaultCity() {
        cityConfirmComponent.acceptCityMoscow();
        return this;
    }

    @Step("Выбрать город: {cityName}")
    public ItJobPage chooseCity(String cityName) {
        cityConfirmComponent.chooseNewCity(cityName);
        return this;
    }

    @Step("Проверить все элементы баннера города")
    public ItJobPage verifyAllCityBannerElements() {
        cityConfirmComponent.verifyAllCityBannerElements();
        return this;
    }

    @Step("Проверить кликабельность кнопок выбора города")
    public void verifyCityButtonsClickable() {
        cityConfirmComponent.acceptCityButtonShouldBeVisible();
        cityConfirmComponent.chooseCityButtonShouldBeVisible();
    }

    @Step("Проверить отображение города в хедере: {expectedCity}")
    public void verifyCityInHeader(String expectedCity) {
        locationButton.shouldHave(text(expectedCity));
    }

    @Step("Выполнить поиск вакансии: {query}")
    public SearchResultsPage searchVacancy(String query) {
        return searchComponent.searchVacancy(query);
    }

    @Step("Обновить страницу")
    public ItJobPage refreshPage() {
        Selenide.refresh();
        return this;
    }

    @Step("Получить компонент поиска")
    public SearchComponent search() {
        return searchComponent;
    }
}