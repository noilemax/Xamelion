package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Администратор on 27.12.2015.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop
{

    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> names;
    public int count;
    public double profit;
    public List<String> secretData;

    @Override
    public String toString()
    {
        return "Shop{" +
                "name=" + names +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }

    public Shop()
    {
    }
}
