//package com.javarush.test.level27.lesson15.big01.ad;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by ������������� on 11.12.2015.
// */
//class AdvertisementStorage
//{
//
//    private static AdvertisementStorage instance;
//
//    private final List<Advertisement> videos = new ArrayList<>();
//
//    private AdvertisementStorage()
//    {
//        Object someContent = new Object();
//        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
//        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
//        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));   //10 min
//        videos.add(new Advertisement(someContent, "tret'e", 100, 1, 10 * 60));//10���
//        videos.add(new Advertisement(someContent, "4etvertoe", 100, 1, 9 * 60));//9 ���
//        videos.add(new Advertisement(someContent, "pyatoe", 50, 1, 36 * 60));//36 ���
//        videos.add(new Advertisement(someContent, "shestoe", 50, 1, 24 * 60));//24 ���
//        videos.add(new Advertisement(someContent, "Samoe dorogoe Video", 30000, 1, 3 * 60));//12 ���
//    }
//
//    public static AdvertisementStorage getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new AdvertisementStorage();
//        }
//        return instance;
//    }
//
//    public List<Advertisement> list()
//    {
//        return videos;
//    }
//
//    public void add(Advertisement advertisement)
//    {
//        videos.add(advertisement);
//    }
//}