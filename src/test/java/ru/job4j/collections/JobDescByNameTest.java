package ru.job4j.collections;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobDescByNameTest {
    @Test
    public void jobDescByName() {
        Comparator<Job> jobsComp = new JobDescByName();
        int result = jobsComp.compare(new Job("aaa", 3), new Job("bbb", 2));
        assertThat(result, is(1));
    }
}