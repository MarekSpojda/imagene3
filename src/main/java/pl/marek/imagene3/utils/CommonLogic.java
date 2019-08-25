package pl.marek.imagene3.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonLogic {
    private static char[] FRAGMENTS = {
            'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I',
            'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R',
            's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z', '1', '2',
            '3', '4', '5', '6', '7', '8', '9', '0', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
            '-', '+', '<', '>', '*', '/'};

    public static String checkPassword(String password) throws Exception {
        String passwordRegex = "^.+\\d.+$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new Exception("Wrong password format.");
        }
        return password;
    }

    public static String makeUserId() {
        //Caution - so far it's not checking here if id is unique!
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            stringBuilder.append(FRAGMENTS[(int) (Math.random() * FRAGMENTS.length)]);
        }
        return stringBuilder.toString();
    }
}
