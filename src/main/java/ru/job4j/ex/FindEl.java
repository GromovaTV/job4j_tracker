package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        for (int index = 0; index < value.length; index++) {
            if (value[index] == key) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element is not foud");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] animals = {"dog", "cat", "wolf"};
        try {
            System.out.println(indexOf(animals, "wolf"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
