package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int maximum = Integer.MIN_VALUE;
        for (int pp = 0; pp < a; pp++)
        {
            int c = Integer.parseInt(reader.readLine());
            if (c > maximum)
            {
                maximum = c;



            }
        }
        System.out.println(maximum);
    }
}