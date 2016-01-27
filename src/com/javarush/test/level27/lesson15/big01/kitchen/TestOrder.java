package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        for (int i = (int)(Math.random()*Dish.values().length); i < Dish.values().length; i++)
        {
            dishes.add(Dish.values()[i]);
        }

//        dishes = new ArrayList<>();
//        int i = (int) (Math.random() * 5);
//        dishes.add(Dish.values()[i]);
    }

}