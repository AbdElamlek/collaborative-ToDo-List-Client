/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;

/**
 *
 * @author Abd-Elmalek
 */
public class ItemEntity implements BaseEntity {
    
    private int id;
    private String title;
    private String decription;
    private int todoId;
    private ArrayList<TaskEntity> tasksList;

    public ItemEntity() {
    }

    public ItemEntity(int id, String title, String decription, int todoId) {
        this.id = id;
        this.title = title;
        this.decription = decription;
        this.todoId = todoId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDecription() {
        return decription;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTasksList(ArrayList<TaskEntity> tasksList) {
        this.tasksList = tasksList;
    }

    public ArrayList<TaskEntity> getTasksList() {
        return tasksList;
    }
    
    
    
}
