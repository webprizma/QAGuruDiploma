package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    public SelenideElement pageHeading = $("h1");

    public ElementsCollection filterTitles = $$(".filter__name");
}
