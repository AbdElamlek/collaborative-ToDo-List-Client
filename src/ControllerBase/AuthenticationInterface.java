/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import Entities.UserEntity;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public interface AuthenticationInterface {
    
    void logIn(String username, String password);
    void SignUp(UserEntity userEntity);
    
}
