/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ToDoListInterface;
import Entities.EntityWrapper;
import Entities.ToDoEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public class ToDoListController implements ToDoListInterface {

    private SocketController socketController;
    private AdapterController adapterController;

    
    public ToDoListController() {
        socketController = SocketController.getInstance();
        adapterController = new AdapterController();
    }

    @Override
    public void createToDoList(ToDoEntity todo) {
        String todoJson = adapterController.entity2Json(new EntityWrapper("create todo list", "ToDoEntity", todo));
        socketController.sendJsonObject(todoJson);
    }

    @Override
    public void updateToDoList(ToDoEntity todo) {
        String todoJson = adapterController.entity2Json(new EntityWrapper("update todo list", "ToDoEntity", todo));
        socketController.sendJsonObject(todoJson);
    }

    @Override
    public void deleteToDoList(ToDoEntity todo) {
        String todoJson = adapterController.entity2Json(new EntityWrapper("delete todo list", "ToDoEntity", todo));
        socketController.sendJsonObject(todoJson);    }
    
}
