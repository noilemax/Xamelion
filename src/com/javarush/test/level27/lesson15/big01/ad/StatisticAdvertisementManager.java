package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance()
    {
        return ourInstance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public List<Advertisement> getActiveVideoSet()
    {
        List<Advertisement> result = new ArrayList<>();
        List<Advertisement> list = advertisementStorage.list();
        for (Advertisement adv : list)
        {
            if (adv.getHits() > 0)
            {

                result.add(adv);
            }
        }
        return result;
    }

    public List<Advertisement> getArchivedVideoSet()
    {
        List<Advertisement> result = new ArrayList<>();
        List<Advertisement> list = advertisementStorage.list();
        for (Advertisement adv : list)
        {
            if (adv.getHits() == 0)
            {

                result.add(adv);
            }
        }
        return result;
    }
}
