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
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class WithdrawFromTaskHandler implements ActionHandler{
    
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
                
                for(ToDoEntity todo : CurrentUser.getCurrentUser().getTodoList())
                    if(todo.getId() == todoId)
                        for(ItemEntity item : todo.getItemsList())
                            if(item.getId() == task.getItemId())
                                for(TaskEntity _task : item.getTasksList())
                                    if(_task.getId() == task.getId())
                                        item.getTasksList().remove(_task);
                                
   
            }
                
            } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
