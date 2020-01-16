/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.TaskEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class TaskCreationHandler implements ActionHandler{
    
    private static Consumer<TaskEntity> taskGUIGenerator;
    
    public static void setTodoGUIGenerator(Consumer<TaskEntity> generator){
        taskGUIGenerator = generator;
    }
    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            if(!jsonObject.isNull("entity")){
                String todoJsonObject  = jsonObject.getJSONObject("entity").toString();
                TaskEntity task = gson.fromJson(todoJsonObject, TaskEntity.class);
                CurrentUser.getCurrentUser().getTasksList().add(task);
                
                if(taskGUIGenerator != null){
                    taskGUIGenerator.accept(task);
                }
                
            }else{
                System.out.println("task not added");

                
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
