/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Utils.CurrentUser;
import Utils.ToDoEntity;
import Utils.UserEntity;
import com.google.gson.Gson;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class ToDoCreationHandler implements ActionHandler{
    private static Consumer<ToDoEntity> todoGUIGenerator;
    
    public static void setTodoGUIGenerator(Consumer<ToDoEntity> generator){
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
                CurrentUser.getCurrentUser().getTodoList().add(todo);
                
                if(todoGUIGenerator != null){
                    System.out.println("todo added");
                    todoGUIGenerator.accept(todo);
                }
                
                
                System.out.println("id: " + todo.getId());
                
            }else{
                System.out.println("todo not added");

                
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    }
    

