package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader inputFile = new FileReader(reader.readLine());
        FileWriter outPutFile = new FileWriter(reader.readLine());
        reader.close();
        int i = 0;
        while (inputFile.ready())
        {
            i++;
            int data = inputFile.read();
            if (i % 2 == 0)
                outPutFile.write(data);

        }
        inputFile.close();
        outPutFile.close();

    }
}
