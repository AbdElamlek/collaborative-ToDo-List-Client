/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ToDoListInterface;
import Utils.EntityWrapper;
import Utils.ToDoEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public class ToDoListController implements ToDoListInterface {
    GsonBuilder gsonBuilder;
    Gson gson;
    SocketController socketController;
    
    public ToDoListController() {
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        socketController = SocketController.getInstance();
    }

    @Override
    public void createToDoList(String title, Date deadline, int ownerId, int status) {
        Date assignDate = new Date();
        String todoJson = gson.toJson(new EntityWrapper("create todo list", "ToDoEntity", new ToDoEntity(title, assignDate, deadline, ownerId, status)));
        socketController.sendJsonObject(todoJson);
    }

    @Override
    public void updateToDoList(ToDoEntity todo) {
        String todoJson = gson.toJson(new EntityWrapper("update todo list", "ToDoEntity", todo));
        socketController.sendJsonObject(todoJson);
    }

    @Override
    public void deleteToDoList(ToDoEntity todo) {
        String todoJson = gson.toJson(new EntityWrapper("delete todo list", "ToDoEntity", todo));
        socketController.sendJsonObject(todoJson);    }
    
}
