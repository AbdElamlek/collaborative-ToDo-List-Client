/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.CollaboratorDTO;
import Entities.ToDoEntity;
import Entities.UserEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class AcceptCollaboratorRequestHandler implements ActionHandler{
    private static BiConsumer<UserEntity, Integer> collaboratorsGUIModifier;
    
    public static void setCollaboratorsGUIModifier(BiConsumer<UserEntity, Integer> modifier){
        collaboratorsGUIModifier = modifier;
    }
    
    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
        
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            String collaboratorDTOJsonObject  = jsonObject.getJSONObject("entity").toString();
            CollaboratorDTO collaboratorDTO = gson.fromJson(collaboratorDTOJsonObject, CollaboratorDTO.class);
            
            ToDoEntity todo = new ToDoEntity(collaboratorDTO.getTodoId());
            int indexOfTodo;
            
            if(CurrentUser.getCurrentUser().getId() == collaboratorDTO.getSenderID())
                indexOfTodo = CurrentUser.getCurrentUser().getTodoList().indexOf(todo);
            else
                indexOfTodo = CurrentUser.getCurrentUser().getCollaboratorList().indexOf(todo);
            
            CurrentUser.getCurrentUser().getTodoList().get(indexOfTodo).getCollaboratorList().add(collaboratorDTO.getCollaborator());
            CurrentUser.getCurrentUser().getTodoList().get(indexOfTodo).getRequestedCollaboratorList().remove(collaboratorDTO.getCollaborator());
            
            if(collaboratorsGUIModifier != null)
                collaboratorsGUIModifier.accept(collaboratorDTO.getCollaborator(), todo.getId());
            
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
