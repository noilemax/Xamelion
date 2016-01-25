package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 23.01.2016.
 */
public class ConsoleHelper
{
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> dishs = new ArrayList<>();
        ConsoleHelper.writeMessage("Выберите блюдо: " + Dish.allDishesToString());

        while (true)
        {
            String str = readString();

            if ("exit".equalsIgnoreCase(str)) break;

            try
            {
                dishs.add(Dish.valueOf(str));
            }
            catch (IllegalArgumentException e)
            {
                ConsoleHelper.writeMessage(str + " is not detected");
            }
        }
        return dishs;
    }
}
