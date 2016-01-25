package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Character space = ' ';
        ArrayList<Character> list = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character sym = s.charAt(i);
            if (i == 0 && s.charAt(i)!= space ){
                sym = sym.toUpperCase(sym);
            } else if (i > 0 && s.charAt(i-1) == space && s.charAt(i) != space){
                sym = sym.toUpperCase(sym);
            }
            list.add(sym);

        }

        String itog = "";
        for (Character f : list)
            itog +=f;


        System.out.println(itog);
                                                                          //напишите тут ваш код
    }


}
