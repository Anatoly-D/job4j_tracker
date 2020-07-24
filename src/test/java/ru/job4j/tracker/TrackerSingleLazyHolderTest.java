package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleLazyHolderTest {
    @Test
    public void whenSingleEnum() {
        TrackerSingleLazyHolder tracker1 = TrackerSingleLazyHolder.getInstance();
        TrackerSingleLazyHolder tracker2 = TrackerSingleLazyHolder.getInstance();
        assertThat(tracker1, is(tracker2));
    }

}