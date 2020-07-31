package ru.job4j.test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("ad@yandex.ru", "ad Arsentev");
        map.put("df@yandex.ru", "df Arsentev");
        map.put("zx@yandex.ru", "zx Arsentev");

        Set<String> set = map.keySet();

        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }
    }
}
