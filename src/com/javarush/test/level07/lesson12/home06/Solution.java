package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),
возраст(int), отец(Human), мать(Human). Создай объекты
 и заполни их так, чтобы получилось: Два дедушки,
  две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human,
 то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human grFather = new Human("Djamshud", true, 67, null, null);
        Human grFather2 = new Human("Izya", true, 70, null, null);
        Human grMother = new Human("Lida", false, 70, null,null);
        Human grMother2 = new Human("Izabella", false, 72, null, null);
        Human father = new Human("Ravshan",true, 40, grFather, grMother);
        Human mother = new Human("Lena",false, 37, grFather2, grMother2);
        Human son = new Human("Gena", true, 5, father, mother);
        Human son2 = new Human("Jora",true, 5, father, mother);
        Human daughter = new Human("Ulya", false, 5, father, mother);

        System.out.println(grFather);
        System.out.println(grFather2);
        System.out.println(grMother);
        System.out.println(grMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(son2);
        System.out.println(daughter);
    }

    public static class Human
    {
        String name;
        Boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, Boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
