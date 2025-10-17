package tests.mtsJob;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ItJobPage;
import tests.TestBase;
import utils.FakerTestData;

@Tags({
        @Tag("regress"),
        @Tag("search")
})
@DisplayName("Тестирование поиска вакансий")
@Owner("Ефремова Анастасия")
@Epic("Функциональность главной страницы")
@Feature("Поиск вакансий")
public class SearchTests extends TestBase {

    private final ItJobPage itJobPage = new ItJobPage();

    @BeforeEach
    void acceptCookies() {
        itJobPage.acceptCookies();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Руководитель направления ANDROID",
            "Разработчик JAVA",
            "Инженер тестирования",
            "WEB-разработчик",
            "Системный аналитик"
    })
    @DisplayName("Успешный поиск вакансии")
    @Story("Успешный поиск вакансий")
    @Severity(SeverityLevel.CRITICAL)
    void successSearchVacationTest(String vacancy) {
        itJobPage.searchVacancy(vacancy)
                .verifyVacanciesFound();
    }

    @Test
    @DisplayName("Поиск случайной IT вакансии")
    @Story("Успешный поиск вакансий")
    @Severity(SeverityLevel.NORMAL)
    void searchRandomJobTest() {
        String randomJob = FakerTestData.getRandomJobTitle();
        itJobPage.searchVacancy(randomJob)
                .verifyVacanciesFound();
    }

    @Test
    @DisplayName("Поиск со значением null")
    @Story("Поиск несуществующих вакансий")
    @Severity(SeverityLevel.NORMAL)
    void noVacanciesFoundTest() {
        itJobPage.searchVacancy("null")
                .verifyNoVacanciesFound();
    }

    @Test
    @DisplayName("Поиск с очень длинным запросом")
    @Story("Обработка длинных поисковых запросов")
    @Severity(SeverityLevel.MINOR)
    void searchWithLongQueryTest() {
        String longQuery = "Очень длинный поисковый запрос который содержит много слов и должен быть обработан системой поиска вакансий";
        itJobPage.searchVacancy(longQuery)
                .verifySearchResultsVisible();
    }

    @Test
    @DisplayName("Проверка доступности поля поиска")
    @Story("Функциональность поиска")
    @Severity(SeverityLevel.NORMAL)
    void searchFieldShouldBeAvailableTest() {
        itJobPage.search()
                .searchFieldShouldBeVisible()
                .searchFieldShouldBeEnabled();
    }
}