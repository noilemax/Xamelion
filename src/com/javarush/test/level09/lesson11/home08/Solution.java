package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
 Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);

    }

    public static ArrayList<int[]> createList()
    {
        int[] array1 = new int[5];//напишите тут ваш код
        int[] array2 = new int[2];
        int[] array3 = new int[4];
        int[] array4 = new int[7];
        int[] array5 = new int[0];

        ArrayList<int[]> newList = new ArrayList<int[]>();
        newList.add(array1);
        newList.add(array2);
        newList.add(array3);
        newList.add(array4);
        newList.add(array5);
        for (int i = 0; i < newList.size(); i++)
        {
            for (int j = 0; j < newList.get(i).length; j++)
            {
                newList.get(i)[j] = j;
            }
        }
        return newList;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array : list)
        {
            for (int x : array)
            {
                System.out.println(x);
            }
        }
    }
}
