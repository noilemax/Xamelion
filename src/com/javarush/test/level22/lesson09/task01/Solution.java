package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        List<String> word = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        while (fileReader.ready())
            word.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        fileReader.close();
        for (int i = 0; i < word.size(); i++)
        {
            for (int j = 0; j < word.size(); j++)
            {
                if (word.get(j).equals(new StringBuffer(word.get(i)).reverse().toString()) && j != i)
                {
                    Pair pair = new Pair();
                    pair.first = word.get(j);
                    pair.second = word.get(i);
                    result.add(pair);
                    word.remove(j);
                    word.remove(i);
                    j = 0;
                }
                else j++;
            }
        }
        for (Pair s : result)
        {
            System.out.println(s.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
