package com.javarush.test.level23.lesson13.big01;

public class SnakeSection
{
    private int x;
    private int y;


    public SnakeSection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof SnakeSection))return false;
        if (o == this)return true;
        SnakeSection rez = (SnakeSection)o;
        return rez.x==this.x&&rez.y==this.y;

    }

    @Override
    public int hashCode()
    {
        if (y!=0)
            return x/y;
        return y;
    }
}
