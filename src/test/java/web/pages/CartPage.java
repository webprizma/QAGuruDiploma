package web.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public ElementsCollection productsInCartNames = $$(".good-info__good-name");
}
