package com.javarush.test.level31.lesson06.bonus01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length < 2) return;

        String ressultFile = args[0];
        int filePatrCount = args.length - 1;
        String[] fileNamePath = new String[filePatrCount];

        for (int i = 0; i < filePatrCount; i++)
        {
            fileNamePath[i] = args[i + 1];
        }
        Arrays.sort(fileNamePath);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePatrCount; i++)
        {
            fisList.add(new FileInputStream(fileNamePath[i]));
        }
        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(fisList));

        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(ressultFile);
        byte[] buf = new byte[1024 * 1024];
        while (zipInputStream.getNextEntry() != null)
        {
            int count;
            while ((count = zipInputStream.read(buf)) != -1)
            {
                fileOutputStream.write(buf, 0, count);
            }
        }
        sequenceInputStream.close();
        zipInputStream.close();
        fileOutputStream.close();


    }
}
