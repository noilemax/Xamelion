package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0)
        {
            if (inputStream.available() % 2 == 0)
            {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, (count / 2));
                outputStream1.write(buffer, (count / 2), (count / 2));
            } else if (inputStream.available() % 2 != 0)
            {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, (count / 2 + 1));
                outputStream1.write(buffer, (count / 2 ), (count / 2 ));

            }
        }
        reader.close();
        inputStream.close();
        outputStream.close();
        outputStream1.close();
    }
}
