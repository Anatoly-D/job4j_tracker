package ru.job4j.tracker;

public class OutputAllAction implements UserAction{
    private final Output out;

    public OutputAllAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Tracker Items list";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            out.println(item.getId() + "\t" + item.getName());
        }
        return true;
    }
}
