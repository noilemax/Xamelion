package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Администратор on 23.10.2015.
 */
public class Keyboard implements CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
