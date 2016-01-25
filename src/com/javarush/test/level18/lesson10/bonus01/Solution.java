package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args[0].equals("-e"))
        {
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            byte[] buffer = null;
            while (fileInputStream.available() > 0)
            {
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
            }
            for (int i = 0; i < buffer.length; i++)
            {
                buffer[i] = (byte) (buffer[i] + 2);
            }
            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            fileOutputStream.write(buffer);
            fileOutputStream.close();

        }
        if (args[0].equals("-d")) {
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            byte[] buffer = null;
            while (fileInputStream.available() > 0)
            {
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
            }
            for (int i = 0; i < buffer.length; i++)
            {
                buffer[i] = (byte) (buffer[i]- 2);
            }
            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            fileOutputStream.write(buffer);
            fileOutputStream.close();
        }
    }
}