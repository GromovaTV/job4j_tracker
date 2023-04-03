package ru.job4j.poly;

public class Airplain implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }
}
