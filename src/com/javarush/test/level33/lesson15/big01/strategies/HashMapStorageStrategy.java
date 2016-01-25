package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 27.12.2015.
 */
public class HashMapStorageStrategy implements StorageStrategy
{
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key)
    {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value)
    {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value)
    {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value)
    {
        Long result = 0L;
        for (Map.Entry<Long, String> me : data.entrySet())
        {
            if (value.equals(me.getValue()))
            {
                result = me.getKey();
            }
        }
        return result;
    }

    @Override
    public String getValue(Long key)
    {
        return data.get(key);
    }
}
