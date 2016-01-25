package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Администратор on 18.12.2015.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String read;
        while (true)
        {
            try
            {
                read = reader.readLine();
                break;
            }
            catch (IOException e)
            {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");

            }
        }
        return read;
    }

    public static int readInt()
    {
        int x;
        while (true)
        {

            try
            {
                x = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return x;
    }
}

