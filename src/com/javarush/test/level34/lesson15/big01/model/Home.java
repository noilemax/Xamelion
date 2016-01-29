package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Home extends GameObject
{
    public Home(int x, int y)
    {

        super(x = 2, y = 2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);

        int centerX = getX() + getWidth();
        int centerY = getY() + getHeight();

        graphics.drawOval(centerX, centerY, getWidth(), getHeight());
    }
}
