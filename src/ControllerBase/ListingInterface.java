/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import java.util.ArrayList;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public interface ListingInterface {
    
     void viewFriends(ArrayList<JsonObject> friends);
     void viewMyLists(ArrayList<JsonObject> myLists);
     void viewCollaborateLists(ArrayList<JsonObject> myCollaborateLists);
    
}
