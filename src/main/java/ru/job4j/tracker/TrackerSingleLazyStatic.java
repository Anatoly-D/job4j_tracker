package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingleLazyStatic {
    private static TrackerSingleLazyStatic instance;
    private Tracker tracker = new Tracker();

    private TrackerSingleLazyStatic() {
    }

    public static TrackerSingleLazyStatic getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyStatic();
        }
        return instance;
    }

    public Tracker getTracker() {
        return tracker;
    }
}

