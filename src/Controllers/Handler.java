/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ActionHandler;

/**
 *
 * @author Reham
 */
public class Handler { //Context in strategy pattern
    private ActionHandler actionHandler;
    
    public Handler(ActionHandler actionHandler){
        this.actionHandler = actionHandler;
    }
    
    public void handleAction(String responseJsonObject){
        if(actionHandler == null)
            System.out.println("NUULLL");
        actionHandler.handleAction(responseJsonObject);
    }
}
