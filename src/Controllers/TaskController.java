/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.TaskInterFace;
import Entities.EntityWrapper;
import Entities.RequestEntity;
import Entities.TaskEntity;
import Entities.UserEntity;
import DTOs.Accept_RejectTaskDTO;
import Entities.Accept_RecjectTaskEntity;
import java.util.Date;

/**
 *
 * @author Abd-Elmalek
 */
public class TaskController implements TaskInterFace{
    AdapterController adapterController = new AdapterController();
    @Override
    public boolean assignToTask(int assignerId, int assigneeId, int taskId) {
        try {
            Accept_RecjectTaskEntity accept_RecjectTaskEntity = new Accept_RecjectTaskEntity();
            accept_RecjectTaskEntity.setSentUserId(assignerId);
            accept_RecjectTaskEntity.setReceivedUserId(assigneeId);
            accept_RecjectTaskEntity.setTaskId(taskId);
            accept_RecjectTaskEntity.setTime(new Date());
            EntityWrapper entityWrapper = new EntityWrapper("assigonToTaskRequest", "entity", accept_RecjectTaskEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            SocketController.getInstance().sendJsonObject(taskJsonResponse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTaskStatus(TaskEntity task, int status) {
        try {
            task.setStatus(status);
            EntityWrapper entityWrapper = new EntityWrapper("changeTaskStatus", "entity", task);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            SocketController.getInstance().sendJsonObject(taskJsonResponse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean acceptTask(int taskId, int userId) {
        try {
            Accept_RejectTaskDTO acceptTaskDTO = new Accept_RejectTaskDTO();
            acceptTaskDTO.getTask().setId(taskId);
            acceptTaskDTO.setUserId(userId);
            EntityWrapper entityWrapper = new EntityWrapper("acceptTask", "entity", acceptTaskDTO);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            SocketController.getInstance().sendJsonObject(taskJsonResponse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean rejectTask(RequestEntity taskRequest, UserEntity userEntity) {
        try {
            EntityWrapper entityWrapper = new EntityWrapper("rejectTaskRequest", "entity", taskRequest);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            SocketController.getInstance().sendJsonObject(taskJsonResponse);
            userEntity.getRequestList().remove(userEntity.getRequestList().indexOf(taskRequest));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean withdrawFromTask(TaskEntity task, int userId) {
        try {
            Accept_RejectTaskDTO accept_RejectTaskDTO = new Accept_RejectTaskDTO();
            accept_RejectTaskDTO.getTask().setId(task.getId());
            accept_RejectTaskDTO.setUserId(userId);
            EntityWrapper entityWrapper = new EntityWrapper("withdrawFromTask", "entity", accept_RejectTaskDTO);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            SocketController.getInstance().sendJsonObject(taskJsonResponse);
            task.getAssignedUsersList().remove(task.getAssignedUsersList().indexOf(userId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createNewTask(int status, String description, int itemId) {
        try {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setStatus(status);
            taskEntity.setDecription(description);
            taskEntity.setItemId(itemId);
            EntityWrapper entityWrapper = new EntityWrapper("createNewTask", "entity", taskEntity);
            String taskJsonResponse = adapterController.entity2Json(entityWrapper);
            SocketController.getInstance().sendJsonObject(taskJsonResponse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
