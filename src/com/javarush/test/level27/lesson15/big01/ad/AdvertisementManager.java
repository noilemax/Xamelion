package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Администратор on 23.01.2016.
 */
public class AdvertisementManager
{
    private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        List<Advertisement> advertisements = new ArrayList<>();
        int leftSeconds = timeSeconds;
        for (Advertisement advertisement : storage.list())
            if (advertisement.getDuration() <= leftSeconds)
            {
                advertisements.add(advertisement);
                leftSeconds -= advertisement.getDuration();
            }
        if (advertisements.isEmpty() || leftSeconds == timeSeconds)
            throw new NoVideoAvailableException();
        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return (int) (o2.getAmountPerOneDisplaying() != o1.getAmountPerOneDisplaying() ?
                        o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying() :
                        o1.getAmountPerOneDisplaying() * 1000.0 / o1.getDuration() -
                                o2.getAmountPerOneDisplaying() * 1000.0 / o2.getDuration());
            }
        });
        for (Advertisement advertisement : advertisements)
        {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
            advertisement.revalidate();
        }
    }
}
