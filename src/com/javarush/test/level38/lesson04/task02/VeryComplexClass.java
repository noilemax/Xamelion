package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

import java.util.ArrayList;
import java.util.Map;

public class VeryComplexClass
{
    public static void main(String[] args)
    {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsClassCastException();
        veryComplexClass.methodThrowsNullPointerException();
    }

    public void methodThrowsClassCastException()
    {

        Object x = new Integer(0);
        System.out.println((String) x);
        //напишите тут ваш код
    }

    public void methodThrowsNullPointerException()
    {
        Map<Integer, String> map = null;
        map.put(null, null);
        //напишите тут ваш код
    }
}
