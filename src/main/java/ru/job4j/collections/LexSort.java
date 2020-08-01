package ru.job4j.collections;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArr = left.split(" ");
        String[] rightArr = right.split(" ");
        leftArr = leftArr[0].split("\\.");
        rightArr = rightArr[0].split("\\.");

        int maxLength = leftArr.length >= rightArr.length ? leftArr.length : rightArr.length;
        int leftNumber;
        int rightNumber;

        for (int i = 0; i < maxLength; i++) {
            leftNumber = Integer.valueOf(leftArr[i]);
            rightNumber = Integer.valueOf(rightArr[i]);
            if (leftNumber != rightNumber) {
                return leftNumber - rightNumber;
            }
        }
        return 0;
    }
}