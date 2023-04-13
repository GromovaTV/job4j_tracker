package ru.job4j.function;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {

    public boolean size(Folder f) {
        return check(str -> str.getSize() > 100, f);
    }

    public boolean contains(Folder f) {
        return check(str -> str.getName().contains("bug"), f);
    }

    public boolean check(Predicate<Folder> pred, Folder f) {
        return pred.test(f);
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}