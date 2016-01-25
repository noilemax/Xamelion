package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Администратор on 23.01.2016.
 */
public class Tablet extends Observable
{
    private final int number;
    final static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        try
        {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged();
            notifyObservers(order);
            new AdvertisementManager(order.getTotalCookingTime()).processVideos();

        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }

    @Override
    public String toString()
    {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
