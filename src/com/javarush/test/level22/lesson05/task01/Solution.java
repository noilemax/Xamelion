package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        int firstSpase = string.indexOf(" ");
        if (firstSpase == -1)
            throw new TooShortStringException();
        int lastSpase = string.indexOf(" ", firstSpase + 1);
        if (lastSpase == -1)
            throw new TooShortStringException();
        lastSpase = string.indexOf(" ", lastSpase + 1);
        if (lastSpase == -1)
            throw new TooShortStringException();
        lastSpase = string.indexOf(" ", lastSpase + 1);
        if (lastSpase == -1)
            throw new TooShortStringException();
        String afterLastSpase = string.substring(lastSpase + 1);
        System.out.println(afterLastSpase);
        char[] afterLastSpaseArray = afterLastSpase.toCharArray();
        int index = 0;
        if (!Character.isLetter(afterLastSpaseArray[0]))
            throw new TooShortStringException();
        for (int i = 0; i < afterLastSpaseArray.length; i++)
        {
            if (Character.isLetter(afterLastSpaseArray[i]))
                index = i;
            else break;
        }
        return string.substring(firstSpase + 1, lastSpase + index + 2);
    }

    public static class TooShortStringException extends Exception
    {
    }
}
