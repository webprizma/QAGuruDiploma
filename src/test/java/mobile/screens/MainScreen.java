package mobile.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainScreen {
    public SelenideElement searchButton = $(AppiumBy.id("com.wildberries.ru:id/search_searchEditText")),
            searchInput = $(AppiumBy.xpath("//android.widget.EditText"));

    public ElementsCollection searchResults = $$(AppiumBy.xpath("//android.widget.TextView"));

}
