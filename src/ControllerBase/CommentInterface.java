/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import java.sql.Date;

/**
 *
 * @author Abd-Elmalek
 */
public interface CommentInterface {
    
    public void addComment(String messageContent,java.sql.Date date, int taskId, int itemId, int todoId, int userId, String userName);
}
