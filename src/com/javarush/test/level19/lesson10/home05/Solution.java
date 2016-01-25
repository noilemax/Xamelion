package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));

        PrintWriter file2 = new PrintWriter(args[1]);

        while (file1.ready())
        {
            String temp = file1.readLine();
            Pattern p = Pattern.compile("[^\\s]*\\d[^\\s]*");
            Matcher m = p.matcher(temp);
            while (m.find())
            {
                String a = m.group();
                file2.write(a+" ");
            }
        }
        file1.close();
        file2.close();
    }
}

