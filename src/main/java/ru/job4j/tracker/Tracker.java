package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items[index].setName(item.getName());
        return true;
    }

    public Item[] findByName(String key) {
        int i = 0;
        Item[] rsl = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            if (items[index] == null) {
                continue;
            }
            if (items[index].getName().equals(key)) {
                rsl[i++] = items[index];
            }
        }
        rsl = Arrays.copyOf(rsl, i);
        return rsl;
    }

    public Item[] findAll() {
        int i = 0;
        Item[] rsl = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            if (items[index] == null) {
                continue;
            }
            rsl[i++] = items[index];
        }
        rsl = Arrays.copyOf(rsl, i);
        return rsl;
    }
}