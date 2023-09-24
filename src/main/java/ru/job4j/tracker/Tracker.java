package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, items.length);
    }

    public Item[] findByName(String name) {
        Item[] result = new Item[items.length];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(name)) {
                result[counter++] = items[i];
            }
        }
        return Arrays.copyOf(result, counter);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items[index].getId());
            items[index] = item;
            result = true;
        }
        return result;
    }
}