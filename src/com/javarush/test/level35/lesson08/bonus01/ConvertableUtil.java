package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <T extends Convertable>  Map convert(List<T > list){

        Map result = new HashMap();
        for(Convertable<T> key: list ){
                result.put(key.getKey(), key);
    }
        return result;
    }
}
