package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HbmTrackerTest {

    @Test
    public void findById() {
        HbmTracker hbt = new HbmTracker();
        hbt.init();
        Item item = new Item(1, "name");
        hbt.add(item);
        Item res = hbt.findById(1);
        assertEquals(item, res);
    }

    @Test
    public void findByName() {
        HbmTracker hbt = new HbmTracker();
        hbt.init();
        Item item = new Item(1, "name");
        hbt.add(item);
        List<Item> res = hbt.findByName("name");
        assertEquals(item, res.get(0));
    }

    @Test
    public void findAll() {
        HbmTracker hbt = new HbmTracker();
        hbt.init();
        Item item = new Item(1, "name");
        hbt.add(item);
        Item item2 = new Item(2, "name2");
        hbt.add(item2);
        List<Item> items = new ArrayList<>();
        hbt.findAll(items::add);
        assertEquals(items, List.of(item, item2));
    }

    @Test
    public void replace() {
        HbmTracker hbt = new HbmTracker();
        hbt.init();
        Item item = new Item(1, "name");
        hbt.add(item);
        hbt.replace(1, new Item("new name"));
        Item res = hbt.findById(1);
        assertEquals("new name", res.getName());
    }

    @Test
    public void delete() {
        HbmTracker hbt = new HbmTracker();
        hbt.init();
        Item item = new Item(1, "name");
        Item item2 = new Item(2, "name");
        hbt.add(item);
        hbt.add(item2);
        hbt.delete(1);
        List<Item> items = new ArrayList<>();
        hbt.findAll(items::add);
        assertEquals(item2, items.get(0));
    }
}