package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min - 1; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        return rsl == 0 ? Integer.compare(left.length(), right.length()) : rsl;
    }
}