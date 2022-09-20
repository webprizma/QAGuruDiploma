package web.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    public ElementsCollection searchResultCards = $$(".product-card"),
            searchResultCardsNames = $$(".goods-name"),
            searchResultCardsBrands = $$(".brand-name");
}
