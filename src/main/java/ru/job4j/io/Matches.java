package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matchQty = 11;
        int userInput;
        int currentUser = 0;
        int gamersQty = 2;
        System.out.println("Начинаем игру в спички!");

        while (matchQty > 0) {
            System.out.println("На столе " + matchQty + " спичек, игрок " + (currentUser % gamersQty + 1) + " возьмите от 1 до 3 спичек:");
            userInput = scanner.nextInt();
            if (checkInput(userInput)) {
                matchQty -= userInput;
                currentUser++;
            } else {
                System.out.println("Некорректный ввод. Введите число от 1 до 3!");
            }
        }
        System.out.println("Ура, игрок " + currentUser % gamersQty + " выиграл!");
    }

    private static boolean checkInput(int userInput) {
        return userInput == 1 || userInput == 2 || userInput == 3;
    }
}
