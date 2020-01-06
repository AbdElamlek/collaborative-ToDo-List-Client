/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import Utils.ToDoEntity;
import java.util.Date;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public interface ToDoListInterface {
   void createToDoList(String title, Date deadline, int ownerId, int status);
   void updateToDoList(ToDoEntity todo);
   void deleteToDoList(ToDoEntity todo);
   
}
