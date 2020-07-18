package ru.job4j.pojo;

public class ProductContains {
    public static void main(String[] args) {
        Product first = new Product("Milk", 100);
        Product second = new Product("Milk", 100);
        System.out.println(first);
        System.out.println(second);

        boolean eq = first == second;
        System.out.println(eq);

        eq = first.equals(second);
        System.out.println(eq);
    }
}
