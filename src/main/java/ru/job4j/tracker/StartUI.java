package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        Item[] items;
        Item item;
        String name;
        int input;
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
                    break;
                case 1:
                    System.out.println("==== Tracker Items list ====");
                    outputItems(tracker.findAll());
                    break;
                case 2:
                    System.out.println();
                    System.out.println("==== Enter Item Id to Edit ====");
                    item = tracker.findById(scanner.nextInt());
                    if (item != null) {
                        System.out.print("Enter new name for Item with id " + item.getId() + System.lineSeparator());
                        if (tracker.replace(item.getId(), new Item(scanner.next()))) {
                            System.out.println("Item was replaced");
                        } else {
                            System.out.println("Something went wrong. Try again");
                        }
                    } else {
                        System.out.println(System.lineSeparator() + "Item with such id doesn't exist.");
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("==== Enter Item Id to Delete ====");
                    item = tracker.findById(scanner.nextInt());
                    if (item != null) {
                        if (tracker.delete(item.getId())) {
                            System.out.print("Item with id " + item.getId() + " was deleted" + System.lineSeparator());
                        } else {
                            System.out.println("Something went wrong. Try again");
                        }
                    } else {
                        System.out.println(System.lineSeparator() + "Item with such id doesn't exist.");
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.println("==== Enter Item Id to Search ====");
                    item = tracker.findById(scanner.nextInt());
                    if (item != null) {
                        System.out.print("Item with id " + item.getId() + " has name " + item.getName() + System.lineSeparator());
                    } else {
                        System.out.println("Item with such id doesn't exist.");
                    }
                    break;
                case 5:
                    System.out.println();
                    System.out.println("==== Enter Item Name to Search ====");
                    items = tracker.findByName(scanner.next());
                    if (items.length != 0) {
                        System.out.println("==== Items with name " + items[0].getName() + " ====");
                        outputItems(items);
                        System.out.println();
                    } else {
                        System.out.println("Item with such name doesn't exist.");
                    }
                    break;
                case 6:
                    run = false;
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Please choose correct menu item!");
            }
        }
    }

    private void outputItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item.getId() + "\t" + item.getName());
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program" + System.lineSeparator());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
