package controller;

import java.util.regex.Pattern;

public class Validation {

    public static boolean isEmail(String emailAddress)
    {
        return patternMatches(emailAddress, "^(.+)@(\\S+)$");
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean doesNotExceedCharLength(String str, int length)
    {
        if (str.length() > length)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean betweenLength(String str, int min, int max)
    {
        if (str.length() >= min && str.length() <= max)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean notEmpty (String str) {
        return !str.trim().equals("");
    }
}
