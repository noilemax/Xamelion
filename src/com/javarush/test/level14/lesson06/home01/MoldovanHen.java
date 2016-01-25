package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ������������� on 22.10.2015.
 */
class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 10;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

