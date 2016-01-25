package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Mouse plemyannicjerryMouse = new Mouse("Jerry", 6 , 2);
        Cat tomMcat = new Cat("Tom", 35 , 5);
        Cat anatherCat = new Cat("Drygoi cot", 30 , 30);
        Dog dogGog = new Dog("Dog", 12 , 2);
        Woman woman1 = new Woman("Chernen'kaya", 165 , 0);

        //напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int height;
        int tail;
        public Cat(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Dog
    {
        String name;
        int height;
        int tail;
        public Dog(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Woman
    {
        String name;
        int height;
        int tail;
        public Woman(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы

}
