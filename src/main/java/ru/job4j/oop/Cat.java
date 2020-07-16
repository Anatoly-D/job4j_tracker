package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();

        String say = peppy.sound();
        System.out.println("Peppy says: " + say);

        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveName("Gav");
        System.out.println("What's a favorite Gav's food?");
        gav.show();

        Cat black = new Cat();
        black.eat("fish");
        black.giveName("Black");
        System.out.println("What's a favorite Black's food?");
        black.show();

    }

    private void giveName(String name) {
        this.name = name;
    }

    private void show() {
        System.out.println(this.name + " ate " + this.food);
    }

    private void eat(String favoriteFood) {
        this.food = favoriteFood;
    }

    private String sound() {
        String voice = "may-may";
        return voice;
    }
}
