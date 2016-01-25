package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file = new FileReader(reader.readLine());

        String text = "";
        int counter = 0;
        char currentShar = ' ';

        while (file.ready())
        {
            currentShar = (char) file.read();
            text = text + currentShar;

        }

        String replesString = text.replaceAll("\\p{P}", " ").toLowerCase();
        replesString = replesString.replaceAll("\\s", " ");

        String splitString[] = replesString.split(" ");
        for( String x : splitString)
        {
            if (x.equals("world")) {
                counter++;
            }
        }
        System.out.println(counter);
        reader.close();
        file.close();
    }
}