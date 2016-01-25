package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            int x = inputStream.read();
            if (!map.containsKey(x)) {
                map.put(x, 1);
            }
            else {
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (x == pair.getKey()) {
                        pair.setValue(pair.getValue()+ 1);
                    }
                }
            }
        }

        int min = 128;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() < min) {
                min = pair.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (min == pair.getValue())
            {
                System.out.print(pair.getKey() + " ");
            }
        }
        reader.close();
        inputStream.close();
    }
}
