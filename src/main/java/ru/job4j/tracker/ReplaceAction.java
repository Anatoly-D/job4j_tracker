package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "==== Replace Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String inputName;
        int inputId;
        inputId = input.askInt("Enter Item Id: ");
        inputName = input.askStr("Enter Item Name: ");
        if (tracker.replace(inputId, new Item(inputId, inputName))) {
            System.out.println("Item was replaced");
        } else {
            System.out.println("Something went wrong. Try again");
        }
        return true;
    }
}
