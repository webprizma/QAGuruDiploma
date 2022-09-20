package web.enums;

public enum ShoesSubCategories {
    Kids("Детская", "Детская обувь");

    public final String menuItemTitle;
    public final String heading;


    ShoesSubCategories(String menuItemTitle, String heading) {
        this.menuItemTitle = menuItemTitle;
        this.heading = heading;
    }
}
