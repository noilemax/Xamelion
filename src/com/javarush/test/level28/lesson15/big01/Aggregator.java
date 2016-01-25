package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by Администратор on 14.12.2015.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HtmlView view = new HtmlView();
        Provider providerHH = new Provider(new HHStrategy());
        Provider providerLinkedIn = new Provider(new MoikrugStrategy());
        Model model = new Model(view, new Provider[] {providerHH, providerLinkedIn});
        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();

    }
}


//3.1. Создай вью, модель, контроллер.
//        3.2. Засэть во вью контроллер.
//        3.3. Вызови у вью метод  userCitySelectEmulationMethod.