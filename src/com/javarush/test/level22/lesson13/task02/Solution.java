package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Смена кодировки
В метод main первым параметром приходит имя файла,
 тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла,
в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        FileInputStream fio = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        byte[] buff = new byte[fio.available()];
        fio.read(buff);
        String s = new String(buff, "UTF-8");
        fos.write(s.getBytes("Windows-1251"));

        fio.close();
        fos.close();
    }
}
