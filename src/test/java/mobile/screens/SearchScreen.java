package mobile.screens;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$$;

public class SearchScreen {
    public ElementsCollection searchResultCards = $$(AppiumBy.id("com.wildberries.ru:id/catalogContainer")),
            searchResultCardsNames = $$(AppiumBy.id("com.wildberries.ru:id/nameTitle"));
}
