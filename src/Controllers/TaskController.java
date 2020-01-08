/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.TaskInterFace;
import DTOs.Accept_RejectTaskDTO;
import Utils.EntityWrapper;
import Utils.RequestEntity;
import Utils.TaskEntity;
import Utils.UserEntity;
import java.util.Date;
import javax.json.JsonObject;

/**
 *
 * @author Abd-Elmalek
 */
public class TaskController implements TaskInterFace{
    AdapterController adapterController = new AdapterController();
    @Override
    public boolean assignToTask(int assignerId, int assigneeId) {
        try {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setSentUserId(assignerId);
        requestEntity.setReceivedUserId(assigneeId);
        requestEntity.setType(1);
        requestEntity.setTime(new Date());
        EntityWrapper entityWrapper = new EntityWrapper("assigonToTaskRequest", "entity", requestEntity);
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
        acceptTaskDTO.setTaskId(taskId);
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
        accept_RejectTaskDTO.setTaskId(task.getId());
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
    
}
