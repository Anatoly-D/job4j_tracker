package ru.job4j.oop;

public class DummyDic {
    public static void main(String[] args) {
        DummyDic stupid = new DummyDic();
        System.out.println(stupid.engToRus("Sdsasd!"));
    }

    public String engToRus(String eng) {
        return "Неизвестное слово " + eng;
    }
}
