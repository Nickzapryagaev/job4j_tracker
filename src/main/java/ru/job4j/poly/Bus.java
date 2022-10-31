package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Bus is driving");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Passenger count is: " + count);
    }

    @Override
    public int fill(int price) {
        return price / 2;
    }
}
