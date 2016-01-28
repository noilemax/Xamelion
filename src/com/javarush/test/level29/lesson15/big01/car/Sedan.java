package com.javarush.test.level29.lesson15.big01.car;

public class Sedan extends Car
{
    public Sedan(int numberOfPassengers)
    {
        super(Car.SEDAN, numberOfPassengers);
    }
    @Override
    public int getMaxSpeed()//12.4
    {
        final int MAX_SEDAN_SPEED = 120; //12.3
        return MAX_SEDAN_SPEED;
    }
}
