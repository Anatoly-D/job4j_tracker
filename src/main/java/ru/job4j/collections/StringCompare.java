package ru.job4j.collections;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLength = left.length() < right.length() ? left.length() : right.length();
        char leftChar;
        char rightChar;

        for (int i = 0; i < minLength; i++) {
            leftChar = left.charAt(i);
            rightChar = right.charAt(i);
            if (leftChar != rightChar) {
                return leftChar - rightChar;
            }
        }

        return left.length() - right.length();
    }
}
