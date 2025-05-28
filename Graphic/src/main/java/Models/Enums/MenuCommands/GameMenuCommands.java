package Models.Enums.MenuCommands;

import com.project.Models.Enums.Commands.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuCommands implements Commands {
    newGame("^\\s*new\\s+game\\s+-u\\s+(?<username1>\\S+)\\s+(?<username2>\\S+)\\s+(?<username3>\\S+)\\s*$"),
    selectMap("^\\s*game\\s+map\\s+(?<id>\\S+)\\s*$"),
    loadMap("^\\s*load\\s+game\\s*$"),
    exitGame("^\\s*exit\\s*$"),
    ;

    private final String pattern;

    GameMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        return Pattern.compile(pattern).matcher(input);
    }
}
