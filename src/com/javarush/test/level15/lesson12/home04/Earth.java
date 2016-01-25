package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Администратор on 27.10.2015.
 */
public final class Earth implements Planet
{
    private static Earth earth;
    private Earth (){}
    public static Earth getInstance(){
        if (earth == null){
            earth = new Earth();
        }
        return earth;
    }
}
