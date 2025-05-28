package Models.Enums.MenuCommands;

import com.project.Models.Enums.Commands.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainMenuCommands implements Commands {
    logout("^\\s*logout\\s*$"),
    switchMenu("^\\s*menu\\s+(?<menu>gamemenu|profilemenu|game|profile)\\s*$"),
    ShowCurrentMenu("^\\s*show\\s+current\\s+menu\\s*$"),
    exit("^\\s*exit\\s*$"),
    craftingMenu("^\\s*crafting\\s+menu\\s*$"),
    foragingMenu("^\\s*foraging\\s+menu\\s*$"),
    toolsMenu("^\\s*tools\\s+menu\\s*$"),
    cheatingMenu("^\\s*cheating\\s+menu\\s*$"),
    cookingMenu("^\\s*cooking\\s+menu\\s*$"),
    ;

    private final String pattern;

    MainMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        return Pattern.compile(pattern).matcher(input);
    }
}
