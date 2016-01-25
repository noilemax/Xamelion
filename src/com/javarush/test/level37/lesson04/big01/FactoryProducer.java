package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Администратор on 12.01.2016.
 */
public class FactoryProducer
{
    public static enum HumanFactoryType
    {
        MALE,
        FEMALE,
    }

    public static AbstractFactory getFactory(HumanFactoryType type)
    {
        if (type == HumanFactoryType.FEMALE) return new FemaleFactory();
        if (type == HumanFactoryType.MALE) return new MaleFactory();
        return null;
    }
}
