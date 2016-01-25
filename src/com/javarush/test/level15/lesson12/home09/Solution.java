package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo c
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //add your code here
        String[] url = reader.readLine().split("\\?");

        if (url.length > 2)
        {
            return;
        }
        url = url[1].split("&");

        for (String s : url)
        {
            System.out.print(s.split("=")[0] + " ");
        }
        System.out.println();

        for (String s : url)
        {
            String[] nextUrl = s.split("=");

            if ("obj".equals(nextUrl[0]))
            {
                try
                {
                    alert(Double.parseDouble(nextUrl[1]));
                }
                catch (NumberFormatException e)
                {
                    alert(nextUrl[1]);
                }
            }
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
