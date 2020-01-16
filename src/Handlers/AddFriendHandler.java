/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.FriendRequestEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmedpro
 */
public class AddFriendHandler implements ActionHandler {

    @Override
    public void handleAction(String responseJsonObject) {
        
        try {
            Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String friendRequestEntityJson = jsonObject.getJSONObject("entity").toString();
            FriendRequestEntity friendRequestEntity = gson.fromJson(friendRequestEntityJson, FriendRequestEntity.class);
            if (friendRequestEntity.getId() == -1) {
                System.out.println("your request is already sent");
            } else {
                System.out.println("you have a friend request from ");
            }
        } catch (JSONException ex) {
            System.out.println(ex);
        }
        
    }
    
}
