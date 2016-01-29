package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.BLACK);

        int centerX = getX() + getWidth();
        int centerY = getY() + getHeight();

        graphics.drawRect(centerX, centerY, getWidth(), getHeight());
        graphics.fillOval(centerX, centerY, getWidth(), getHeight());
    }
}
