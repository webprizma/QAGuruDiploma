package web.tests;

import web.enums.Categories;
import web.enums.FemaleSubCategories;
import web.enums.ShoesKidsSubCategories;
import web.enums.ShoesSubCategories;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class MenuTests extends TestBase {
    @Epic("Wildberries web autotests")
    @Story("Menu tests")
    @Feature("Basic menu test")
    @Tag("menu")
    @Tag("ui")
    @Test
    void openMenuTest() {
        step("Открыть главную страницу", () ->
                mainPage.open());

        step("Нажать на кнопку Бургер меню", () ->
                mainPage.burgerMenuButton.click());

        step("Должно открыться бургер меню", () ->
                burgerMenu.activeBurgerMenu.shouldBe(visible));
    }

    @Epic("Wildberries web autotests")
    @Story("Menu tests")
    @Feature("First level menu test")
    @Tag("menu")
    @Tag("ui")
    @ParameterizedTest
    @EnumSource(Categories.class)
    void openFirstLevelCategoryTest(Categories category) {
        step("Открыть главную страницу", () ->
                mainPage.open());

        step("Нажать на кнопку Бургер меню", () ->
                mainPage.burgerMenuButton.click());

        step("Нажать на раздел меню первого уровня {0}", () ->
                burgerMenu.mainListItemLinks.findBy(text(category.menuItemTitle)).parent().click());

        step("Должна открыться страница с заголовком {0}", () ->
                catalogPage.pageHeading.shouldHave(text(category.heading)));
    }

    @Epic("Wildberries web autotests")
    @Story("Menu tests")
    @Feature("Second level menu test")
    @Tag("menu")
    @Tag("web")
    @Test
    void openSecondLevelCategoryTest() {
        step("Нажать на кнопку Бургер меню", () ->
                mainPage.burgerMenuButton.click());

        step("Навести курсор на раздел первого уровня 'Женщинам'", () ->
                burgerMenu.mainListItemLinks.findBy(text(Categories.Female.menuItemTitle)).hover());

        step("Кликнуть на раздел второго уровня 'Блузки и рубашки'", () ->
                burgerMenu.firstLevelListItemLinks.findBy(text(FemaleSubCategories.Shirts.menuItemTitle)).click());

        step("Должна открыться страница с заголовком 'Женские блузки и рубашки'", () ->
                catalogPage.pageHeading.shouldHave(exactText(FemaleSubCategories.Shirts.heading)));
    }

    @Epic("Wildberries web autotests")
    @Story("Menu tests")
    @Feature("Third level menu test")
    @Tag("menu")
    @Tag("ui")
    @Test
    void openThirdLevelCategoryTest() {
        step("Открыть главную страницу", () ->
                mainPage.open());

        step("Нажать на кнопку Бургер меню", () ->
                mainPage.burgerMenuButton.click());

        step("Навести курсор на раздел первого уровня 'Обувь'", () ->
                burgerMenu.mainListItemLinks.findBy(text(Categories.Shoes.menuItemTitle)).parent().hover());

        step("Кликнуть на раздел второго уровня 'Детская'", () ->
                burgerMenu.firstLevelListItemLinks.findBy(text(ShoesSubCategories.Kids.menuItemTitle)).click());

        step("Кликнуть на раздел третьего уровня 'Для девочек'", () ->
                burgerMenu.secondLevelListItemLinks.findBy(text(ShoesKidsSubCategories.Girls.menuItemTitle)).click());

        step("Должна открыться страница с заголовком 'Обувь для девочек'", () ->
                catalogPage.pageHeading.shouldHave(exactText(ShoesKidsSubCategories.Girls.heading)));
    }
}
