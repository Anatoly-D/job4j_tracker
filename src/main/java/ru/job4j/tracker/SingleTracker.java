package ru.job4j.tracker;

public class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }

    /* Остальные методы из класса Tracker. */
}
