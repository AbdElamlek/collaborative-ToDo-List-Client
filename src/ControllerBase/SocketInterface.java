/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public interface SocketInterface {
    
    void connect();
    void disconnect();
    boolean sendJsonObject(JsonObject jsonObject); 
    
}
