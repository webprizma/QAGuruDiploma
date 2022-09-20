package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public SelenideElement burgerMenuButton = $("button.nav-element__burger"),
            searchInput = $("input.search-catalog__input"),
            countrySelector = $(".j-b-header-country"),
            citySelector = $(".header__address");

    public ElementsCollection countries = $$(".j-country-item");


    public void open() {
        Selenide.open("/");
    }
}
