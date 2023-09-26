package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "Replace Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace Item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter Name of new Item: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Item was replaced.");
        } else {
            System.out.println("Item replacement error.");
        }
        return true;
    }
}
