package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 33; i++)
            number.add(0);

        for (int i = 0; i < list.size(); i++)
        {
            char[] m = list.get(i).toCharArray();
            for (int j1 = 0; j1 < alphabet.size(); j1++)
                for (int j2 = 0; j2 < m.length; j2++)
                    if (alphabet.get(j1).equals(m[j2]))
                        number.set(j1, number.get(j1) + 1);
        }

        for (int i = 0; i < number.size(); i++)
        {
            System.out.println(alphabet.get(i) + " " + number.get(i));
        }
    }

}
