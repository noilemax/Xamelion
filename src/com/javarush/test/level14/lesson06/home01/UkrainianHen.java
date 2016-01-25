package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ������������� on 22.10.2015.
 */
public class UkrainianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 13;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
