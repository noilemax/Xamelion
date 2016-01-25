package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
          int number1 = scanner.nextInt();
          int number2 = scanner.nextInt();

        int a = number1;
        int b = number2;

        int m2;
        if(a < b)
            m2 = a;
        else
            m2 = b;


        System.out.println(m2);


    }
        }
