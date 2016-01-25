package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Администратор on 20.11.2015.
 */
public class Hippodrome
{
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static Hippodrome game;
    public ArrayList<Horse> horses = new ArrayList<>();

    public Horse getWinner()
    {
        Horse winner = new Horse("winner", 0, 0);
        for (Horse h: getHorses()) {
            if (h.getDistance()> winner.getDistance()) {
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);

        }
    }

    public void move()
    {
        for (Horse hors : getHorses())
        {
            hors.move();
        }

    }

    public void print()
    {
        for (Horse horse : horses)
        {
            horse.print();
            System.out.println();
            System.out.println();
        }

    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.getWinner();
    }
}
