package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Администратор on 23.01.2016.
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);
    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString()
    {
        String dish_s = "";
        for (Dish s : Dish.values())
            dish_s += s + ", ";
        return (dish_s.length() != 0) ? dish_s.substring(0, dish_s.lastIndexOf(",")) : "";

//
//        StringBuilder sb = new StringBuilder(Arrays.toString(values()));
//        sb.delete(sb.length() - 1, sb.length());
//        sb.delete(0, 1);
//        return sb.toString();
    }

}
