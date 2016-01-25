//package com.javarush.test.level27.lesson15.big01.ad;
//
//import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
///**
// * Created by ������������� on 11.12.2015.
// */
//
//public class AdvertisementManager
//{
//    private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();//������� ����� ����� �����
//    List<Advertisement> videos = storage.list();
//    int timeSeconds;
//    long maxProfit = 0;
//    int minRemainingTime = timeSeconds;
//    public AdvertisementManager(int timeSeconds)
//    {
//        this.timeSeconds = timeSeconds;
//    }
//    public void processVideos()
//    {
//        List<Advertisement> bestVariant = new ArrayList<>();
//        bestVariant = pickVideosToList(null, null, timeSeconds, 0, bestVariant);
//        long totalAmount = 0;
//        int totalDuration = 0;
//        for (Advertisement ad : bestVariant)
//        {
//            ad.revalidate();
//            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(), ad.getAmountPerOneDisplaying(), ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
//            totalAmount += ad.getAmountPerOneDisplaying();
//            totalDuration += ad.getDuration();
//        }
//    }
//    private List<Advertisement> pickVideosToList(List<Advertisement> previousVideosList, Advertisement previousAd, int remainingTime, long profit, List<Advertisement> bestResult)
//    {
//        List<Advertisement> newList = new ArrayList<>();
//        if (previousVideosList != null)
//        {
//            newList.addAll(previousVideosList);
//            remainingTime -= previousAd.getDuration();
//            profit += previousAd.getAmountPerOneDisplaying();
//            newList.add(previousAd);
//        }
//        for (Advertisement ad : videos)
//        {
//            if (remainingTime == 0)
//                break;
//            if (newList.contains(ad))
//                continue;
//            if (remainingTime >= ad.getDuration())
//            {
//                bestResult = pickVideosToList(newList, ad, remainingTime, profit, bestResult);
//            }
//        }
//        if (profit > maxProfit)
//        {
//            maxProfit = profit;
//            minRemainingTime = remainingTime;
//            bestResult = newList;
//        } else if (profit == maxProfit && remainingTime < minRemainingTime)
//        {
//            minRemainingTime = remainingTime;
//            bestResult = newList;
//        } else if (profit == maxProfit && remainingTime == minRemainingTime && bestResult.size() > newList.size())
//        {
//            bestResult = newList;
//        }
//        if (bestResult.isEmpty())
//        {
//            throw new NoVideoAvailableException();
//        }
//        Collections.sort(bestResult, new Comparator<Advertisement>()
//        {
//            @Override
//            public int compare(Advertisement o1, Advertisement o2)
//            {
//                long pricePerVideoDiff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
//                if (pricePerVideoDiff != 0)
//                    return (int) pricePerVideoDiff;
//                else
//                    return (int) (o1.getAmountPerOneDisplaying() * 100 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 100 / o2.getDuration());
//            }
//        });
//        return bestResult;
//    }
//}