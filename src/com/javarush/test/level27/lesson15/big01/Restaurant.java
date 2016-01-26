package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.Locale;

/**
 * Created by Администратор on 23.01.2016.
 */
public class Restaurant {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        tablet.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();


//        Locale.setDefault(Locale.ENGLISH);
//        Tablet tablet = new Tablet(5);
//
//        Waitor waitor = new Waitor();
//        Cook cook = new Cook("Amigo");
//
//        cook.addObserver(waitor);
//
//        tablet.addObserver(cook);
//        tablet.createOrder();
//
//        DirectorTablet directorTablet=new DirectorTablet();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();
    }
}