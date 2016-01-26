package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DirectorTablet
{
    private DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    public void printAdvertisementProfit()
    {
        double total = 0d;
        for (Map.Entry<Date, Double> entry : StatisticManager.getInstance().getAdRevenue().entrySet())
        {
            double profit = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", df.format(entry.getKey()), profit));
            total += profit;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }
    public void printCookWorkloading()
    {
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticManager.getInstance().getCookWorkload().entrySet())
        {
            ConsoleHelper.writeMessage(df.format(entry.getKey()));
            for (Map.Entry<String, Integer> cooksEntry : entry.getValue().entrySet())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cooksEntry.getKey(), cooksEntry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }
    public void printActiveVideoSet()
    {
    }
    public void printArchivedVideoSet()
    {
    }
}