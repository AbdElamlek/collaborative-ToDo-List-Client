/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.AdapterInterface;
import Utils.BaseEntity;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public class AdapterController implements AdapterInterface{

    @Override
    public JsonObject entity2Json(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BaseEntity json2Entity(JsonObject json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
