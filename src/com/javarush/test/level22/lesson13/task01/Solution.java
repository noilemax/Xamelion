package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> string = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            string.add(token);

        }
        String[] s = new String[string.size()];
        return string.toArray(s);
    }
}
