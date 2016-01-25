package com.javarush.test.level19.lesson10.home07;

/* Длинные слова В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));

        ArrayList<String> list = new ArrayList<String>();

        while (file1.ready())
        {
            String[] words = file1.readLine().split(" ");
            for (String s : words)
                if (s.length() > 6) list.add(s);
        }
        String x = "";
        for (int i = 0; i < list.size() - 1; i++)
            x += list.get(i) + ",";
        x += list.get(list.size() - 1);

        file2.write(x);

        file1.close();
        file2.close();
    }
}

