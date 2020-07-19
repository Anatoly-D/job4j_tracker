package ru.job4j.tracker;

public class OutputAllAction implements UserAction{
    @Override
    public String name() {
        return "==== Tracker Items list ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.getId() + "\t" + item.getName());
        }
        return true;
    }
}
