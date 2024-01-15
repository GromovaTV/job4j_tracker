package ru.job4j.lambda;

import java.util.function.Consumer;

public class ConsumerAndThen {

    public static Consumer<String> consumer(String input) {
        Consumer<String> print = s -> System.out.print(s);
        Consumer<String> ln = s -> System.out.print(System.lineSeparator());
        return print.andThen(ln);
    }
}