package Models.Enums.MenuCommands;

import com.project.Models.Enums.Commands.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuCommands implements Commands {
    login("^\\s*login\\s+-u\\s+(?<username>\\S*)\\s+-p\\s+(?<password>\\S*)" +
            "((\\s+-stay logged in)?)\\s*$"),
    switchMenu("^\\s*menu\\s+(?<menu>RegisterMenu|register|registermenu)\\s*$"),
    ShowCurrentMenu("^\\s*show\\s+current\\s+menu\\s*$"),
    exit("^\\s*exit\\s*$"),
    forgetPassword("^\\s*forget\\s+password\\s+-u\\s+(?<username>\\S*)\\s*$"),
    answer("^\\s*answer\\s+-a\\s+(?<answer>.*)$"),
    ;

    private final String pattern;

    LoginMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        return Pattern.compile(pattern).matcher(input);
    }
}
