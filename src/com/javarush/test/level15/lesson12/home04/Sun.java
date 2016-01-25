package com.javarush.test.level15.lesson12.home04;

/**
 * Created by ������������� on 27.10.2015.
 */
public final class Sun implements Planet
{
    private static Sun thePlanet;
    private Sun (){}
    public static Sun getInstance(){
        if (thePlanet == null){
            thePlanet = new Sun();
        }
        return thePlanet;
    }
}
