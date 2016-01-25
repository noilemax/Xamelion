package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

/**
 * Created by Администратор on 14.12.2015.
 */

public class Controller
{
//    private Provider[] providers;

    private Model model;

    public Controller(Model model)
    {
        if (model == null)
        {
            throw new IllegalArgumentException("model must be not null");
        }
        this.model = model;
    }

   public void onCitySelect(String cityName)
    {
        model.selectCity(cityName);
    }
}
