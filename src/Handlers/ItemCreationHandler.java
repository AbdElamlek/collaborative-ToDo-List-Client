/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.ItemEntity;
import Entities.TaskEntity;
import Entities.ToDoEntity;
import Utils.CurrentUser;
import static collaborative.to.pkgdo.list.client.FXMLController.currentToDo;
import com.google.gson.Gson;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class ItemCreationHandler implements ActionHandler{
    
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
                //currentToDo.getItemsList().add(item);
      //          ToDoEntity mToDo = CurrentUser.getCurrentUser().getTodoList().get(CurrentUser.getCurrentUser().getTodoList().indexOf(currentToDo));
        //        mToDo.getItemsList().add(item);
                if(itemGUIGenerator != null){
                    itemGUIGenerator.accept(item);
                }
                
            }else{
                System.out.println("item not added");

                
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
