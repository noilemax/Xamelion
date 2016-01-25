package com.javarush.test.level08.lesson06.task05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* Четыре метода
Реализовать 4 метода. Они должны возвращать список, который лучше всего подходит для выполнения данных операций
(быстрее всего справится с большим количеством операций). Ничего измерять не нужно.
*/

public class Solution
{
    public static List  getListForGet()
    {
       ArrayList<Objects> list = new ArrayList<Objects>();
        return list;

    }

    public static List  getListForSet()
    {
        ArrayList<Objects> list = new ArrayList<Objects>();
        return list;

    }

    public static List  getListForAddOrInsert()
    {
        LinkedList<Objects> list = new LinkedList<Objects>();  //напишите тут ваш код
        return list;

    }

    public static List  getListForRemove()
    {
      LinkedList<Objects> list = new LinkedList<Objects>();  //напишите тут ваш код
        return list;
    }
}
