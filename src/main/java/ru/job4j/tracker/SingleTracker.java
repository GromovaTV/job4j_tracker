package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class SingleTracker {
    private static Tracker tracker = null;
    /* реализовать singleton */

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }
    /* Остальные методы из класса Tracker. */

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }
}
