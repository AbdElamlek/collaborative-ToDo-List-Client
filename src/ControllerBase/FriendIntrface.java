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
public interface FriendIntrface {
    
  void addFreind(JsonObject friend);
  void removeFreind(JsonObject friend);
  void acceptFriendReauest(JsonObject request);
  void declineFriendReauest(JsonObject request);
    
}
