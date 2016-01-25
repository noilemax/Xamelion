package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Администратор on 25.12.2015.
 */
public class RedoAction extends AbstractAction
{
    private View view;

    public RedoAction(View view)
    {
        this.view = view;
    }

    public void UndoAction(View view)
    {
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.redo();
    }
}
