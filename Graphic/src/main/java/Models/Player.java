package Models;

import java.util.ArrayList;

public class Player{
    private int energyLimit = 200;
    private Integer Energy = 200;
    private Integer Coin = 1000;

    private String username;
    private String password;
    private String email;
    private String securityQuestion;

    private Integer level = 0;
    private Integer XP = 0;
    private Integer farmingXP = 1;
    private Integer miningXP = 1;
    private Integer sightseeingXP = 1;
    private Integer fishingXP = 1;

    private int x = 5;
    private int y = 84;

    public int getEnergyLimit() {
        return energyLimit;
    }

    public Player setEnergyLimit(int energyLimit) {
        this.energyLimit = energyLimit;
        return this;
    }

    public Integer getEnergy() {
        return Energy;
    }

    public Player setEnergy(Integer energy) {
        Energy = energy;
        return this;
    }

    public Integer getCoin() {
        return Coin;
    }

    public Player setCoin(Integer coin) {
        Coin = coin;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Player setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Player setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Player setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public Player setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Player setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getXP() {
        return XP;
    }

    public Player setXP(Integer XP) {
        this.XP = XP;
        return this;
    }

    public Integer getFarmingXP() {
        return farmingXP;
    }

    public Player setFarmingXP(Integer farmingXP) {
        this.farmingXP = farmingXP;
        return this;
    }

    public Integer getMiningXP() {
        return miningXP;
    }

    public Player setMiningXP(Integer miningXP) {
        this.miningXP = miningXP;
        return this;
    }

    public Integer getSightseeingXP() {
        return sightseeingXP;
    }

    public Player setSightseeingXP(Integer sightseeingXP) {
        this.sightseeingXP = sightseeingXP;
        return this;
    }

    public Integer getFishingXP() {
        return fishingXP;
    }

    public Player setFishingXP(Integer fishingXP) {
        this.fishingXP = fishingXP;
        return this;
    }

    public int getX() {
        return x;
    }

    public Player setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Player setY(int y) {
        this.y = y;
        return this;
    }

    public String getNickname() {
        return username;
    }
}
