package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by Администратор on 06.01.2016.
 */
public class EditUserView implements View
{
    private Controller controller;
    UsersView usersView;
    Model model;

    @Override
    public void refresh(ModelData modelData)
    {
        System.out.println("User to be edited:");
        User activeUser = modelData.getActiveUser();
        System.out.println("\t" + activeUser);
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller)
    {
//        this.controller = controller;
    }

    public void fireEventUserDeleted(long id)
    {
        controller.onUserDelete(id);
//        usersView.refresh(model.getModelData());
    }
}
