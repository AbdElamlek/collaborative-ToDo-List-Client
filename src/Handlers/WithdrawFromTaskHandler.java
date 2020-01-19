/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import DTOs.Accept_RejectTaskDTO;
import Entities.ItemEntity;
import Entities.TaskEntity;
import Entities.ToDoEntity;
import Entities.UserEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class WithdrawFromTaskHandler implements ActionHandler{
    private static Consumer<UserEntity> assignedToTaskGUIModifier;
    public  static void setAssignedToTaskGUIModifier(Consumer<UserEntity> modifier){
        assignedToTaskGUIModifier = modifier;
    }
    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            
            if(!jsonObject.isNull("entity")){
                String userJsonObject  = jsonObject.getJSONObject("entity").toString();
                Accept_RejectTaskDTO accept_RejectTaskDTO = gson.fromJson(userJsonObject, Accept_RejectTaskDTO.class);
                
                int todoId = accept_RejectTaskDTO.getTodoId();
                int userId = accept_RejectTaskDTO.getUserId();
                TaskEntity task = accept_RejectTaskDTO.getTask();
                
                CurrentUser.getCurrentUser().getTodoList().stream().filter((todo) -> (todo.getId() == todoId)).forEachOrdered((todo) -> {
                    todo.getItemsList().stream().filter((item) -> (item.getId() == task.getItemId())).forEachOrdered((item) -> {
                        item.getTasksList().stream().filter((_task) -> (_task.getId() == task.getId())).forEachOrdered((_task) -> {
                            _task.getAssignedUsersList().stream().filter((user) -> (user.getId() == userId)).forEachOrdered((user) -> {
                                _task.getAssignedUsersList().remove(user);
                                if(assignedToTaskGUIModifier != null)
                                    assignedToTaskGUIModifier.accept(user);
                            });
                        });
                    });
                });
                                                
                                     
                                
   
            }
                
            } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
