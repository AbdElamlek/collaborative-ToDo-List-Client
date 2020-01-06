/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ActionHandler;
import Utils.UserEntity;
import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class LoginHandler implements ActionHandler{

    @Override
    public void handleAction(String responseJsonObject) {
        System.out.println("******LoginHandler");
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String userJsonObject  = jsonObject.getJSONObject("entity").toString();
            UserEntity user = gson.fromJson(userJsonObject, UserEntity.class);
            
            if(user != null){
                System.out.println("user found");
                // LOGGEDIN SUCCESSFULLY 
            }else{
                System.out.println("user not found");

                // NOT LOGGEDIN SUCCESSFULLY 
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
