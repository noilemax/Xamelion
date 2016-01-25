package com.javarush.test.level32.lesson15.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * Created by Администратор on 11.01.2016.
 */
public class UndoListener implements UndoableEditListener
{
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager)
    {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e)
    {
        UndoableEdit editEvent = e.getEdit();
        undoManager.addEdit(editEvent);
    }
    //    private UndoManager undoManager;
//
//    public UndoListener(UndoManager undoManager)
//    {
//        this.undoManager = new UndoManager();
//    }
//    @Override
//    public void undoableEditHappened(UndoableEditEvent e)
//    {
//        UndoableEdit edit = e.getEdit();
//        undoManager.addEdit(edit);
////        undoManager.undoableEditHappened(e);
////        undoManager.addEdit(e.getEdit());
//    }
}
