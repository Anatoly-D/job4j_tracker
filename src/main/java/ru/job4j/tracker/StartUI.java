package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        Item[] items;
        Item item;
        String inputName;
        int inputId;
        boolean run = true;
        while (run) {
            item = null;
            items = null;
            this.showMenu();
            System.out.print("Select: ");
            switch (scanner.nextInt()) {
                case 0:
                    System.out.println("==== Create a new Item ====");
                    System.out.print("Enter name: ");
                    item = new Item(scanner.next());
                    tracker.add(item);
                    System.out.println("New Item with id = " + item.getId() + " and name = \"" + item.getName() + "\" was added");
                    System.out.println();
                    break;
                case 1:
                    System.out.println("==== Tracker Items list ====");
                    outputItems(tracker.findAll());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("==== Edit Item ====");
                    System.out.println("Enter Item Id: ");
                    inputId = scanner.nextInt();
                    System.out.println("Enter Item Name: ");
                    inputName = scanner.next();
                    if (tracker.replace(item.getId(), new Item(inputId, inputName))) {
                        System.out.println("Item was replaced");
                    } else {
                        System.out.println("Something went wrong. Try again");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("==== Delete Item ====");
                    System.out.println("Enter Item Id: ");
                    inputId = scanner.nextInt();
                    if (tracker.delete(inputId)) {
                        System.out.println("Item was replaced");
                    } else {
                        System.out.println("Something went wrong. Try again");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("==== Find item by Id ====");
                    System.out.println("Enter Item Id: ");
                    inputId = scanner.nextInt();
                    item = tracker.findById(inputId);
                    if ( item != null) {
                        System.out.println("Item was found: id = " + inputId + " name = \"" + item.getName() + "\"");
                    } else {
                        System.out.println("Something went wrong. Try again");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("==== Find item by Name ====");
                    System.out.println("Enter Item Name: ");
                    inputName = scanner.next();
                    items = tracker.findByName(inputName);
                    if ( items.length != 0) {
                        System.out.println("Items were found:");
                        outputItems(items);
                    } else {
                        System.out.println("Something went wrong. Try again");
                    }
                    System.out.println();
                    break;
                case 6:
                    run = false;
                    System.out.println("Exit!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Please choose correct menu item!");
                    System.out.println();
            }
        }
    }

    private void outputItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item.getId() + "\t" + item.getName());
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
