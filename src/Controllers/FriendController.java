/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.EntityWrapper;
import Entities.RequestEntity;
import Entities.UserEntity;
import java.sql.Date;

/**
 *
 * @author ahmedpro
 */
public class FriendController {

    private FriendController() {
    }

    public static void searchFriend(String userName) {
        AdapterController adapterController = new AdapterController();
        SocketController socketController = SocketController.getInstance();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        EntityWrapper entityWrapper
                = new EntityWrapper("searchFriend", "UserEntity", userEntity);
        String entityWrapperJson = adapterController.entity2Json(entityWrapper);
        socketController.sendJsonObject(entityWrapperJson);
    }

    public static void addFreind(int sentUserId, int receivedUserId) {
        try {
            AdapterController adapterController = new AdapterController();
            SocketController socketController = SocketController.getInstance();
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            requestEntity.setTime(new Date(System.currentTimeMillis()));
            EntityWrapper entityWrapper = new EntityWrapper("addFriend", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void deleteFreind(int sentUserId, int receivedUserId) {
        try {
            AdapterController adapterController = new AdapterController();
            SocketController socketController = SocketController.getInstance();
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            EntityWrapper entityWrapper = new EntityWrapper("deleteFriend", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void acceptFriendReauest(int sentUserId, int receivedUserId) {
        try {
            AdapterController adapterController = new AdapterController();
            SocketController socketController = SocketController.getInstance();
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            EntityWrapper entityWrapper = new EntityWrapper("acceptFriend", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void declineFriendReauest(int sentUserId, int receivedUserId) {
        try {
            AdapterController adapterController = new AdapterController();
            SocketController socketController = SocketController.getInstance();
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            EntityWrapper entityWrapper = new EntityWrapper("declineFriend", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
