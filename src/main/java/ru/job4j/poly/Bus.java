package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус отправляется");
    }

    @Override
    public void passangers(int pass) {
        System.out.println("В автобусе " + pass + " пассажиров");
    }

    @Override
    public int refuel(int volume) {
        return volume * 10;
    }
}
