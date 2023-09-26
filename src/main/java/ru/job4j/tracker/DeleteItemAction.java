package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        tracker.delete(id);
        Item item = tracker.findById(id);
        System.out.println(item == null ? "The Item was deleted." : "Item deletion error.");
        return true;
    }
}
