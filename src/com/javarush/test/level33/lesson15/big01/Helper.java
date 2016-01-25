package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Администратор on 27.12.2015.
 */
public class Helper
{
    public static String generateRandomString()
    {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    public static void printMessage(String message)
    {
        System.out.println(message);
    }
}