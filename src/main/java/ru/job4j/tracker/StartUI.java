package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        Item item;
        System.out.println("==== Create a new Item ====");
        item = new Item(input.askStr("Enter name: "));
        tracker.add(item);
        System.out.println("New Item with id = " + item.getId() + " and name = \"" + item.getName() + "\" was added");
        System.out.println();
    }
    public static void outputAllItems(Input input, Tracker tracker) {
        System.out.println("==== Tracker Items list ====");
        outputItems(tracker.findAll());
        System.out.println();
    }
    public static void editItem(Input input, Tracker tracker) {
        String inputName;
        int inputId;
        System.out.println("==== Edit Item ====");
        inputId = input.askInt("Enter Item Id: ");
        inputName = input.askStr("Enter Item Name: ");
        if (tracker.replace(inputId, new Item(inputId, inputName))) {
            System.out.println("Item was replaced");
        } else {
            System.out.println("Something went wrong. Try again");
        }
        System.out.println();
    }
    public static void deleteItem(Input input, Tracker tracker) {
        int inputId;
        System.out.println("==== Delete Item ====");
        inputId = input.askInt("Enter Item Id: ");
        if (tracker.delete(inputId)) {
            System.out.println("Item was deleted");
        } else {
            System.out.println("Something went wrong. Try again");
        }
        System.out.println();
    }
    public static void findItemById(Input input, Tracker tracker) {
        Item item;
        int inputId;
        System.out.println("==== Find item by Id ====");
        inputId = input.askInt("Enter Item Id: ");
        item = tracker.findById(inputId);
        if ( item != null) {
            System.out.println("Item was found: id = " + inputId + " name = \"" + item.getName() + "\"");
        } else {
            System.out.println("Something went wrong. Try again");
        }
        System.out.println();
    }
    public static void findItemByName(Input input, Tracker tracker) {
        Item[] items;
        String inputName;
        System.out.println("==== Find item by Name ====");
        inputName = input.askStr("Enter Item Name: ");
        items = tracker.findByName(inputName);
        if ( items.length != 0) {
            System.out.println("Items were found:");
            outputItems(items);
        } else {
            System.out.println("Something went wrong. Try again");
        }
        System.out.println();
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            switch (input.askInt("Select: ")) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.outputAllItems(input, tracker);
                    break;
                case 2:
                    StartUI.editItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findItemById(input, tracker);
                    break;
                case 5:
                    StartUI.findItemByName(input, tracker);
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

    private static void outputItems(Item[] items) {
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
