package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * Интерфейс Supplier служит для того, чтобы обернуть логику создания объекта.
 * Он ничего не принимает, только возвращает объект, который ему поручили создать.
 * Ссылки на методы поддерживает метод new, который позволяет нам создать нужный нам объект
 *
 * Вернуть Supplier, который создает пустую строку через new.
 */
public class MRSupplier {

    public static Supplier<String> supplier() {
        return String::new;
    }
}