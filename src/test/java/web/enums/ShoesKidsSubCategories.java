package web.enums;

public enum ShoesKidsSubCategories {
    Girls("Для девочек", "Обувь для девочек");

    public final String menuItemTitle;
    public final String heading;


    ShoesKidsSubCategories(String menuItemTitle, String heading) {
        this.menuItemTitle = menuItemTitle;
        this.heading = heading;
    }
}
