package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }

        Collections.sort(list);

        for (int i = 0; i < list.size()-1; i++)
        {
            if (list.get(i).equals(list.get(i + 1)))
            {
                list.remove(i);
                i--;
            }
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
        reader.close();
        inputStream.close();
    }
}
