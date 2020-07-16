package ru.job4j.oop;

public class Student {
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.sing();
        petya.sing();
        petya.sing();
    }

    private void sing() {
        System.out.println("I believe I can fly!");
    }

    private void music() {
        System.out.println("Tra ta ta!");
    }
}
