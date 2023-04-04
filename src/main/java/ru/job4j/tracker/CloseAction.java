package ru.job4j.tracker;

public class CloseAction implements UserAction {
    private final Output out;

    public CloseAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
