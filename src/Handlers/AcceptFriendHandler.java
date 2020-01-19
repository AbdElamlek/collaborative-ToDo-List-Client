/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.RequestEntity;
import Entities.UserEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Consumer;
import javafx.application.Platform;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmedpro
 */
public class AcceptFriendHandler implements ActionHandler {
    
    private static Consumer<UserEntity> consumer;
    
    public static void setConsumer(Consumer<UserEntity> mConsumer) {
        consumer = mConsumer;
    }

    @Override
    public void handleAction(String responseJsonObject) {
        try {
            Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String userEntityJson = jsonObject.getJSONObject("entity").toString();
            UserEntity userEntity = gson.fromJson(userEntityJson, UserEntity.class);
            if (consumer != null) {
                Platform.runLater(() -> {
                    consumer.accept(userEntity);
                });
            }
        } catch (JSONException ex) {
            System.out.println(ex);
        }
    }
    
}
