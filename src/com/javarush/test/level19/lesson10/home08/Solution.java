package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader filenameReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(filenameReader.readLine()));
        filenameReader.close();
        ArrayList<String> list = new ArrayList<String>();

        while (fileReader.ready())
        {
            list.add(fileReader.readLine());
        }
        fileReader.close();

        for (int i = 0; i < list.size(); i++)
        {
            StringBuilder s = new StringBuilder(list.get(i)).reverse();
            System.out.println(s);
        }
    }
}
