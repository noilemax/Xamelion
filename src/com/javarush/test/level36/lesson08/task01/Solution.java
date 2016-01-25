package com.javarush.test.level36.lesson08.task01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        FileInputStream fis = new FileInputStream(file);

        Set<Character> characters = new TreeSet<>();
        String str;

        char current;
        while (fis.available() > 0)
        {
            current = (char) fis.read();


            if (!characters.contains(current) && (current > 65 && current < 122 ))
            {

                characters.add(new Character(Character.toLowerCase(current)));
            }

        }
        int count = 0;
        for (Character character : characters)
        {
            str = character.toString();
            if (count <= 4 && character != null)
            {
                System.out.print(str);
                count++;
            }
        }
    }
}


