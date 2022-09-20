package web.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import web.components.BurgerMenu;
import web.pages.*;

import static io.qameta.allure.Allure.step;

public class TestBase {
    MainPage mainPage = new MainPage();
    BurgerMenu burgerMenu = new BurgerMenu();
    CatalogPage catalogPage = new CatalogPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @BeforeEach
    void beforeEach() {
        step("Открыть главную страницу", () ->
                mainPage.open());
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.wildberries.ru";
    }
}
