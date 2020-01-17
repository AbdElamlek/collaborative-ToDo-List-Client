/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Utils.CurrentUser;
import Entities.UserEntity;
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
public class LoginHandler implements ActionHandler{
    private static Consumer mainPageNavigator;
    private static Consumer lOGINNOTVALID;
    
    public static void setMainPageNavigator(Consumer navigator){
        mainPageNavigator = navigator;
        System.out.println("settting navigator");
    }
      public static void setNotvalidlogin(Consumer navigator){
        lOGINNOTVALID = navigator;
        System.out.println("notvalid");
    }

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("MMM dd, yyyy h:mm:ss a").create();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            
            if(!jsonObject.isNull("entity")){
                String userJsonObject  = jsonObject.getJSONObject("entity").toString();
                UserEntity user = gson.fromJson(userJsonObject, UserEntity.class);
                
                System.out.println("user found");
                CurrentUser.setCurrentUser(user);
               
                if(mainPageNavigator != null){
                    
                    System.out.println("nooottt nuuulllllllll");
                    mainPageNavigator.accept(null);
                }
                // LOGGEDIN SUCCESSFULLY 
            }else{
                 if(lOGINNOTVALID != null){
                    
                    System.out.println("nooottt nuuulllllllll");
                    lOGINNOTVALID.accept(null);
                }
                System.out.println("user not found");

                // NOT LOGGEDIN SUCCESSFULLY 
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
