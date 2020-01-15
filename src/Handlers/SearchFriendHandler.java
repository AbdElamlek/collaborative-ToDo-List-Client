/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.UserEntity;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmedpro
 */
public class SearchFriendHandler implements ActionHandler {

    @Override
    public void handleAction(String responseJsonObject) {
        try {
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String userEntityJson = jsonObject.getJSONObject("entity").toString();
            UserEntity userEntity = gson.fromJson(userEntityJson, UserEntity.class);
            switch (userEntity.getId()) {
                case -1:
                    System.out.println("the user name is not exist");
                    break;
                case -2:
                    System.out.println("the user is already exist in your list");
                    break;
                case -3:
                    System.out.println("its your user name");
                    break;
                default:
                    System.out.println("the user name is => " + userEntity.getId());
                    break;
            }
        } catch (JSONException ex) {
            System.out.println(ex);
        }
    }
    
}
