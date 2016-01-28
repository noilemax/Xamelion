package com.javarush.test.level29.lesson15.big01.car;

public class Truck extends Car
{
    public Truck(int numberOfPassengers)
    {
        super(Car.TRUCK, numberOfPassengers);
    }
    @Override
    public int getMaxSpeed() //12.4
    {
        final int MAX_TRUCK_SPEED = 80; // 12.3
        return MAX_TRUCK_SPEED;
    }
}
