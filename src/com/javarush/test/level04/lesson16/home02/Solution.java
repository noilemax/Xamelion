package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();


        if (a >= b) {b = a;} else a = b;

        if (b <= c) {c = b;System.out.println(b);}
        else System.out.println(c);
    }
}
