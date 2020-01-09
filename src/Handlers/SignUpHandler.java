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
 * @author pc
 */
/*Eman Kamal*/
public class SignUpHandler implements ActionHandler {

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String userJsonObject = jsonObject.getJSONObject("entity").toString();
            UserEntity user = gson.fromJson(userJsonObject, UserEntity.class);
            if (user != null) {
                // Registered SUCCESSFULLY 
                System.out.println("client"+user.getId());
                System.out.println("client : recieved user data"+jsonObject);
                
            } else {
                // NOT Registered SUCCESSFULLY 
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
/*Eman Kamal*/
}
