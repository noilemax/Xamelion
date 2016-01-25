package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Администратор on 25.12.2015.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument()
    {
        return document;
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init()
    {
        createNewDocument();
    }

    public Controller(View view)
    {
        this.view = view;
    }

    public void exit()
    {
        System.exit(0);
    }

    public void resetDocument()
    {
        if (document != null)
        {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text)
    {
        resetDocument();
        StringReader reader = new StringReader(text);
        try
        {
            new HTMLEditorKit().read(reader, document, 0);
        }
        catch (IOException | BadLocationException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText()
    {
        StringWriter writer = new StringWriter();
        try
        {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        }
        catch (IOException | BadLocationException e)
        {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument()
    {
        view.selectHtmlTab();
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new HTMLFileFilter());
        int n = jfc.showOpenDialog(view);
        if (n == JFileChooser.APPROVE_OPTION)
        {
            currentFile = jfc.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader fr = new FileReader(currentFile))
            {
                new HTMLEditorKit().read(fr, document, 0);
                view.resetUndo();
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument()
    {
        view.selectHtmlTab();
        if (currentFile == null)
            saveDocumentAs();
        else
            try (FileWriter fw = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fw, document, 0, document.getLength());
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
    }

    public void saveDocumentAs()
    {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int n = jFileChooser.showSaveDialog(view);

        if (n == JFileChooser.APPROVE_OPTION)
        {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }
            catch (BadLocationException | IOException e)
            {
                ExceptionHandler.log(e);
            }

        }
    }
}