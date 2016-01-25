package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Администратор on 18.12.2015.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Connection connection : connectionMap.values())
            {
                connection.send(message);
            }

        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("не получилось отправить сообщение");
        }
    }

    public static void main(String[] args)
    {
        ServerSocket ss = null;
        try
        {
            ConsoleHelper.writeMessage("Укажите порт для конекта");// если не будет проходить удалить

            int port = ConsoleHelper.readInt();

            ss = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true)
            {
                Socket socket = ss.accept();
                Handler hendler = new Handler(socket);
                hendler.start();
            }
        }
        catch (Exception e)
        {
            try
            {
                ss.close();
            }
            catch (Exception e1)
            {
                ConsoleHelper.writeMessage("Ошибка при работе сервера");
            }
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
            {
                if (!userName.equals(pair.getKey()))
                {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (MessageType.USER_NAME.equals(message.getType()))
                {
                    String name = message.getData();
                    if (name != null && !"".equals(name) && !connectionMap.containsKey(message.getData()))
                    {
                        connectionMap.put(message.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));

                        return name;
                    }
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    String text = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else
                {
                    ConsoleHelper.writeMessage("Неправильный формат сообщения");
                }
            }
        }

        public void run()
        {
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            String userName = null;
            try (Connection connection = new Connection(socket))
            {
                ConsoleHelper.writeMessage("Подключение установлено" + socketAddress);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом" + socketAddress);
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом" + socketAddress);
            }
            finally
            {
                if (userName != null)
                {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));

                }
            }
            ConsoleHelper.writeMessage("Cоединение с удаленным адресом закрыто");
        }
    }
}

