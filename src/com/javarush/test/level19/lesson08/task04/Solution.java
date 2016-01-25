package com.javarush.test.level19.lesson08.task04;

/* Решаем пример В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream printStream = System.out;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = arrayOutputStream.toString();
        System.setOut(printStream);

        String[] resultArr = result.split(" ");
        int firstNum = Integer.parseInt(resultArr[0]);
        int secondNum = Integer.parseInt(resultArr[2]);
        int arithmeticResult = 0;

        if (resultArr[1].equals("+"))
        {
            arithmeticResult = firstNum + secondNum;
        } else if (resultArr[1].equals("-"))
        {
            arithmeticResult = firstNum - secondNum;
        } else if (resultArr[1].equals("*"))
        {
            arithmeticResult = firstNum * secondNum;
        }
        System.out.println(firstNum + " " + resultArr[1] + " " + secondNum +" = " + arithmeticResult);

    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("3 + 6 = ");
        }
    }
}

