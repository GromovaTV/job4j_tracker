package ru.job4j.map;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> opt = Optional.empty();
        opt = students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst();
        return opt;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> res = Optional.empty();
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            res = a.flatMap(student -> students.get(student)
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst());
        }
        return res;
    }
}