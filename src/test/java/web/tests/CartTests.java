package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CartTests extends TestBase {
    @Epic("Wildberries web autotests")
    @Story("Cart tests")
    @Feature("Add to cart")
    @Tag("cart")
    @Tag("web")
    @ParameterizedTest
    @CsvSource(value = {
            "/catalog/64985433/detail.aspx, Полка для ванной на присосках без сверления настенная пластиковая навесная полочка для душа туалета"
    })
    void addToCartTest(String productUrl, String productName) {
        step("Открыть страницу товара", () ->
                open(productUrl));

        step("Нажать на кнопку 'Добавить в корзину'", () ->
                productPage.addToCartButton.click());

        step("Перейти в корзину", () ->
                productPage.goToCartButton.click());

        step("Товар должен быть в корзине", () ->
                cartPage.productsInCartNames
                        .shouldHave(itemWithText(productName)));
    }
}
