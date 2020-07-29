package ru.job4j.test;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
