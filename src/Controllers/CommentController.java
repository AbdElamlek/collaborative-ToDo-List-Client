/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.CommentInterface;
import Entities.CommentEntity;
import Entities.EntityWrapper;
import java.sql.Date;

/**
 *
 * @author Abd-Elmalek
 */
public class CommentController implements CommentInterface{
    
    AdapterController adapterController;
    
    @Override
    public void addComment(String messageContent, Date date, int taskId, int itemId, int todoId, int userId, String userName) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setMessageContent(messageContent);
        commentEntity.setTime(date);
        commentEntity.setCommentOwnerId(userId);
        commentEntity.setCommentedTaskId(taskId);
        commentEntity.setItemId(itemId);
        commentEntity.setTodoId(todoId);
        commentEntity.setUserName(userName);
        adapterController = new AdapterController();
        EntityWrapper entityWrapper = new EntityWrapper("add comment", "entity", commentEntity);
        String taskJsonResponse = adapterController.entity2Json(entityWrapper);
        SocketController.getInstance().sendJsonObject(taskJsonResponse);
    }
    
}
