package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Администратор on 23.01.2016.
 */
public class Tablet extends Observable
{
    public final int number;
    public static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

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
            if (!order.isEmpty())
            {
                notifyObservers(order);
            }
            try
            {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            }
            catch (NoVideoAvailableException e)
            {
                StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime() * 60));
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public void createTestOrder()
    {
        try
        {
            TestOrder testOrder = new TestOrder(this);
            ConsoleHelper.writeMessage(testOrder.toString());
            setChanged();
            if (!testOrder.isEmpty())
            {
                notifyObservers(testOrder);
            }
            try
            {
                new AdvertisementManager(testOrder.getTotalCookingTime() * 60).processVideos();
            }
            catch (NoVideoAvailableException e)
            {
                StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(testOrder.getTotalCookingTime() * 60));
                logger.log(Level.INFO, "No video is available for the order " + testOrder);
            }
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