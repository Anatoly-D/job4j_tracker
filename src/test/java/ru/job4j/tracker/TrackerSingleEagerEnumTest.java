package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleEagerEnumTest {

    @Test
    public void whenSingleEnum() {
        TrackerSingleEagerEnum tracker1 = TrackerSingleEagerEnum.INSTANCE;
        TrackerSingleEagerEnum tracker2 = TrackerSingleEagerEnum.INSTANCE;
        assertThat(tracker1, is(tracker2));
    }

}