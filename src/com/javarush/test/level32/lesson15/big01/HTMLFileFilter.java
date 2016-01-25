package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Администратор on 12.01.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        String fileName = f.getName().toLowerCase();
        if (f.isDirectory()) return true;
        else
            return fileName.endsWith(".html") || fileName.endsWith(".htm");


    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
