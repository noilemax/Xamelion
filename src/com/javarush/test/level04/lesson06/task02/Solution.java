package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import com.sun.org.apache.xerces.internal.dom.PSVIDOMImplementationImpl;

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();


        if (a >= b) {b = a;} else a = b;

        if (b >= c) {c = b;} else b = c;

        if (c >= d) {d = c;System.out.println(c);} else System.out.println(d);

        sc.close();
    }



    }

