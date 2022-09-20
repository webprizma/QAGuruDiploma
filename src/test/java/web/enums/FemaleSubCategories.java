package web.enums;

public enum FemaleSubCategories {
    Shirts("Блузки и рубашки", "Женские блузки и рубашки");

    public final String menuItemTitle;
    public final String heading;


    FemaleSubCategories(String menuItemTitle, String heading) {
        this.menuItemTitle = menuItemTitle;
        this.heading = heading;
    }
}
