package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find Items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Items with the name: " + name + " weren't found.");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("The Item with id: " + id + " was not found.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        tracker.delete(id);
        Item item = tracker.findById(id);
        System.out.println(item == null ? "The Item was deleted." : "Item deletion error.");
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter Name of new Item: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Item was replaced.");
        } else {
            System.out.println("Item replacement error.");
        }
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all Items ===");
        Item[] allItems = tracker.findAll();
        if (allItems.length > 0) {
            for (Item item : allItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are no Items in Tracker.\n");
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter Name: ");
        Item newItem = new Item(name);
        tracker.add(newItem);
        System.out.println("New Item is created: " + newItem.getName());
    }

    public void showMenu() {
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}


