package ru.job4j.ex;

import ru.job4j.tracker.Item;

public enum TrackerSingle {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle trackerSingle = TrackerSingle.INSTANCE;

        TrackerSingle trackerSingle1 = TrackerSingle.INSTANCE;
    }
}
