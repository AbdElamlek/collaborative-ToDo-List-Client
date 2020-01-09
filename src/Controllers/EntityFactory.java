/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.BaseEntity;
import com.google.gson.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public class EntityFactory {
    
    private static EntityFactory Instance = new EntityFactory();

    public static EntityFactory getInstance() {
        return Instance;
    }

    private EntityFactory() {
    }
    
    public static BaseEntity getEntity(JsonObject jsonObject){
    
     return null;
    }
    
}
