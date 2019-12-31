/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ListingInterface;
import java.util.ArrayList;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public class ListingController implements ListingInterface{

    @Override
    public void viewFriends(ArrayList<JsonObject> friends) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewMyLists(ArrayList<JsonObject> myLists) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewCollaborateLists(ArrayList<JsonObject> myCollaborateLists) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
