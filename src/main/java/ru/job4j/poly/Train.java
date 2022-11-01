package ru.job4j.poly;

public class Train implements Vehicle {

    public void move(int speed) {
        System.out.println("Train moves on railway with speed: " + speed + " km per hour");
    }
}
