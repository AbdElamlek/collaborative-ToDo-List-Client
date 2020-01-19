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
    
  void searchFriend(String userName);
  void addFreind(int sentUserId, int receivedUserId);
  void deleteFreind(int sentUserId, int receivedUserId);
  void acceptFriendReauest(int sentUserId, int receivedUserId);
  void declineFriendReauest(int sentUserId, int receivedUserId);
    
}
