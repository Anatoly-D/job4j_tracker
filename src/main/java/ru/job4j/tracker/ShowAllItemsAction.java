package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {
    @Override
    public String name() {
        return "Show all Items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all Items ===");
        Item[] allItems = tracker.findAll();
        if (allItems.length > 0) {
            for (Item item : allItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are no Items in Tracker.\n");
        }
        return true;
    }
}
