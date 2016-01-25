package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые
вывести сообщение «Имена идентичны».
Если имена разные, но их длины равны – вывести сообщение
– «Длины имен равны».
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      Scanner s = new Scanner(System.in);
        String name1 = s.nextLine();
        String name2 = s.nextLine();

        String a = name1;
        String b = name2;

        if (a.equals(b))
        System.out.println("Имена идентичны");
        else {if (a.length() == b.length())
            System.out.println("Длины имен равны");}
    }

    }

