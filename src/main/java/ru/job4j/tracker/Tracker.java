package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String name) {
        List<Item> resultList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    private int indexOf(int id) {
        int result = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                result = items.indexOf(item);
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items.get(index).getId());
            items.set(index, item);
            result = true;
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }
}