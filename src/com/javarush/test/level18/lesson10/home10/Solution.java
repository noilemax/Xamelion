package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Set<File> fileList = new TreeSet<File>();

        while (!(name = reader.readLine()).equals("end"))
        {
            File file = new File(name);
            fileList.add(file);
        }
        Iterator<File> itr = fileList.iterator();
        String folder = itr.next().getAbsolutePath();
        folder = folder.substring(0, folder.length() - 6);

        FileOutputStream resultFile = new FileOutputStream(folder);
        for (File file : fileList)
        {
            FileInputStream fileIn = new FileInputStream(file);
            byte[] buffer = new byte[fileIn.available()];
            while (fileIn.available() > 0)
            {
                fileIn.read(buffer);
                resultFile.write(buffer);
            }

            fileIn.close();
        }
        resultFile.close();
        reader.close();

    }
}