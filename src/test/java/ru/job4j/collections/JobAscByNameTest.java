package ru.job4j.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobAscByNameTest {
    @Test
    public void jobAscByName() {
        Comparator<Job> jobsComp = new JobAscByName();
        int result = jobsComp.compare(new Job("aaa", 3), new Job("bbb", 2));
        assertThat(result, is(-1));
    }

    @Test
    public void jobAscByNameDescPriority() {
        Comparator<Job> jobsComp = new JobAscByName().thenComparing(new JobDescByPriority());
        int result = jobsComp.compare(new Job("aaa", 3), new Job("aaa", 2));
        assertThat(result, is(-1));
    }

}