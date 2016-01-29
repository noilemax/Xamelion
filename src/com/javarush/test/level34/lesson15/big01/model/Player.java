package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.YELLOW);

        int centerX = getX() + getWidth();
        int centerY = getY() + getHeight();

        graphics.drawOval(centerX, centerY, getWidth(), getHeight());
        graphics.fillOval(centerX, centerY, getWidth(), getHeight());

    }

    @Override
    public void move(int x, int y)
    {
        this.setX(getX() + x);
        this.setY(getY() + y);
    }
}
