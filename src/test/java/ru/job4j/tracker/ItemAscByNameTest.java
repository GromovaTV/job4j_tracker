package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemAscByNameTest {

    @Test
    void compare() {
        List<Item> items = Arrays.asList(
                new Item("C"),
                new Item("A"),
                new Item("B")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C")
        );
        assert (expected.get(0).getName().equals(items.get(0).getName()));
        assert (expected.get(1).getName().equals(items.get(1).getName()));
        assert (expected.get(2).getName().equals(items.get(2).getName()));
    }
}