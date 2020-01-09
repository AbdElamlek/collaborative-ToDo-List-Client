/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.FriendIntrface;
import Entities.EntityWrapper;
import Entities.RequestEntity;
import javax.json.JsonObject;

/**
 *
 * @author ahmedpro
 */
public class FriendController implements FriendIntrface {

    private int sentUserId;
    private AdapterController adapterController;
    private SocketController socketController;

    public FriendController(int userId) {
        this.sentUserId = userId;
        adapterController = new AdapterController();
        socketController = SocketController.getInstance();
    }

    @Override
    public void addFreind(JsonObject friend) {
        try {
            int receivedUserId = friend.getInt("id");
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            EntityWrapper entityWrapper = new EntityWrapper("addFriend", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void removeFreind(JsonObject friend) {
        try {
            int receivedUserId = friend.getInt("id");
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            EntityWrapper entityWrapper = new EntityWrapper("removeFriend", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void acceptFriendReauest(JsonObject request) {
        try {
            int receivedUserId = request.getInt("id");
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            EntityWrapper entityWrapper = new EntityWrapper("acceptFriendReauest", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void declineFriendReauest(JsonObject request) {
        try {
            int receivedUserId = request.getInt("id");
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setSentUserId(sentUserId);
            requestEntity.setReceivedUserId(receivedUserId);
            EntityWrapper entityWrapper = new EntityWrapper("declineFriendReauest", "RequestEntity", requestEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            socketController.sendJsonObject(taskJsonResponse);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
