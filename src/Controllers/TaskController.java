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
    public boolean acceptTask(TaskEntity task, String userId) {
        try {
        task.getAssignedUsersList().add(userId);
        EntityWrapper entityWrapper = new EntityWrapper("acceptTask", "entity", task);
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
    public boolean withdrawFromTask(TaskEntity task, String userId) {
        try {
        task.getAssignedUsersList().add(userId);
        EntityWrapper entityWrapper = new EntityWrapper("withdrawFromTask", "entity", task);
        String taskJsonResponse = adapterController.entity2Json(entityWrapper);
        SocketController.getInstance().sendJsonObject(taskJsonResponse);
        task.getAssignedUsersList().remove(task.getAssignedUsersList().indexOf(userId));
        task.getAssignedUsersList().remove(task.getAssignedUsersList().indexOf(userId));
        return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
