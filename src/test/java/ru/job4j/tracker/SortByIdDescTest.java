package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByIdDescTest {

    @Test
    public void sortByIdDesc() {
        List<Item> items = Arrays.asList(new Item(3, "third"),
                new Item(2, "second"),
                new Item(5, "fifth"),
                new Item(1, "first"));

        List<Item> itemsExpected = Arrays.asList(new Item(5, "fifth"),
                new Item(3, "third"),
                new Item(2, "second"),
                new Item(1, "first"));

        Collections.sort(items, new SortByIdDesc());
        assertThat(items, is(itemsExpected));
    }
}