package collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JobTest {

    @Test
    public void whenComparatorByNameAsc() {
        Job job1 = new Job("aaa", 10);
        Job job2 = new Job("ana", 5);
        Job job3 = new Job("afa", 7);
        List<Job> result = new ArrayList<>(List.of(job1, job2, job3));
        List<Job> expected = new ArrayList<>(List.of(job1, job3, job2));
        Collections.sort(result, new JobAscByName());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByNameDesc() {
        Job job1 = new Job("aaa", 10);
        Job job2 = new Job("ana", 5);
        Job job3 = new Job("afa", 7);
        List<Job> result = new ArrayList<>(List.of(job1, job2, job3));
        List<Job> expected = new ArrayList<>(List.of(job2, job3, job1));
        Collections.sort(result, new JobDescByName());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        Job job1 = new Job("aaa", 10);
        Job job2 = new Job("ana", 5);
        Job job3 = new Job("afa", 7);
        List<Job> result = new ArrayList<>(List.of(job1, job2, job3));
        List<Job> expected = new ArrayList<>(List.of(job2, job3, job1));
        Collections.sort(result, new JobAscByPriority());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Job job1 = new Job("aaa", 10);
        Job job2 = new Job("ana", 5);
        Job job3 = new Job("afa", 7);
        List<Job> result = new ArrayList<>(List.of(job1, job2, job3));
        List<Job> expected = new ArrayList<>(List.of(job1, job3, job2));
        Collections.sort(result, new JobDescByPriority());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenComparatorAscNameDescPrior() {
        Job job1 = new Job("aaa", 1);
        Job job2 = new Job("aba", 3);
        Job job3 = new Job("aba", 4);
        Job job4 = new Job("ada", 7);
        List<Job> result = new ArrayList<>(List.of(job4, job2, job1, job3));
        List<Job> expected = new ArrayList<>(List.of(job1, job3, job2, job4));
        Collections.sort(result, new JobAscByName().thenComparing(new JobDescByPriority()));
        assertThat(result).isEqualTo(expected);
    }
}