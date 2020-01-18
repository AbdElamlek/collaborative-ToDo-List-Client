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
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmedpro
 */
public class AddFriendHandler implements ActionHandler {
    
    private static Consumer<FriendRequestEntity> consumer;
    
    public static void setAddFriendGUI(Consumer<FriendRequestEntity> mConsumer) {
        consumer = mConsumer;
    }

    @Override
    public void handleAction(String responseJsonObject) {
        
        try {
            Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String friendRequestEntityJson = jsonObject.getJSONObject("entity").toString();
            FriendRequestEntity friendRequestEntity = gson.fromJson(friendRequestEntityJson, FriendRequestEntity.class);
            if (consumer != null) {
                consumer.accept(friendRequestEntity);
            }
        } catch (JSONException ex) {
            System.out.println(ex);
        }
        
    }
    
}
