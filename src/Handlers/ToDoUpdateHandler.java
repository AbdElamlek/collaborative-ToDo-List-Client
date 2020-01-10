/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.ToDoEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class ToDoUpdateHandler implements ActionHandler{

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            String todoJsonObject  = jsonObject.getJSONObject("entity").toString();
            ToDoEntity todo = gson.fromJson(todoJsonObject, ToDoEntity.class);
            
            //send todo object to function in GUIController, it will check if the receiver is one of the collaborators of not
        }catch(JSONException ex){
            ex.printStackTrace();
        }
    }
    
}
