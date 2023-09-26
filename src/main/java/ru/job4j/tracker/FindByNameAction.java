package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find Items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
