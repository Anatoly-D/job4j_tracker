package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "==== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputId;
        inputId = input.askInt("Enter Item Id: ");
        if (tracker.delete(inputId)) {
            System.out.println("Item was deleted");
        } else {
            System.out.println("Something went wrong. Try again");
        }
        return true;
    }
}
