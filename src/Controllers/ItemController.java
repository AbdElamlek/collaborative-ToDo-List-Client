/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ItemInterface;
import Entities.EntityWrapper;
import Entities.ItemEntity;

/**
 *
 * @author OMNIA
 */
public class ItemController implements ItemInterface{
    
    private SocketController socketController;
    private AdapterController adapterController;

    
     public ItemController() {
        socketController = SocketController.getInstance();
        adapterController = new AdapterController();
    }

    
    
    @Override
    public void createItem(ItemEntity item) {
       String todoJson = adapterController.entity2Json(new EntityWrapper("create item", "ItemEntity", item));
        socketController.sendJsonObject(todoJson);
    }

    @Override
    public void updateItem(ItemEntity item) {
       String todoJson = adapterController.entity2Json(new EntityWrapper("update item", "ItemEntity", item));
        socketController.sendJsonObject(todoJson);
    }

    @Override
    public void deleteItem(ItemEntity item) {
        String todoJson = adapterController.entity2Json(new EntityWrapper("delete item", "ItemEntity", item));
        socketController.sendJsonObject(todoJson);  
      
    }

}
