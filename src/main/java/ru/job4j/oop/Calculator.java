package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public static int sum(int a) {
        return a + x;
    }

    public int multiply(int a) {
        return a * x;
    }

    public int sumAllOperation(int a) {
        return minus(a) + sum(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
        Calculator calc = new Calculator();
        System.out.println(calc.multiply(5));
        System.out.println(calc.sumAllOperation(5));

    }
}
