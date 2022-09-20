package mobile.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocaleSelectScreen {
    public ElementsCollection localeSelectors = $$(AppiumBy.id("com.wildberries.ru:id/country_text"));

    public SelenideElement skipButton = $(AppiumBy.xpath("//android.widget.Button"));
}
