package ru.job4j.poly;

public class PolyUsage {

    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle airplain = new Airplain();
        Vehicle bus = new Bus();
        Vehicle secondTrain = new Train();
        Vehicle secondAirplain = new Airplain();
        Vehicle secondBus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{train, airplain, bus, secondTrain, secondAirplain, secondBus};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
