/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBase;

import Entities.RequestEntity;
import Entities.TaskEntity;
import Entities.UserEntity;

/**
 *
 * @author Abd-Elmalek
 */
public interface TaskInterFace {
    
    boolean assignToTask(int assignerId, int assigneeId, int taskId);
    boolean updateTaskStatus(TaskEntity task, int status);
    boolean acceptTask(int taskId, int userId);
    boolean rejectTask(RequestEntity taskRequest, UserEntity userEntity);
    boolean withdrawFromTask(TaskEntity task, int userId);
    boolean createNewTask(int status , String description, int itemId);
    boolean deleteTask(TaskEntity taskEntity);
}
