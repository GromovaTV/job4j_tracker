package ru.job4j.stream;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.compare;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(s -> s.getScore())
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream().mapToInt(p -> p.getScore())
                .average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(groupingBy(Subject::getName, LinkedHashMap::new,
                        averagingDouble(value -> value.getScore())))
                .entrySet()
                .stream()
                .map(v -> new Tuple(v.getKey(), v.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
       // return null;
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream().mapToInt(p -> p.getScore())
                .sum()))
                .max(Comparator.comparingInt(o -> (int) o.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        //return null;
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(groupingBy(Subject::getName, LinkedHashMap::new,
                        summingDouble(value -> value.getScore())))
                .entrySet()
                .stream()
                .map(v -> new Tuple(v.getKey(), v.getValue()))
                .max(Comparator.comparingInt(o -> (int) o.getScore()))
                .orElse(null);
    }
}