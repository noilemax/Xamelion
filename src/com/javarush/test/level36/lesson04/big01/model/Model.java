package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Администратор on 04.01.2016.
 */
public interface Model
{
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    void loadUserById(long userId);

    void deleteUserById(long id);
}
