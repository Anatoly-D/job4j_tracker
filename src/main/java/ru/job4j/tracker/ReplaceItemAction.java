package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    private final Output output;

    ReplaceItemAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Replace Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Replace Item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter Name of new Item: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            output.println("Item was replaced.");
        } else {
            output.println("Item replacement error.");
        }
        return true;
    }
}
