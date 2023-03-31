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

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
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