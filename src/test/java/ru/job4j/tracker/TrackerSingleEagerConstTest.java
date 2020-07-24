package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleEagerConstTest {

    @Test
    public void whenSingleEagerConst() {
        TrackerSingleEagerConst tracker1 = TrackerSingleEagerConst.getInstance();
        TrackerSingleEagerConst tracker2 = TrackerSingleEagerConst.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}