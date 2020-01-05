/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ActionHandler;
import ControllerBase.NotificationInterface;
import Utils.NotificationEntity;
import com.google.gson.Gson;
import javax.json.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class NotificationHandler implements ActionHandler{

   

    @Override
    public void handleAction(String responseJsonObject) {
         Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String notificationJsonObject = jsonObject.getJSONObject("entity").toString();
            NotificationEntity notification = gson.fromJson(notificationJsonObject, NotificationEntity.class);
            if (notification != null) {
               //add notification to UI
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
