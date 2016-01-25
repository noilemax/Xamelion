package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;
import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager
{
    // Полный путь zip файла
    private final Path zipFile;

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception
    {
        // Проверяем, существует ли директория, где будет создаваться архив
        // При необходимости создаем ее
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {

            if (Files.isDirectory(source))
            {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source))
            {

                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else
            {

                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception
    {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath))
        {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception
    {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0)
        {
            out.write(buffer, 0, len);
        }
    }

    public List<FileProperties> getFilesList() throws Exception
    {
        if (!Files.isRegularFile(zipFile))
        {
            throw new WrongZipFileException();
        }
        FileProperties fp = null;
        List<FileProperties> list = null;
        ZipEntry entry;
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile)))
        {
            byte[] buffer = new byte[2048];

            while ((entry = zipInputStream.getNextEntry()) != null)
            {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int l = 0;

                String name;
                long size;
                long compressedSize;
                int compressionMethod;
//                long compressionRatio;
                while ((l = zipInputStream.read(buffer)) > 0)
                {
                    baos.write(buffer);
                    copyData(zipInputStream, baos);
                    name = entry.getName();
                    size = entry.getSize();
                    compressedSize = entry.getCompressedSize();
                    compressionMethod = entry.getMethod();
//                    compressionRatio = entry.getMethod();
                    list.add(new FileProperties(name, size, compressedSize, compressionMethod));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
//class ZipEntry implements ZipConstants, Cloneable {
//    String name;        // entry name
//    long size = -1;     // uncompressed size of entry data
//    long csize = -1;    // compressed size of entry data
//    int method = -1;    // compression method