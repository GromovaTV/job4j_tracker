package ru.job4j.lambda;

import java.util.function.Predicate;

public class PredicateCheckEvenAndPositive {

    public static boolean check(int num) {
        Predicate<Integer> predicatePoritive = s -> s > 0;
        Predicate<Integer> predicateEven = s -> s % 2 == 0;
        Predicate<Integer> predicate = predicateEven.and(predicatePoritive);
        return check(predicate, num);
    }

    private static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }
}