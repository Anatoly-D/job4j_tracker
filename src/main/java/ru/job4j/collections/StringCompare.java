package ru.job4j.collections;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        int compareRsl;

        for (int i = 0; i < minLength; i++) {
            compareRsl = Character.compare(left.charAt(i), right.charAt(i));
            if (compareRsl != 0) {
                return compareRsl;
            }
        }

        return left.length() - right.length();
    }
}
