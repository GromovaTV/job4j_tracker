package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int comp = 0;
        int index;
        int size = Math.min(left.length(), right.length());
        for (index = 0; index < size; index++) {
            comp = Character.compare(left.charAt(index), right.charAt(index));
            if (comp != 0) {
                return comp;
            }
        }
        if (left.length() > right.length()) {
            comp = left.charAt(index);
        }
        if (left.length() < right.length()) {
            comp = -1 * right.charAt(index);
        }
        return comp;
    }
}