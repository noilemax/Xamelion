package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner s = new Scanner(System.in);
        int o = s.nextInt();
        int d = s.nextInt();
        int t = s.nextInt();
        Reverse(o, d, t);
    }

    public static void Reverse(int a, int b, int c)
    {
        int m;
        if (a < b)
        {
            m = a;
            a = b;
            b = m;
        }

        if (a < c)
        {
            m = a;
            a = c;
            c = m;
        }

        if (b < c)
        {
            m = b;
            b = c;
            c = m;
        }

        System.out.println(a + " " + b +" "+ c);
    }
}
