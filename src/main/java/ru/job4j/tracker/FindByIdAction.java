package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output output;

    FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find Item by id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find Item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("The Item with id: " + id + " was not found.");
        }
        return true;
    }
}
