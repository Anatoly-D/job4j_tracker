package ru.job4j.test;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("ad@yandex.ru", "ad Arsentev");
        map.put("df@yandex.ru", "df Arsentev");
        map.put("zx@yandex.ru", "zx Arsentev");

        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(6);

        int[] ints = {1, 3, 4};
        List<int[]> ints1 = Arrays.asList(ints);
    }
}
