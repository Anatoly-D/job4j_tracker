package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputId;
        inputId = input.askInt("Enter Item Id: ");
        if (tracker.delete(inputId)) {
            out.println("Item was deleted");
        } else {
            out.println("Something went wrong. Try again");
        }
        return true;
    }
}
