package ru.job4j.lambda;

import java.util.function.Function;

public class FunctionPow {

    public static double calculate(double x) {
        Function<Double, Double> func = s -> s * s;
        return calculate(func, x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }

}
