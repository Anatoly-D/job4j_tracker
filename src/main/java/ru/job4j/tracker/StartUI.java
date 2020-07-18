package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker miniJira = new Tracker();
        miniJira.add(new Item(1, "Fix that issue."));
        System.out.println(miniJira.findById(1).getName());
    }
}
