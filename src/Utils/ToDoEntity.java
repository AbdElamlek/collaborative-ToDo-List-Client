/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Abd-Elmalek
 */
public class ToDoEntity implements BaseEntity {
    
    private int id;
    private String title;
    private Date assignDate;
    private Date deadLineDate;
    private int ownerId;
    private ArrayList<UserEntity> clllaboratorList;
    private ArrayList<ItemEntity> itemsList;

    public ToDoEntity() {
    }

    public ToDoEntity(int id, String title, Date assignDate, Date deadLineDate, int ownerId) {
        this.id = id;
        this.title = title;
        this.assignDate = assignDate;
        this.deadLineDate = deadLineDate;
        this.ownerId = ownerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public Date getDeadLineDate() {
        return deadLineDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setClllaboratorList(ArrayList<UserEntity> clllaboratorList) {
        this.clllaboratorList = clllaboratorList;
    }

    public ArrayList<UserEntity> getClllaboratorList() {
        return clllaboratorList;
    }

    public void setItemsList(ArrayList<ItemEntity> itemsList) {
        this.itemsList = itemsList;
    }

    public ArrayList<ItemEntity> getItemsList() {
        return itemsList;
    }
    
    
    
    
    
}
