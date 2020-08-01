package ru.job4j.test;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Integer value;

        while (list.listIterator().hasNext()) {
            value = list.listIterator().next();
            System.out.print(value + " ");
            if (value == 5) {
                list.listIterator().remove();
            }
        }
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }
}
