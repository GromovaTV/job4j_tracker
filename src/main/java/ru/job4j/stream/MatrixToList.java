package ru.job4j.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static List<Integer> convert(Integer[][] matrix) {
        List<List<Integer>> matrixList = new ArrayList<>();
        for (Integer[] row: matrix) {
            List<Integer> rowList = new ArrayList<>();
            for (Integer cell: row) {
                rowList.add(cell);
            }
            matrixList.add(rowList);
        }
        return matrixList.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
    }
}