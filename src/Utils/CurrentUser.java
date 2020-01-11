/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import Entities.UserEntity;
/**
 *
 * @author Reham
 */
public class CurrentUser {
    private static UserEntity currentUser;
    
    private CurrentUser(){
        
    }
    
    public static UserEntity getCurrentUser(){
        return currentUser;
    }
    
    public static void setCurrentUser(UserEntity user){
        currentUser = user;
    }
}
