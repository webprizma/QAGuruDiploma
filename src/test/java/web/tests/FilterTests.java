package web.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

@Tag("filter")
@Tag("web")
public class FilterTests extends TestBase {
    @Epic("Wildberries web autotests")
    @Story("Filter tests")
    @Feature("Filter by category")
    @ParameterizedTest
    @CsvSource(value = {
            "Дом, Ванная, Аксессуары, Категория, Держатель для ванной, Держатель для ванной"
    })
    void filterByCategoryTest(String firstLevelCategory, String secondLevelCategory, String thirdLevelCategory,
                              String filterName, String filterCategory, String product) {
        step("Нажать на кнопку Бургер меню", () ->
                mainPage.burgerMenuButton.click());

        Allure.step("Навести курсор на раздел меню первого уровня {0}", () ->
                burgerMenu.mainListItemLinks.findBy(text(firstLevelCategory)).parent().hover());

        step("Кликнуть на раздел второго уровня {1}", () ->
                burgerMenu.firstLevelListItemLinks.findBy(text(secondLevelCategory)).click());

        step("Кликнуть на раздел третьего уровня {2}", () ->
                burgerMenu.secondLevelListItemLinks.findBy(text(thirdLevelCategory)).click());

        step("Кликнуть в фильтре {3} значение {4}", () ->
                catalogPage.filterTitles.findBy(text(filterName)).parent().sibling(0)
                        .$$(".filter__item").findBy(text(filterCategory)).click());

        Allure.step("Должен быть товар {5}", () ->
                searchPage.searchResultCardsNames.shouldHave(itemWithText(product)));
    }

    @Epic("Wildberries web autotests")
    @Story("Filter tests")
    @Feature("Filter by brand")
    @ParameterizedTest
    @CsvSource(value = {
            "Дом, Ванная, Аксессуары, Бренд, Сималенд, Сималенд"
    })
    void filterByBrandTest(String firstLevelCategory, String secondLevelCategory, String thirdLevelCategory,
                           String filterName, String filterBrand, String brand) {
        step("Открыть главную страницу", () ->
                mainPage.open());

        step("Нажать на кнопку Бургер меню", () ->
                mainPage.burgerMenuButton.click());

        Allure.step("Навести курсор на раздел меню первого уровня {0}", () ->
                burgerMenu.mainListItemLinks.findBy(text(firstLevelCategory)).parent().hover());

        step("Кликнуть на раздел второго уровня {1}", () ->
                burgerMenu.firstLevelListItemLinks.findBy(text(secondLevelCategory)).click());

        step("Кликнуть на раздел третьего уровня {2}", () ->
                burgerMenu.secondLevelListItemLinks.findBy(text(thirdLevelCategory)).click());

        step("Кликнуть в фильтре {3} значение {4}", () ->
                catalogPage.filterTitles.findBy(text(filterName)).parent().sibling(0)
                        .$$(".filter__item").findBy(text(filterBrand)).click());

        Allure.step("Должен быть товар {5}", () ->
                searchPage.searchResultCardsBrands.shouldHave(itemWithText(brand)));
    }
}
