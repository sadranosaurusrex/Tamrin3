package Models.Enums;


import View.*;

public enum Menu {
    LoginMenu(new LoginMenu()),
    RegisterMenu(new RegisterMenu()),
    ExitMenu(new ExitMenu()),
    MainMenu(new ExitMenu());

    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public AppMenu getMenu() {
        return menu;
    }
}
