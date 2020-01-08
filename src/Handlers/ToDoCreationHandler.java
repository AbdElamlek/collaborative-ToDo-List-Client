/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Utils.ToDoEntity;
import Utils.UserEntity;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Reham
 */
public class ToDoCreationHandler implements ActionHandler{

    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            System.out.println(responseJsonObject);
            if(!jsonObject.isNull("entity")){
                String todoJsonObject  = jsonObject.getJSONObject("entity").toString();
                ToDoEntity todo = gson.fromJson(todoJsonObject, ToDoEntity.class);
                
                System.out.println("todo added");
                
                System.out.println("id: " + todo.getId());
                // LOGGEDIN SUCCESSFULLY 
            }else{
                System.out.println("todo not added");

                // NOT LOGGEDIN SUCCESSFULLY 
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    }
    

