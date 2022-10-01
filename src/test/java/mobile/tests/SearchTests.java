package mobile.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

@Tag("mobileSearch")
@Tag("mobile")
public class SearchTests extends TestBase {
    @Epic("Wildberries mobile autotests")
    @Story("Search tests")
    @Feature("Basic search test")
    @ParameterizedTest
    @CsvSource(value = {
            "Sony PlayStation"
    })
    void basicSearchTest(String searchPhrase) {
        step("Выбрать страну", () ->
                localeSelectScreen.localeSelectors.findBy(text("Россия")).click());

        step("Пропустить Onboarding", () ->
                localeSelectScreen.skipButton.click());

        step("Ввести поисковый запрос {0}", () -> {
            mainScreen.searchButton.click();
            mainScreen.searchInput.sendKeys(searchPhrase);
            mainScreen.searchResults.findBy(text(searchPhrase)).click();
        });

        step("Должны быть результаты поиска", () ->
                searchScreen.searchResultCards.shouldHave(sizeGreaterThan(0)));

        //todo не ищет по результатам
        step("Должен быть товар с вхождением поискового запроса {0}", () ->
                searchScreen.searchResultCardsNames.shouldHave(itemWithText(searchPhrase)));
    }
}
