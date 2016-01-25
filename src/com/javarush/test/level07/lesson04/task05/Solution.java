package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int[] list1 = new int[20];
        for (int i = 0; i < list1.length; i++){
            list1[i] = Integer.parseInt(b.readLine());
        }

        int[] list2 = Arrays.copyOf(list1, 10);
        int[] list3 = Arrays.copyOfRange(list1, list1.length - 10, list1.length);

        for (int i = 0; i < list1.length; i++)   {
        }

        for (int i = 0; i < list3.length; i++){
            System.out.println(list3[i]);
        }
    }
}
