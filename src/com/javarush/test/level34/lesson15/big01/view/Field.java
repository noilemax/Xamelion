package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.model.Box;
import com.javarush.test.level34.lesson15.big01.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel
{
    private View view;

    public Field(View view)
    {
        this.view = view;
    }

    @Override
    public void paint(Graphics g)
    {
        Box box = new Box(3, 3);
        Player player = new Player(5, 5);
    }
}
//Для того чтобы проверить как рисуется твой ящик или игрок, ты можешь создать
//объект типа Box или Player в методе paint() класса Field и вызвать у объекта метод
//    draw(). Сделай это исключительно для проверки методов draw(), в дальнейшем метод
//        paint() мы реализуем иначе.