package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws InterruptedException
    {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook = new Cook("Amigo");
        Cook diego = new Cook("Diego");
        StatisticEventManager.getInstance().register(cook);
        StatisticEventManager.getInstance().register(diego);
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        diego.addObserver(waitor);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            tablets.add(new Tablet(i));
            tablets.get(i).addObserver(cook);
            tablets.get(i).addObserver(diego);
        }

        Thread t = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        t.start();

        Thread.sleep(1000);

        t.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();


    }
}