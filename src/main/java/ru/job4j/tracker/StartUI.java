package ru.job4j.tracker;


import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                tracker.add(newItem);
                System.out.println("New Item is created: " + newItem.getName());
            } else if (select == 1) {
                System.out.println("=== Show all Items ===");
                Item[] allItems = tracker.findAll();
                if (allItems.length > 0) {
                    for (Item item : allItems) {
                        System.out.println(item);
                    }
                    System.out.println("");
                } else {
                    System.out.println("There are no Items in Tracker.\n");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };

        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}


