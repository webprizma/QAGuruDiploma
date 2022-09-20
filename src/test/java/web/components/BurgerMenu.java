package web.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BurgerMenu {
    public SelenideElement activeBurgerMenu = $(".menu-burger--active");

    public ElementsCollection mainListItemLinks = $$(".menu-burger__main-list-link"),
            firstLevelListItemLinks = $$(".menu-burger__drop-list-item--active .menu-burger__item"),
            secondLevelListItemLinks = $$(".menu-burger__second--active .menu-burger__item");
}
