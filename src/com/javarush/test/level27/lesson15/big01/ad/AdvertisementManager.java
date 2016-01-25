package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

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
        ConsoleHelper.writeMessage("processVideos method calling");
    }
}
