package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CookieNoticeComponent {

    private final SelenideElement cookieContainer = $(".CookieNotice_cookieNotice__container__dNggg");
    private final SelenideElement acceptButton = $(byText("принять cookie"));
    private final SelenideElement configureButton = $(byText("настроить cookie"));

    @Step("Проверить, что баннер cookies отображается")
    public CookieNoticeComponent cookieBannerShouldBeVisible() {
        cookieContainer.shouldBe(visible);
        acceptButton.shouldBe(visible);
        configureButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что баннер cookies скрыт")
    public void cookieBannerShouldNotBeVisible() {
        cookieContainer.shouldNotBe(visible);
        acceptButton.shouldNotBe(visible);
    }

    @Step("Проверить кнопку 'принять cookie'")
    public CookieNoticeComponent acceptButtonShouldBeVisible() {
        acceptButton.shouldBe(visible, enabled);
        return this;
    }

    @Step("Проверить кнопку 'настроить cookie'")
    public CookieNoticeComponent configureButtonShouldBeVisible() {
        configureButton.shouldBe(visible, enabled);
        return this;
    }

    @Step("Проверить текст кнопок cookie баннера")
    public void shouldHaveButtonsText(String acceptText, String configureText) {
        acceptButton.shouldHave(text(acceptText));
        configureButton.shouldHave(text(configureText));
    }

    @Step("Нажать кнопку 'принять cookie'")
    public void clickAcceptCookies() {
        acceptButton.shouldBe(visible, enabled).click();
    }

    @Step("Нажать кнопку 'настроить cookie'")
    public void clickConfigureCookies() {
        configureButton.shouldBe(visible, enabled).click();
    }

    @Step("Принять cookies")
    public void acceptCookies() {
        cookieBannerShouldBeVisible()
                .acceptButtonShouldBeVisible()
                .clickAcceptCookies();
    }

    @Step("Настроить cookies")
    public void configureCookies() {
        cookieBannerShouldBeVisible()
                .configureButtonShouldBeVisible()
                .clickConfigureCookies();
    }

    @Step("Проверить все элементы cookie баннера")
    public void verifyAllCookieBannerElements() {
        cookieBannerShouldBeVisible()
                .acceptButtonShouldBeVisible()
                .configureButtonShouldBeVisible();
    }
}