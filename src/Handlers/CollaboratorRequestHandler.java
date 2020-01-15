/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.CollaborationRequestEntity;
import Entities.UserEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author pc
 */
public class CollaboratorRequestHandler implements ActionHandler {

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String requestJsonObject = jsonObject.getJSONObject("entity").toString();
            CollaborationRequestEntity cre = gson.fromJson(requestJsonObject, CollaborationRequestEntity.class);
            System.out.println("client reciever: "+cre.getReceivedUserId()+"\n" +  "collaborator recieved request " + requestJsonObject);
            if (cre != null) {
                //add request to UI
                 CurrentUser.getCurrentUser().getRequestList().add(cre);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

}
