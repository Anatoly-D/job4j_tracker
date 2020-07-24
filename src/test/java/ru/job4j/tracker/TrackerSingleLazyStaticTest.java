package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleLazyStaticTest {

    @Test
    public void whenSingleLazyStatic() {
        TrackerSingleLazyStatic tracker1 = TrackerSingleLazyStatic.getInstance();
        TrackerSingleLazyStatic tracker2 = TrackerSingleLazyStatic.getInstance();
        assertThat(tracker1, is(tracker2));
    }

}