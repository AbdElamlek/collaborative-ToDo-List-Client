/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import Entities.ItemEntity;
import Entities.RequestEntity;
import Entities.TaskEntity;
import Entities.ToDoEntity;
import Entities.UserEntity;

/**
 *
 * @author Omnia
 */
public interface ItemInterface {
    void createItem(ItemEntity Item);
    void updateItem(ItemEntity Item);
    void deleteItem(ItemEntity Item);
}
