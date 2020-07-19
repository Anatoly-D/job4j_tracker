package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "==== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item;
        int inputId;
        inputId = input.askInt("Enter Item Id: ");
        item = tracker.findById(inputId);
        if ( item != null) {
            System.out.println("Item was found: id = " + inputId + " name = \"" + item.getName() + "\"");
        } else {
            System.out.println("Something went wrong. Try again");
        }
        return true;
    }
}
