/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import Entities.ToDoEntity;
import java.util.Date;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public interface ToDoListInterface {
   void createToDoList(ToDoEntity todo);
   void updateToDoList(ToDoEntity todo);
   void deleteToDoList(ToDoEntity todo);
   
}
