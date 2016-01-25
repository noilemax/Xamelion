package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution
{
   /* public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("c:\\a.txt");
        ObjectOutputStream oo = new ObjectOutputStream(fos);
        Apartment ap1 = new Apartment("sdfgsdfg 34", 1985);
        ap1.writeExternal(oo);
        System.out.println(ap1.toString());
        oo.close();

        FileInputStream fis = new FileInputStream("c:\\a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Apartment ap2 = new Apartment();
        ap2.readExternal(ois);
        System.out.println(ap2.toString());
        ois.close();
        fis.close();
    }*/

    public static class Apartment implements Externalizable
    {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment()

        {
            super();
        }

        public Apartment(String adr, int y)
        {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString()
        {
            return ("Address: " + address + "\n" + "Year: " + year);
        }


        @Override
        public void writeExternal(ObjectOutput oo) throws IOException
        {
            oo.writeObject(address);
            oo.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput ois) throws IOException, ClassNotFoundException
        {
            address = (String) ois.readObject();
            year = ois.readInt();
        }
    }
}
