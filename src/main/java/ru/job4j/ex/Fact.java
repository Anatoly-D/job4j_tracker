package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(calc(5));
        System.out.println(calc(-1));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n < 0 Please enter corrent n");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
