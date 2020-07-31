package ru.job4j.collections;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("ivanov@yandex.ru", "Petr Ivanov");
        map.put("petrov@yandex.ru", "Petr Petrov");
        map.put("sidorov@yandex.ru", "Petr Sidorov");

        for (Map.Entry<String, String> record : map.entrySet()) {
            System.out.println(record.getKey() + "\t\t" + record.getValue());
        }

        System.out.println("With key loop:");
        for (String s : map.keySet()) {
            System.out.println(s + "\t\t" + map.get(s));
        }
    }
}
