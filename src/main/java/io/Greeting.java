package io;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(String.format("You entered this: \"%s\"", s));
    }
}
