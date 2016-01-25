package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream donor = new FileInputStream(reader.readLine());
        FileOutputStream poly4atel = new FileOutputStream(reader.readLine());
        byte[] arr = new byte[donor.available()];
        byte[] arr1 = new byte[donor.available()];

        int byt_size = donor.read(arr);

        for (int i = byt_size - 1; i >= 0; i--)
        {
            arr1[byt_size -1 - i] = arr[i];
        }
        poly4atel.write(arr1);



        reader.close();
        donor.close();
        poly4atel.close();
    }
}
