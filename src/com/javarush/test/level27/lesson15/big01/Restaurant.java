package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by Администратор on 23.01.2016.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        Waitor waitor = new Waitor();
        Tablet tablet = new Tablet(5);

        Cook cook = new Cook("Amigo");
        cook.addObserver(waitor);

        tablet.addObserver(cook);
        tablet.createOrder();
    }
}
