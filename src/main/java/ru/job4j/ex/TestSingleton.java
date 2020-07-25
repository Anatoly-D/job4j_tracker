package ru.job4j.ex;

public class TestSingleton {
    public static void main(String[] args) {
        TrackerSingleLazy trackerSingleLazy = TrackerSingleLazy.getInstance();
        TrackerSingleLazy trackerSingleLazy1 = TrackerSingleLazy.getInstance();
        System.out.println(trackerSingleLazy);
        System.out.println(trackerSingleLazy1);
    }
}
