package ru.job4j.collections;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobDescByPriorityTest {
    @Test
    public void jobDescByPriority() {
        Comparator<Job> jobsComp = new JobDescByPriority();
        int result = jobsComp.compare(new Job("aaa", 3), new Job("bbb", 2));
        assertThat(result, is(-1));
    }

}