package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftNumber = left.split("/", 2);
        String[] rightNumber = right.split("/", 2);
        int comp = 0;
        int index;
        for (index = 0; index < 2; index++) {
            comp = Character.compare(leftNumber[0].charAt(index), rightNumber[0].charAt(index));
            if (comp != 0) {
                return -1 * comp;
            }
        }
        if (leftNumber.length == 1 && rightNumber.length == 1) {
            return 0;
        }
        if (leftNumber.length == 1) {
            return (int) rightNumber[1].charAt(index) * (-1);
        }
        if (rightNumber.length == 1) {
            return (int) leftNumber[1].charAt(index);
        }
        for (index = 0; index < Math.min(leftNumber[1].length(), rightNumber[1].length()); index++) {
            comp = Character.compare(leftNumber[1].charAt(index), rightNumber[1].charAt(index));
            if (comp != 0) {
                return comp;
            }
        }
        if (leftNumber[1].length() > rightNumber[1].length()) {
            comp = leftNumber[1].charAt(index);
        }
        if (leftNumber[1].length() < rightNumber[1].length()) {
            comp = -1 * rightNumber[1].charAt(index);
        }
        return comp;
    }
}