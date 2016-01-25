package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int y = 0;
        while (y < 10)
        {
            {
                int z  = 0;
                while (z < 9)
                {
                    System.out.print("S");
                    z++;
                }
            }
            System.out.println("S");
            y++;

        }


    }
}
