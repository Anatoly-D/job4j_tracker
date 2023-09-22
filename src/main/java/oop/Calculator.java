package oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(15));
        System.out.println(Calculator.minus(15));

        Calculator calculator = new Calculator();

        System.out.println(calculator.divide(15));
        System.out.println(calculator.multiply(15));
        System.out.println(calculator.sumAllOperation(15));
    }
}
