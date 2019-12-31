/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import Utils.BaseEntity;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public interface AdapterInterface {
    
    
    JsonObject entity2Json(BaseEntity entity);
    BaseEntity json2Entity(JsonObject json);
}
