package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Администратор on 23.10.2015.
 */
public class Computer
{

    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;


    public Monitor getMonitor()
    {
        return monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }
}
