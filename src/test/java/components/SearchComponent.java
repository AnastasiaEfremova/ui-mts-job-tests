package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchComponent {

    private final SelenideElement searchField = $("#mainSearch");

    @Step("Проверить, что поле поиска отображается")
    public SearchComponent searchFieldShouldBeVisible() {
        searchField.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что поле поиска доступно для ввода")
    public void searchFieldShouldBeEnabled() {
        searchField.shouldBe(enabled);
    }

    @Step("Ввести поисковый запрос: {query}")
    public void setSearchQuery(String query) {
        searchField
                .shouldBe(visible, enabled)
                .setValue(query);
    }

    @Step("Нажать Enter для выполнения поиска")
    public SearchResultsPage pressEnter() {
        searchField.pressEnter();
        return new SearchResultsPage();
    }

    @Step("Выполнить поиск вакансии: {query}")
    public SearchResultsPage searchVacancy(String query) {
        setSearchQuery(query);
        return pressEnter();
    }
}