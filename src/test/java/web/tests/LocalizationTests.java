package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class LocalizationTests extends TestBase {
    @Epic("Wildberries web autotests")
    @Story("Localization tests")
    @Feature("Change country")
    @Tag("locale")
    @Tag("web")
    @ParameterizedTest
    @CsvSource(value = {
            "Армения, Ереван",
            "Казахстан, Нур-Султан",
            "Киргизия, Бишкек"
    })
    void changeLocaleTest(String country, String city) {
        step("Навести курсор на выбор страны", () ->
                mainPage.countrySelector.hover());

        step("Кликнуть на страну {0} ", () ->
                mainPage.countries.findBy(text(country)).click());

        step("Должен быть выбран город {1} ", () ->
                mainPage.citySelector.shouldHave(text(city)));
    }
}
