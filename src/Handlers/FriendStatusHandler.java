/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.UserEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class FriendStatusHandler implements ActionHandler{

    private static Consumer<UserEntity> friendStatusGUIModifier;
    
    public static void setFriendStatusGUIModifier(Consumer<UserEntity> modifier){
        friendStatusGUIModifier = modifier;
    }
    
    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
        try {
            
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String todoJsonObject  = jsonObject.getJSONObject("entity").toString();
            
            UserEntity friend = gson.fromJson(todoJsonObject, UserEntity.class);
            
            if(friendStatusGUIModifier != null)
                friendStatusGUIModifier.accept(friend);
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
