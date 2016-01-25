package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2 CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        /*Считывание с консоли имя файла для операции*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String stringWrite = "";

        if (!args[0].equals("-d"))
        {
         /*Подготовка ID для записи в файл*/
            String idString = args[1];
            for (int i = idString.length(); i < 8; i++)
            {
                idString += " ";
            }

        /*Получение кол-ва элементов с которых состоит productName, порядок сдвига для остальных элементов*/
            int dif = args.length - 5;

        /*Подготовка productName для записи в файл*/
            String productName = "";
            for (int i = 2; i <= (2 + dif); i++)
            {
                productName += args[i] + " ";
            }
            if (productName.length() > 30)
            {
                productName = productName.substring(0, 30);
            } else
            {
                for (int i = productName.length(); i < 30; i++)
                {
                    productName += " ";
                }
            }
        /*Подготовка price для записи в файл*/
            String price = (args[3 + dif]) + "";
            for (int i = price.length(); i < 8; i++)
            {
                price += " ";
            }
        /*Подготовка quantity для записи в файл*/
            String quantity = args[4 + dif];
            for (int i = quantity.length(); i < 4; i++)
            {
                quantity += " ";
            }
            stringWrite = idString + productName + price + quantity; //Строка для записи
        }

        LinkedList<String> listOfStrings = new LinkedList<String>(); //Тут хранить считаные строки

        /*Считывание файла fileName, логика заполнения listOfStrings*/
        Scanner inputSream = new Scanner(new File(fileName));
        while (inputSream.hasNext()){
            String tmp = inputSream.nextLine();
            String tmpId = tmp.substring(0, 8).trim();
            if (tmpId.equals(args[1])){
                if (args[0].equals("-u")){
                    listOfStrings.add(stringWrite);
                } else {
                    continue;
                }
            } else {
                listOfStrings.add(tmp);
            }
        }

        /*Перезапись выходного файла, согласно проведенных манипуляций*/
        FileOutputStream outputStream = new FileOutputStream(fileName, false);
        for (String tmp : listOfStrings){
            outputStream.write((tmp + "\r\n").getBytes());
        }
        outputStream.close();
    }
}