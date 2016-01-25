package com.javarush.test.level12.lesson12.bonus01;

/* Нужно исправить программу, чтобы компилировалась и работала
Расставить правильно ключевые слова abstract, чтобы программа компилировалась (там где надо и не надо).
*/

public class Solution
{

    public static void main(String[] args)
    {
        Horse horse = new Pegas()
        {
            @Override
            public void fly()
            {

            }
        };
        horse.run();
    }

    public static interface Fly
    {
        public abstract void fly();
    }

    public static abstract class Horse
    {
        public void run()
        {

        }
    }

    public static abstract class Pegas extends Horse implements Fly
    {
        public abstract void fly();
    }

    public static class SwimPegas extends Pegas
    {
        public void swim()
        {

        }

        @Override
        public void fly()
        {

        }
    }

}
