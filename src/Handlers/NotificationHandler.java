/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import ControllerBase.NotificationInterface;
import Entities.NotificationEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import java.util.function.Consumer;
import javax.json.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class NotificationHandler implements ActionHandler {

    private static Consumer<NotificationEntity> notificationGUIGenerator;

    public static void setNotificationGUIGenerator(Consumer<NotificationEntity> notificationGUIGenerator) {
        NotificationHandler.notificationGUIGenerator = notificationGUIGenerator;
    }

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String notificationJsonObject = jsonObject.getJSONObject("entity").toString();
            NotificationEntity ne = gson.fromJson(notificationJsonObject, NotificationEntity.class);
            System.out.println("client//  recieved notification " + notificationJsonObject);
            if (ne != null) {
                //add notification to UI
                CurrentUser.getCurrentUser().getNotificationList().add(ne);
                if (notificationGUIGenerator != null) {
                    notificationGUIGenerator.accept(ne);
                }

            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

}
