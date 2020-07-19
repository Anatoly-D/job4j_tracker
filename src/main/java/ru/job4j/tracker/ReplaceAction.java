package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String inputName;
        int inputId;
        inputId = input.askInt("Enter Item Id: ");
        inputName = input.askStr("Enter Item Name: ");
        if (tracker.replace(inputId, new Item(inputId, inputName))) {
            out.println("Item was replaced");
        } else {
            out.println("Something went wrong. Try again");
        }
        return true;
    }
}
