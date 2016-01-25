package com.javarush.test.level08.lesson08.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Вася");
        map.put("Иванов2", "Вова");
        map.put("Иванова", "Инна");
        map.put("Иванова2", "Жанна");
        map.put("Петрова3", "Жанна");
        map.put("Петрова", "Люся");
        map.put("Сидорова", "Люся");
        map.put("Сидорова2", "Люся");
        map.put("Сидоров", "Олег");
        map.put("Сидоров2", "Изя");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (String value : copy.values())
            if (Collections.frequency(copy.values(), value) > 1)
                removeItemFromMapByValue(map, value);
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
