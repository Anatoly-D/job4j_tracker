package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ItemAscByNameTest {

    @Test
    public void whenItemsSortedAscByName() {
        Item item1 = new Item("aam");
        Item item2 = new Item("aaf");
        Item item3 = new Item("aaz");
        List<Item> result = new ArrayList<>(List.of(item1, item2, item3));
        List<Item> expected = new ArrayList<>(List.of(item2, item1, item3));
        Collections.sort(result, new ItemAscByName());
        assertThat(result).isEqualTo(expected);
    }
}