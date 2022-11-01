package ru.job4j.poly;

public class Bus implements Vehicle {

    public void move(int speed) {
        System.out.println("Bus moves on dedicated road with speed: " + speed + " km per hour");
    }
}
