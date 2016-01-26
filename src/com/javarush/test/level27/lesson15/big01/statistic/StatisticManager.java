package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private static StatisticManager.StatisticStorage storage = new StatisticStorage();
    private static Set<Cook> set=new HashSet<>();

    public static StatisticManager getInstance() { return ourInstance; }

    private StatisticManager() {}

    public void register(EventDataRow data) {
        storage.put(data);
    }

    public void register(Cook cook) {
        set.add(cook);
    }

    private static class StatisticStorage {
        Map<EventType, List<EventDataRow>> map = new HashMap<>();

        private StatisticStorage() {
            for (EventType type : EventType.values())
                map.put(type, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data) {
            map.get(data.getType()).add(data);
        }
    }
}