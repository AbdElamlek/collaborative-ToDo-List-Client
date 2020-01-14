/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Utils.CurrentUser;
import Entities.ToDoEntity;
import Entities.UserEntity;
import com.google.gson.Gson;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class ToDoCreationHandler implements ActionHandler{
    private static BiConsumer<ToDoEntity, Boolean> todoGUIGenerator;
    
    public static void setTodoGUIGenerator(BiConsumer<ToDoEntity, Boolean> generator){
        todoGUIGenerator = generator;
    }
    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            System.out.println(responseJsonObject);
            if(!jsonObject.isNull("entity")){
                String todoJsonObject  = jsonObject.getJSONObject("entity").toString();
                ToDoEntity todo = gson.fromJson(todoJsonObject, ToDoEntity.class);
                
                Boolean isOwner = todo.getOwnerId() == CurrentUser.getCurrentUser().getId();
             
                System.out.println("owner id :" + todo.getOwnerId());
                System.out.println("current id : " + CurrentUser.getCurrentUser().getId());
                if(isOwner)
                    CurrentUser.getCurrentUser().getTodoList().add(todo);
                else
                    CurrentUser.getCurrentUser().getCollaboratorList().add(todo);
                
                if(todoGUIGenerator != null){
                    System.out.println("todo added");
                    todoGUIGenerator.accept(todo, isOwner);
                }
                
                System.out.println("id: " + todo.getId());
                
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    }
    

