package com.javarush.test.level08.lesson08.task01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
       Set<String> set = new HashSet<String>();
        set.add("Лида");
        set.add("Лёва");
        set.add("Люся");
        set.add("Люда");
        set.add("Лиля");
        set.add("Лена");
        set.add("Лёня");
        set.add("Людмила");
        set.add("Люсильда");
        set.add("Лиза");
        set.add("Лизок");
        set.add("Ленусик");
        set.add("Лидусик");
        set.add("Лёнчик");
        set.add("Люба");
        set.add("Любовь");
        set.add("Любаша");
        set.add("Ланселот");
        set.add("Лопух");
        set.add("Лёлик");
        return (HashSet)set;
    }
}
