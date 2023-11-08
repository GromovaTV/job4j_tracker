package ru.job4j.tracker;

import java.util.concurrent.atomic.AtomicInteger;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show All Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items ===");
        AtomicInteger count = new AtomicInteger(0);
        tracker.findAll(item -> {
            out.println(item);
            count.getAndAdd(1);
        });
        if (count.get() == 0) {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
