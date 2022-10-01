package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static io.qameta.allure.Allure.step;

@Tag("search")
@Tag("web")
public class SearchTests extends TestBase {
    @Epic("Wildberries web autotests")
    @Story("Search tests")
    @Feature("Basic search test")
    @ParameterizedTest
    @ValueSource(strings = {
            "Sony PlayStation 5"
    })
    void basicSearchTest(String searchPhrase) {
        step("Ввести поисковый запрос {0}", () ->
                mainPage.searchInput.setValue(searchPhrase).pressEnter());

        step("Должны быть результаты поиска", () ->
                searchPage.searchResultCards.shouldHave(sizeGreaterThan(0)));

        step("Должен быть товар с вхождением поискового запроса", () ->
                searchPage.searchResultCardsNames.shouldHave(itemWithText(searchPhrase)));
    }
}
