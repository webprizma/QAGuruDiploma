package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    public SelenideElement addToCartButton = $(".order .btn-main"),
            goToCartButton = $(".j-go-to-basket");
}
