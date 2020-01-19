/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.ToDoEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class ToDoDeleteHandler implements ActionHandler{
    private static Consumer<Integer> todoGUIModifier;
    
    public static void setTodoGUIModifier(Consumer<Integer> modifier){
        todoGUIModifier = modifier;
    }

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            String todoJsonObject  = jsonObject.getJSONObject("entity").toString();
            ToDoEntity todo = gson.fromJson(todoJsonObject, ToDoEntity.class);
            
            int indexOfTodo = CurrentUser.getCurrentUser().getCollaboratorList().indexOf(todo);
            CurrentUser.getCurrentUser().getCollaboratorList().remove(indexOfTodo);
            
            //Update GUI
            if(todoGUIModifier != null)
                todoGUIModifier.accept(todo.getId());
            
        }catch(JSONException ex){
            ex.printStackTrace();
        }    
    }
    
}
