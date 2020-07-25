package ru.job4j.tracker;

public class CheckSingleton {
    public static void main(String[] args) {
        TrackerSingleEagerConst trackerSingleEagerConst = TrackerSingleEagerConst.getInstance();
        trackerSingleEagerConst.getTracker().add(new Item(("qwe")));

        TrackerSingleEagerEnum trackerSingleEagerEnum = TrackerSingleEagerEnum.INSTANCE;
        trackerSingleEagerEnum.getTracker().add(new Item("enum"));

        TrackerSingleLazyHolder trackerSingleLazyHolder = TrackerSingleLazyHolder.getInstance();
        trackerSingleLazyHolder.getTracker().add(new Item("holder"));

        TrackerSingleLazyStatic trackerSingleLazyStatic = TrackerSingleLazyStatic.getInstance();
        trackerSingleLazyStatic.getTracker().add(new Item("static"));
    }
}
