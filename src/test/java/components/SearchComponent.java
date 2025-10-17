package components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchComponent {

    private final SelenideElement searchField = $("#mainSearch");
    private final SelenideElement searchResultsContainer = $(".Vacancies_vacancies__result__loHaJ");

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
    public SearchComponent setSearchQuery(String query) {
        searchField
                .shouldBe(visible, enabled)
                .setValue(query);
        return this;
    }

    @Step("Нажать Enter для выполнения поиска")
    public void pressEnter() {
        searchField.pressEnter();
    }

    @Step("Выполнить поиск вакансии: {query}")
    public void searchVacancy(String query) {
        setSearchQuery(query)
                .pressEnter();
    }

    @Step("Проверить, что контейнер результатов отображается")
    public SearchComponent searchResultsShouldBeVisible() {
        searchResultsContainer.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что контейнер результатов не пустой")
    public void searchResultsShouldNotBeEmpty() {
        searchResultsContainer.shouldNotBe(empty);
    }

    @Step("Проверить, что найдены вакансии")
    public void verifyVacanciesFound() {
        searchResultsShouldBeVisible()
                .searchResultsShouldNotBeEmpty();
    }

    @Step("Проверить, что вакансии не найдены")
    public void verifyNoVacanciesFound() {
        searchResultsContainer
                .shouldBe(visible)
                .shouldHave(text("0 вакансий"))
                .shouldHave(text("По вашему запросу не найдены вакансии"));
    }

    @Step("Очистить поле поиска")
    public void clearSearchField() {
        searchField.clear();
    }
}