package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {

    private final SelenideElement searchResultsContainer = $(".Vacancies_vacancies__result__loHaJ");

    private static final String ZERO_VACANCIES_TEXT = "0 вакансий";
    private static final String NO_VACANCIES_FOUND_TEXT = "По вашему запросу не найдены вакансии";

    @Step("Проверить, что контейнер результатов отображается")
    public void searchResultsShouldBeVisible() {
        searchResultsContainer.shouldBe(visible);
    }

    @Step("Проверить, что контейнер результатов не пустой")
    public void searchResultsShouldNotBeEmpty() {
        searchResultsContainer.shouldNotBe(empty);
    }

    @Step("Проверить, что найдены вакансии")
    public void verifyVacanciesFound() {
        searchResultsShouldBeVisible();
        searchResultsShouldNotBeEmpty();
    }

    @Step("Проверить, что вакансии не найдены")
    public void verifyNoVacanciesFound() {
        searchResultsShouldBeVisible();
        verifyZeroVacanciesCount();
        verifyNoResultsMessage();
    }

    @Step("Проверить, что количество вакансий равно 0")
    public void verifyZeroVacanciesCount() {
        searchResultsContainer.shouldHave(text(ZERO_VACANCIES_TEXT));
    }

    @Step("Проверить сообщение об отсутствии результатов")
    public void verifyNoResultsMessage() {
        searchResultsContainer.shouldHave(text(NO_VACANCIES_FOUND_TEXT));
    }

    @Step("Проверить отображение результатов поиска")
    public void verifySearchResultsVisible() {
        searchResultsShouldBeVisible();
    }
}