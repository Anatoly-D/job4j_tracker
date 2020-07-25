package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingleLazyHolder {
    private Tracker tracker = new Tracker();

    private TrackerSingleLazyHolder() {
    }

    public static TrackerSingleLazyHolder getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleLazyHolder INSTANCE = new TrackerSingleLazyHolder();
    }

    public Tracker getTracker() {
        return tracker;
    }
}
