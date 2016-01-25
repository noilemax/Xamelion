package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Администратор on 27.10.2015.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();

    abstract void putIngredient();

    abstract  void pour();

//    abstract makeDrink();
        void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }


}
