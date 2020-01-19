/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.UserEntity;
import com.google.gson.Gson;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmedpro
 */
public class SearchFriendHandler implements ActionHandler {
    
    private static Consumer<UserEntity> consumer;
    
    public static void setSearchingResultGUI(Consumer<UserEntity> mConsumer) {
        consumer = mConsumer;
    }

    @Override
    public void handleAction(String responseJsonObject) {
        try {
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String userEntityJson = jsonObject.getJSONObject("entity").toString();
            UserEntity userEntity = gson.fromJson(userEntityJson, UserEntity.class);
            if (consumer != null) {
                consumer.accept(userEntity);
            }
        } catch (JSONException ex) {
            System.out.println(ex);
        }
    }
    
}
