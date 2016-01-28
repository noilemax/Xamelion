package com.javarush.test.level29.lesson15.big01.car;

public class Cabriolet extends Car
{
    public Cabriolet(int numberOfPassengers)
    {
        super(Car.CABRIOLET, numberOfPassengers);
    }
    @Override
    public int getMaxSpeed()//12.4
    {
        final int MAX_CABRIOLET_SPEED = 90;//12.3
        return MAX_CABRIOLET_SPEED;
    }
}