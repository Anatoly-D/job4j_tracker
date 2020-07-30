package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items;
        String inputName;
        inputName = input.askStr("Enter Item Name: ");
        items = tracker.findByName(inputName);
        if ( items.size() != 0) {
            for (Item item : items) {
                out.println(item.getId() + "\t" + item.getName());
            }
        } else {
            out.println("Something went wrong. Try again");
        }
        return true;
    }
}
