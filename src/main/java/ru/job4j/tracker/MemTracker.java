package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {

    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {
        items = new ArrayList<>();
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index) == null) {
                continue;
            }
            if (items.get(index).getName().equals(key)) {
                rsl.add(items.get(index));
            }
        }
        return rsl;
    }

    public void findAll(Observe<Item> observe) {
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index) == null) {
                continue;
            }
            observe.receive(items.get(index));
        }
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException();
    }
}