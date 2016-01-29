package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Box;
import com.javarush.test.level34.lesson15.big01.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel
{
    private View view;
    private EventListener eventListener;

    public Field(View view)
    {
        this.view = view;
    }

    @Override
    public void paint(Graphics g)
    {
        Box box = new Box(3, 3);
        Player player = new Player(5, 5);
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;

    }
}