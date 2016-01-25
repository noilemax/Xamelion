package com.javarush.test.level04.lesson13.task03;

import java.io.*;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        for (int y = 0; y < 10; y++)
        {
            for (int x = 0; x < y; x++)
            {
                System.out.print(8);

            }
            System.out.println(8);

        }
    }
}
