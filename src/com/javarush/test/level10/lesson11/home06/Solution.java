package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и
реализуй 10 различных конструкторов для него.
 Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public String firdyNmae;
        public String lastNmae;
        public Boolean sex;
        public int age;
        public Boolean estDeti;
        public int dlinaVolos;

        public Human(String firdyNmae, String lastNmae, Boolean sex, int age, Boolean estDeti, int dlinaVolos)
        {
            this.firdyNmae = firdyNmae;
            this.lastNmae = lastNmae;
            this.sex = sex;
            this.age = age;
            this.estDeti = estDeti;
            this.dlinaVolos = dlinaVolos;
        }

        public Human(String firdyNmae, String lastNmae)
        {
            this.firdyNmae = firdyNmae;
            this.lastNmae = lastNmae;

        }

        public Human(String firdyNmae, int age, Boolean estDeti, int dlinaVolos)
        {
            this.firdyNmae = firdyNmae;
            this.age = age;
            this.estDeti = estDeti;
            this.dlinaVolos = dlinaVolos;
        }

        public Human(String firdyNmae, int dlinaVolos)
        {
            this.firdyNmae = firdyNmae;
            this.dlinaVolos = dlinaVolos;
        }

        public Human(String lastNmae, Boolean sex, int age, Boolean estDeti, int dlinaVolos)
        {

            this.lastNmae = lastNmae;
            this.sex = sex;
            this.age = age;
            this.estDeti = estDeti;
            this.dlinaVolos = dlinaVolos;
        }

        public Human(String firdyNmae, String lastNmae, Boolean sex, int age)
        {
            this.firdyNmae = firdyNmae;
            this.lastNmae = lastNmae;
            this.sex = sex;
            this.age = age;

        }

        public Human(String firdyNmae, String lastNmae, Boolean sex, Boolean estDeti, int dlinaVolos)
        {
            this.firdyNmae = firdyNmae;
            this.lastNmae = lastNmae;
            this.sex = sex;
            this.estDeti = estDeti;
            this.dlinaVolos = dlinaVolos;
        }

        public Human(String firdyNmae, String lastNmae, Boolean sex, int age, int dlinaVolos)
        {
            this.firdyNmae = firdyNmae;
            this.lastNmae = lastNmae;
            this.sex = sex;
            this.age = age;
            this.dlinaVolos = dlinaVolos;
        }

        public Human(String firdyNmae, String lastNmae, Boolean sex, int age, Boolean estDeti)
        {
            this.firdyNmae = firdyNmae;
            this.lastNmae = lastNmae;
            this.sex = sex;
            this.age = age;
            this.estDeti = estDeti;

        }

        public Human(String firdyNmae, Boolean sex, int age, Boolean estDeti)
        {
            this.firdyNmae = firdyNmae;
            this.sex = sex;
            this.age = age;
            this.estDeti = estDeti;
        }


    }
}
