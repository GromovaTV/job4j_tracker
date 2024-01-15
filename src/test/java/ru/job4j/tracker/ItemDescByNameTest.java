package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ItemDescByNameTest {

    @Test
    void compare() {
        List<Item> items = Arrays.asList(
                new Item("C"),
                new Item("A"),
                new Item("B")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("C"),
                new Item("B"),
                new Item("A")
        );
        assert (expected.get(0).getName().equals(items.get(0).getName()));
        assert (expected.get(1).getName().equals(items.get(1).getName()));
        assert (expected.get(2).getName().equals(items.get(2).getName()));
    }
}