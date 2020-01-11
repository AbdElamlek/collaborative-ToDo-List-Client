/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ActionHandler;
import ControllerBase.ItemInterface;
import Entities.ItemEntity;
import Entities.ToDoEntity;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author OMNIA
 */
public class ItemCreationHandler implements ActionHandler{

    @Override
   public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            System.out.println(responseJsonObject);
            if(!jsonObject.isNull("entity")){
                
                String ItemJsonObject  = jsonObject.getJSONObject("entity").toString();
               
                ItemEntity Item = gson.fromJson(ItemJsonObject, ItemEntity.class);
                
                System.out.println("item added");
                
                System.out.println("id: " + Item.getId());
                // LOGGEDIN SUCCESSFULLY 
            }else{
                System.out.println("Item not added");

                // NOT LOGGEDIN SUCCESSFULLY 
            }
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
