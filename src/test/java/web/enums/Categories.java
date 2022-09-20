package web.enums;

public enum Categories {
    Female("Женщинам", "Женщинам"),
    Shoes("Обувь", "Обувь"),
    Kids("Детям", "Детям"),
    Male("Мужчинам", "Мужчинам");

    public final String menuItemTitle;
    public final String heading;


    Categories(String menuItemTitle, String heading) {
        this.menuItemTitle = menuItemTitle;
        this.heading = heading;
    }
}
