package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Администратор on 14.12.2015.
 */
public class Provider
{
    private Strategy strategy;

    public List<Vacancy> getJavaVacancies(String searchString)
    {
        return strategy.getVacancies(searchString);
    }

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }
}
