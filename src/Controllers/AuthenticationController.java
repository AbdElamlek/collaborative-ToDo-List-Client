/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.AuthenticationInterface;
import Utils.EntityWrapper;
import Utils.UserEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public class AuthenticationController implements AuthenticationInterface{
    
    GsonBuilder gsonBuilder;
    Gson gson;
    SocketController socketController;
    
    public AuthenticationController() {
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        socketController = SocketController.getInstance();
    }

    @Override
    public void logIn(String username, String password) {
        String userJson = gson.toJson(new EntityWrapper("logIn", "UserEntity", new UserEntity(username, password)));
        socketController.sendJsonObject(userJson);
    }
    
    @Override
    public void SignUp(JsonObject user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
