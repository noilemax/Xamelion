package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileReader(reader.readLine()));
        FileWriter writer = new FileWriter(reader.readLine());
        String s = "";

        while (scanner.hasNext()) {
            s = scanner.next();
            String[] arr = s.split(" ");
            for (String x : arr) {
                x = x.replace(".", "!");
                writer.write(x + " ");
            }
        }
        reader.close();
        scanner.close();
        writer.close();
    }
}
