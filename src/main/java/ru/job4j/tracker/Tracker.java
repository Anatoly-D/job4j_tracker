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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String itemName) {
        Item[] resultItemList = new Item[size];
        int resultItemCounter = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) {
                resultItemList[resultItemCounter++] = items[i];
            }
        }
        return Arrays.copyOf(resultItemList, resultItemCounter);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = false;
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        int indexDeleted = indexOf(id);
        if (indexDeleted != -1) {
            items[indexDeleted] = null;
            size--;
            System.arraycopy(items, indexDeleted + 1, items, indexDeleted, size - indexDeleted);
            items[size + 1] = null;
            result = true;
        }
        return result;
    }
}