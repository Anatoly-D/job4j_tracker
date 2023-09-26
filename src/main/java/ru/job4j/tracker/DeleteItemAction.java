package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output output;

    DeleteItemAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        tracker.delete(id);
        Item item = tracker.findById(id);
        output.println(item == null ? "The Item was deleted." : "Item deletion error.");
        return true;
    }
}
