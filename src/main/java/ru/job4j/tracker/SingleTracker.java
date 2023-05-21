package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static Store tracker = null;
    /* реализовать singleton */

    private SingleTracker() {
    }

    public static Store getInstance() {
        if (tracker == null) {
            tracker = new MemTracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }
    /* Остальные методы из класса MemTracker. */

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
