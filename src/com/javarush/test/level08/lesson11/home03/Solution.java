package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("petrov", "vasya");
        hashMap.put("petrov", "vasya1");
        hashMap.put("name3", "vasya");
        hashMap.put("name", "vasya");
        hashMap.put("name", "vasya");
        hashMap.put("petrov6", "vasya");
        hashMap.put("petrov7", "vasya6");
        hashMap.put("petrov8", "vasya");
        hashMap.put("petrov9", "vasya7");
        hashMap.put("petrov10", "vasya8");


        return hashMap;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
