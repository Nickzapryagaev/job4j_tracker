package ru.job4j.poly;

public class Plane implements Vehicle {

    public void move(int speed) {
        System.out.println("Plane flies with speed: " + speed + " km per hour");
    }
}
