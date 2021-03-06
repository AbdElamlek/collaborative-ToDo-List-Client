/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.ItemEntity;
import Utils.CurrentUser;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.function.Consumer;
import javafx.application.Platform;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class ItemDeletionHandler implements ActionHandler{

    private static Consumer<ItemEntity> itemGUIGenerator;
    
    public static void setTodoGUIGenerator(Consumer<ItemEntity> generator){
        itemGUIGenerator = generator;
    }
    
    @Override
    public void handleAction(String responseJsonObject) {
         Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            if(!jsonObject.isNull("entity")){
                String todoJsonObject  = jsonObject.getJSONObject("entity").toString();
                ItemEntity item = gson.fromJson(todoJsonObject, ItemEntity.class);
                ArrayList<ItemEntity> itemList = CurrentUser.getCurrentUser().getItemList();
                if(itemList!=null)
                for(ItemEntity mItem : itemList){
                    if(mItem.getId() == item.getId()){
                        itemList.remove(mItem);
                        break;
                    }
                }
                
                if(itemGUIGenerator != null){
                Platform.runLater(()->{
                         itemGUIGenerator.accept(item);
                });
               
                  
                }
                
            }else{
                System.out.println("item not deleted");

                
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
