/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

/**
 *
 * @author Abd-Elmalek
 */
public interface ActionHandler { //Strategy in strategy pattern
    public void handleAction(String responseJsonObject);
}
