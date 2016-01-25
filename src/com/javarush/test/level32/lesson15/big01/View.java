package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Администратор on 25.12.2015.
 */
public class View extends JFrame implements ActionListener
{

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
    }

    public void initMenuBar()
    {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor()
    {
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(800, 600));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);


    }

    public void initGui()
    {
        initMenuBar();
        initEditor();
        pack();
    }


    public void exit()
    {
        controller.exit();
    }

    public void init()
    {

        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);

    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String actionPerformed = e.getActionCommand();
        switch (actionPerformed)
        {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }

    public void selectedTabChanged()
    {

        if (isHtmlTabSelected())
        {
            controller.setPlainText(plainTextPane.getText());
        } else
        {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    public void undo()
    {
        try
        {
            undoManager.undo();
        }
        catch (CannotUndoException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void redo()
    {
        try
        {
            undoManager.redo();
        }
        catch (CannotUndoException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void resetUndo()
    {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected()
    {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab()
    {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update()
    {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout()
    {
//        JOptionPane.showMessageDialog(this, "v1.0  \n created by Xamelion", "HTML Editor", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, "HTML Editor 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }
}