package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingleEagerConst {
    private static final TrackerSingleEagerConst INSTANCE = new TrackerSingleEagerConst();
    private Tracker tracker = new Tracker();

    private TrackerSingleEagerConst() {
    }

    public static TrackerSingleEagerConst getInstance() {
        return INSTANCE;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
