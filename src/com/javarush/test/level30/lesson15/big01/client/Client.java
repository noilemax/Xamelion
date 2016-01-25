package com.javarush.test.level30.lesson15.big01.client;


import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Администратор on 20.12.2015.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }


    public class SocketThread extends Thread
    {

        public void run()
        {
            String adres = getServerAddress();
            int port = getServerPort();

            try
            {
                Socket socket = new Socket(adres, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);

            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);

            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST)
                {
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, name));
                } else if (message.getType() == MessageType.NAME_ACCEPTED)
                {
                    notifyConnectionStatusChanged(true);
                    return;
                } else
                {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {

            while (true)
            {
                Message message = connection.receive();

                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }


    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();

        socketThread.setDaemon(true);

        socketThread.start(); // можно start

        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Ошибка Соединеия");
            return;
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }


        while (clientConnected)
        {
            String message;
            if (!(message = ConsoleHelper.readString()).equals("exit"))
            {
                if (shouldSentTextFromConsole())
                {
                    sendTextMessage(message);
                }
            } else
            {
                return;
            }
        }
    }
}