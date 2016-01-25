package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String scaner1f = reader.readLine();
        String scaner2f = reader.readLine();
        FileInputStream file2 = new FileInputStream(scaner1f);
        FileInputStream file3 = new FileInputStream(scaner2f);

        ArrayList<Byte> list = new ArrayList<Byte>();

        while (file3.available() > 0)
        {
            int data = file3.read();
            list.add((byte) data);
        }

        while (file2.available() > 0)
        {
            int data1 = file2.read();
            list.add((byte) data1);
        }
        FileOutputStream file1 = new FileOutputStream(scaner1f);

        for (int i = 0; i < list.size(); i++)
        {
            file1.write(list.get(i));
        }

        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}