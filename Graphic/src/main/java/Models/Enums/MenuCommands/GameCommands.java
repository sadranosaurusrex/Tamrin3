package Models.Enums.MenuCommands;

import com.project.Models.Enums.Commands.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameCommands implements Commands {
    nextTurn("^\\s*next\\s+turn\\s*$"),
    walk("^\\s*walk\\s+\\s*([0-9]+)\\s*([0-9]+)\\s*\\s*$"),
    exitGame("^\\s*exit\\s*$"),
    time("^\\s*time\\s*$"),
    date("^\\s*date\\s*$"),
    dateTime("^\\s*datetime\\s*$"),
    day("^\\s*day\\s*$"),
    season("^\\s*season\\s*$"),
    weather("^\\s*weather\\s*$"),
    weatherForecast("^\\s*weather\\s+forecast\\s*$"),
    greenHouse("^\\s*greenhouse\\s+build\\s*$"),
    printMap("^\\s*print\\s+map\\s+(?<x>\\d+)\\s+(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*$"),
    helpMap("^\\s*help\\s+reading\\s+map\\s*$"),
    showEnergy("^\\s*energy\\s+show\\s*$"),
    setEnergy("^\\s*energy\\s+set\\s+-v\\s+(?<value>\\d+)\\s*$"),
    setUnlimitedEnergy("^\\s*energy\\s+unlimited\\s*$"),
    // cheat codes :
    increaseTime("^\\s*cheat\\s+time\\s+(?<time>\\d+)\\s*$"),
    increaseDate("^\\s*cheat\\s+date\\s+(?<date>\\d+)\\s*$"),
    changeWeather("^\\s*cheat\\s+weather\\s+set\\s+(?<Type>\\S+)\\s*$"),
    weathers("^(sunny|storm|rain|snow)$"),
    thor("^\\s*cheat\\s+Thor\\s+(?<x>\\d+)\\s+(?<y>\\d+)\\s*$"),
    // for debugging :
    gameInfo("^\\s*game\\s+info\\s*$"),
    printAllMap("^\\s*print\\s+map\\s*$");
    private final String pattern;

    GameCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        return Pattern.compile(pattern).matcher(input);
    }
}
