package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.Controller;

import javax.swing.*;

public class View extends JFrame
{
    private Controller controller;

    public View(Controller controller)
    {
        this.controller = controller;
    }
}
