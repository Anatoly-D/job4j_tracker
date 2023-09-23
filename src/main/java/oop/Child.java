package oop;

public class Child extends Parent {

    public Child(String s) {
        System.out.println("Child not default constructor" + s);
    }

    public static void main(String[] args) {
        Child child = new Child("Hi");
        child = null;
    }
}
