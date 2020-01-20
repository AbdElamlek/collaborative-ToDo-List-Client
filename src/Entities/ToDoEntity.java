/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
    private int status;
    private String color;
    private ArrayList<UserEntity> collaboratorList;
    private ArrayList<UserEntity> requestedCollaboratorList;
    private ArrayList<ItemEntity> itemsList;

    public ToDoEntity() {
    }
    
    public ToDoEntity(int id) {
        this.id = id;
    }

    public ToDoEntity(int id, String title, Date assignDate, Date deadLineDate, int ownerId, int status, String color) {
        this.id = id;
        this.title = title;
        this.assignDate = assignDate;
        this.deadLineDate = deadLineDate;
        this.ownerId = ownerId;
        this.status = status;
        this.color = color;
    }

    public ToDoEntity(String title, Date assignDate, Date deadLineDate, int ownerId, int status, String color){
        this.title = title;
        this.assignDate = assignDate;
        this.deadLineDate = deadLineDate;
        this.ownerId = ownerId;
        this.status = status;
        this.color = color;
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

    public void setCollaboratorList(ArrayList<UserEntity> collaboratorList) {
        this.collaboratorList = collaboratorList;
    }

    public ArrayList<UserEntity> getCollaboratorList() {
       if(collaboratorList==null)
           collaboratorList=new ArrayList<>();
        return collaboratorList;
    }

    public void setItemsList(ArrayList<ItemEntity> itemsList) {
        this.itemsList = itemsList;
    }

    public ArrayList<ItemEntity> getItemsList() {
        
         if(itemsList==null)
         itemsList=new ArrayList<>();   
        return itemsList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public boolean equals(Object todo){
        return (this.id == ((ToDoEntity)todo).id);
    }

    public ArrayList<UserEntity> getRequestedCollaboratorList() {
       if(requestedCollaboratorList==null)
         requestedCollaboratorList=new ArrayList<>();   
        return requestedCollaboratorList;
    }

    public void setRequestedCollaboratorList(ArrayList<UserEntity> requestedCollaboratorList) {
        this.requestedCollaboratorList = requestedCollaboratorList;
    }
      
}
