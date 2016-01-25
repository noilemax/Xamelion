package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 27.12.2015.
 */
public class Solution
{
    public Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> result = new HashSet<>();
        for (String s : strings)
        {
            result.add(shortener.getId(s));
        }
        return result;
    }

    public Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> result = new HashSet<>();
        for (Long s : keys)
        {
            result.add(shortener.getString(s));
        }
        return result;
    }

    public void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getName());

        Set<String> testStering = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
        {
            testStering.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Long t1 = new Date().getTime();
        Set<Long> longSet = this.getIds(shortener, testStering);
        Long t2 = new Date().getTime();
        Set<String> longSet1 = this.getStrings(shortener, longSet);
        Long t3 = new Date().getTime();

        Long timeMethodGetString = t2 - t1;
        Long timeMethorGetId = t3 - t2;

        Helper.printMessage(timeMethodGetString.toString());
        Helper.printMessage(timeMethorGetId.toString());

        if (longSet1.equals(testStering))
        {
            Helper.printMessage("Тест пройден.");
        } else Helper.printMessage("Тест не пройден.");

    }

    public static void main(String[] args)
    {
        new Solution().testStrategy(new HashMapStorageStrategy(), 10000L);

    }
}
