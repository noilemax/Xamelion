package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;


/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей
 по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
//     public static void main(String[] args) {
//    System.out.println(getCountTheSameFirstName(createMap(), "Иван") + " "
//        + getCountTheSameLastName(createMap(), "Смирнов"));

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

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String str : map.values()) {
            if (str.equals(name)) count++;
        }
        return count;


    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya) {
        //напишите тут ваш код
        int count = 0;
        for (String str : map.keySet()) {
            if (str.equals(familiya)) count++;
        }
        return count;
        }
}