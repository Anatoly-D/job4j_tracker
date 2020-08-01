package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortByIdAsc() {
        List<Item> items = Arrays.asList(new Item(3, "third"),
                new Item(2, "second"),
                new Item(5, "fifth"),
                new Item(1, "first"));

        List<Item> itemsExpected = Arrays.asList(new Item(1, "first"),
                new Item(2, "second"),
                new Item(3, "third"),
                new Item(5, "fifth")
                );

        Collections.sort(items);
        assertThat(items, is(itemsExpected));

    }
}