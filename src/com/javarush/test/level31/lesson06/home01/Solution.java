package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3 C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if  (args.length != 2)return;
        if (args[0] == null || args[1] == null)return;
        String fileName = args[0];
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipOutputStream zos = new ZipOutputStream(fos);
        Map<ZipEntry, ByteArrayOutputStream> map = new HashMap<>();

        byte[] buffer = new byte[2048];

        ZipEntry entry;

        while ((entry = zis.getNextEntry()) != null){
            if (entry.isDirectory())continue;
            ByteArrayOutputStream  baos = new ByteArrayOutputStream();
            int l = 0;
            while ((l = zis.read(buffer)) > 0){
                baos.write(buffer);
            }
            map.put(entry, baos);
            zis.closeEntry();
        }

        fis = new FileInputStream(fileName);
        ByteArrayOutputStream  baos = new ByteArrayOutputStream();
        while (fis.available() > 0){
            fis.read(buffer);
            baos.write(buffer);
        }
        zis.close();
        fis.close();

        for (Map.Entry<ZipEntry, ByteArrayOutputStream> pair: map.entrySet()){
            if (pair.getKey().getName().equals(fileName.substring(fileName.lastIndexOf("/") + 1,fileName.length())))continue;
            zos.putNextEntry(pair.getKey());
            zos.write(pair.getValue().toByteArray());
            zos.closeEntry();
        }
//        zos.putNextEntry(new ZipEntry("new/" + fileName.substring(fileName.lastIndexOf("/") + 1,fileName.length())));
//        zos.write(baos.toByteArray());
        zos.close();
        fos.close();
    }
}