package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileIn = new FileReader(reader.readLine());
        FileWriter writer = new FileWriter(reader.readLine());
        reader.close();

        while (fileIn.ready()) {
            char c = (char) fileIn.read();
            if (!Pattern.matches("\\p{P}", String.valueOf(c))){
                writer.write(c);
            }
        }
        fileIn.close();
        writer.close();
    }
}
