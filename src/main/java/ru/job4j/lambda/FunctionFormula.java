package ru.job4j.lambda;

import java.util.function.Function;

public class FunctionFormula {

    public static double calculate(double x) {
        return calculate(f ->  f * f + 2 * f + 1, x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }
}