package com.javarush.test.level15.lesson12.home04;

/**
 * Created by ������������� on 27.10.2015.
 */
public final class Moon implements Planet
{
    private static Moon instance;
    private Moon (){}
    public static Moon getInstance(){
        if (instance == null){
            instance = new Moon();
        }
        return instance;
    }
}
