package ru.job4j.tracker;

import java.util.List;

public class ShowAllItemsAction implements UserAction {

    private final Output output;

    ShowAllItemsAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all Items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show all Items ===");
        List<Item> itemList = tracker.findAll();
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                output.println(item);
            }
        } else {
            output.println("There are no Items in Tracker.\n");
        }
        return true;
    }
}
