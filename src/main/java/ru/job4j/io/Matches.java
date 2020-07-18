package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matchQty = 11;
        boolean run = true;
        System.out.println("Начинаем игру в спички!");

        while (matchQty > 0) {
            System.out.println("На столе " + matchQty + " спичек, возьмите от 1 до 3 спичек:");
            switch (scanner.nextInt()) {
                case 1:
                    matchQty -= 1;
                    break;
                case 2:
                    matchQty -= 2;
                    break;
                case 3:
                    matchQty -= 3;
                    break;
                default:
                    System.out.println("Некорректный ввод. Введите число от 1 до 3!");
            }
        }
        System.out.println("Ура, вы выиграли!3");

    }
}
