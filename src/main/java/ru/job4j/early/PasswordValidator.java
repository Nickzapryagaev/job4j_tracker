package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    private static final String[] FORBIDDEN_STR = new String[]{"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean upperCaseFound = false;
        boolean lowerCaseFound = false;
        boolean digitFound = false;
        boolean specialSymbolFound = false;
        for (char value : password.toCharArray()) {
            if (isUpperCase(value)) {
                upperCaseFound = true;
            }
            if (isLowerCase(value)) {
                lowerCaseFound = true;
            }
            if (isDigit(value)) {
                digitFound = true;
            }
            if (!isDigit(value) && !isLetter(value)) {
                specialSymbolFound = true;
            }
        }
        if (!upperCaseFound) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerCaseFound) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digitFound) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!specialSymbolFound) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        for (String val : FORBIDDEN_STR) {
            if (password.toLowerCase().contains(val)) {
                throw new IllegalArgumentException("Password shouldn't contain "
                        + "substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}