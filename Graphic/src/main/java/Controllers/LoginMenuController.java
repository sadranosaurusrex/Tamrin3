package Controllers;

import Models.Enums.Menu;
import Models.Enums.MenuCommands.LoginMenuCommands;
import Models.Enums.MenuCommands.RegisterMenuCommands;
import Models.Player;
import Models.Result;
import Models.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

public class LoginMenuController {
    private final ArrayList<String> SecurityQuestions = new ArrayList<>(Arrays.asList(
            "What was the name of your first pet?",
            "What is the name of the street you grew up on?",
            "What is your favorite childhood video game?",
            "What was the name of your elementary school?",
            "What is the name of your best friend in childhood?"
    ));

    private boolean askSecurityQuestion = false;
    private boolean enterNewPassword = false;

    private Player targetPlayer;

    private void resetFields() {
        targetPlayer = null;
        askSecurityQuestion = false;
        enterNewPassword = false;
    }

    private String hashWithSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private boolean verifySHA256(String password, String expectedHash) {
        String calculatedHash = hashWithSHA256(password);
        return calculatedHash.equalsIgnoreCase(expectedHash);
    }

    //

    public Result Login(String username, String password, String stayLoggedIn) {
        username = username.trim();
        password = password.trim();
        stayLoggedIn = stayLoggedIn.trim();
        boolean stayLoggedInCheck = stayLoggedIn.equals("-stay logged in");

        File playerData = new File("Data/" + username + "/PlayerInfo.json");
//        if (!playerData.exists())
//            return new Result(false, "Username doesn't exist");

        Player targetPlayer = new Player();

        if (stayLoggedInCheck)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/AppData.txt"))) {
                writer.write(targetPlayer.getUsername());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        App.setCurrentPlayer(targetPlayer);
        App.setCurrentMenu(Menu.MainMenu);
        resetFields();

        return new Result(true, "Welcome " + targetPlayer.getNickname() + "!");
    }

    public Result exit() {

        // exit
        // boolean check mizarim age stay logged in true bood save beshe

        App.setCurrentMenu(Menu.ExitMenu);

        return new Result(true, "");
    }

    public Result switchMenu() {
        App.setCurrentMenu(Menu.RegisterMenu);
        resetFields();
        return new Result(true, "");
    }

    public Result forgetPassword(String username) {
        username = username.trim();
        Player targetPlayer = App.searchPlayer(username);
        if (targetPlayer == null)
            return new Result(false, "Username doesn't exist\n");
        enterNewPassword = false;
        askSecurityQuestion = true;
        this.targetPlayer = targetPlayer;
        System.out.println(SecurityQuestions.get(targetPlayer.getSecurityQuestion().charAt(0) - '0' - 1));
        return new Result(true, "");
    }

    public Result securityQuestion(String answer) {
        answer = answer.trim();
        Matcher matcher;
        if (!(matcher = LoginMenuCommands.answer.getMatcher(answer)).find())
            return new Result(false, "please enter with this form :\nanswer -a <answer>");
        String userAnswer = matcher.group(1);
        String correctAnswer = targetPlayer.getSecurityQuestion().substring(3);
        if (!userAnswer.equals(correctAnswer)) {
            resetFields();
            return new Result(false, "Incorrect answer");
        }
        askSecurityQuestion = false;
        enterNewPassword = true;
        return new Result(true, "Enter New Password:");
    }

    public Result enterNewPass(String newPass) {
        newPass = newPass.trim();
        if (!RegisterMenuCommands.PASSWORD_PATTERN.getMatcher(newPass).find())
            return new Result(false, "Please enter better password");
        if (verifySHA256(newPass, targetPlayer.getPassword()))
            return new Result(false, "Please enter new password");
        targetPlayer.setPassword(hashWithSHA256(newPass));
        resetFields();
        return new Result(true, "new password set");
    }

    public Result showCurrentMenu() {
        return new Result(true, App.getCurrentMenu().toString());
    }

    // getter

    public boolean isAskSecurityQuestion() {
        return askSecurityQuestion;
    }

    public boolean isEnterNewPassword() {
        return enterNewPassword;
    }
}
