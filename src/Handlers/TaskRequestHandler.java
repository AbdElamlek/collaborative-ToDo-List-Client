/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.Accept_RecjectTaskEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author pc
 */
public class TaskRequestHandler implements ActionHandler{

    private static Consumer<Accept_RecjectTaskEntity> taskRequestGUIGenerator;

    public static void setTaskRequestGUIGenerator(Consumer<Accept_RecjectTaskEntity> taskRequestGUIGenerator) {
        TaskRequestHandler.taskRequestGUIGenerator = taskRequestGUIGenerator;
    }

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            String requestJsonObject = jsonObject.getJSONObject("entity").toString();
            Accept_RecjectTaskEntity accept_RecjectTaskEntity = gson.fromJson(requestJsonObject, Accept_RecjectTaskEntity.class);
            System.out.println("client reciever: " + accept_RecjectTaskEntity.getReceivedUserId() + "\n" + "task recieved request " + requestJsonObject);
            if (accept_RecjectTaskEntity != null) {
                //add request to UI
                CurrentUser.getCurrentUser().getTaskAssignmentRequestList().add(accept_RecjectTaskEntity);             
                if (taskRequestGUIGenerator!= null) {
                    taskRequestGUIGenerator.accept(accept_RecjectTaskEntity);
                }
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
