package ru.job4j.tracker;

import java.util.Arrays;

public enum TrackerSingleEagerEnum {
    INSTANCE;
    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
