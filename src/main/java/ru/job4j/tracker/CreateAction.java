package ru.job4j.tracker;

public class CreateAction implements UserAction {

    private final Output output;

    CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Create a new Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create a new Item ===");
        String name = input.askStr("Enter Name: ");
        Item newItem = new Item(name);
        tracker.add(newItem);
        output.println("New Item is created: " + newItem.getName());
        return true;
    }
}
