package ru.job4j.oop;

public class Battery {
    private int capacity;

    public Battery(int capacity) {
        this.capacity = capacity;
    }

    public void exchange(Battery another) {
        another.capacity += this.capacity;
        this.capacity = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(12);

        System.out.println("Initial state. First: " + first.capacity
                + " Second: " + second.capacity);
        first.exchange(second);
        System.out.println("After exchange. First: " + first.capacity
                + " Second: " + second.capacity);
    }
}
