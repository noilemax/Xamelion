package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ������������� on 22.10.2015.
 */
public class BelarusianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 3;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
