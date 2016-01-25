package com.javarush.test.level36.lesson06.task01;

import java.util.Collections;


/* Найти класс по описанию
1. Реализует интерфейс List
2. Является приватным статическим классом внутри популярного утилитного класса
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException
4. Используйте рефлекшн, чтобы добраться до искомого класса
*/
public class Solution
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException
    {
//        Class<?>[] classes = List.class.getDeclaredClasses();
//        for (Class clazz : classes)
//        {
//            System.out.println(clazz.getSimpleName());
//        }
        /* expected output:
        ArrayListSpliterator
        Itr
        ListItr
        SubList
        class java.util.ArrayList$ArrayListSpliterator
        */

//        return Collections.class.getClass().getName(EmptyList) ;
        Class x = Class.forName(Collections.emptyList().getClass().getName());
        return x;
    }

}
