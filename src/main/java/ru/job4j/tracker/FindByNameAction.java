package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Find item by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items;
        String inputName;
        inputName = input.askStr("Enter Item Name: ");
        items = tracker.findByName(inputName);
        if ( items.length != 0) {
            System.out.println("Items were found:");
            for (Item item : items) {
                System.out.println(item.getId() + "\t" + item.getName());
            }
        } else {
            System.out.println("Something went wrong. Try again");
        }
        return true;
    }
}
