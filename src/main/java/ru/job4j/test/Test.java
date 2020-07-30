package ru.job4j.test;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> strings = List.of("first", "second", "third");
        
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
