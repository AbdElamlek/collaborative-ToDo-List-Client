/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.CollaboratorInterface;
import Entities.CollaborationRequestEntity;
import Entities.CollaboratorDTO;
import Entities.EntityWrapper;
import Entities.RequestEntity;
import java.sql.Date;
import Utils.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class CollaboratorController implements CollaboratorInterface {

    private SocketController sc;
    private AdapterController ac;

    public CollaboratorController() {
        sc = SocketController.getInstance();
        ac = new AdapterController();
    }

    @Override
    public void addCollaboratorRequest(int collaboratorID, int senderID, int todoId) {
        String reqJson = ac.entity2Json(new EntityWrapper("add collaborator request", "CollaborationRequestEntity",
                new CollaborationRequestEntity(todoId,"",0, new Date(System.currentTimeMillis()), collaboratorID, senderID)));
        System.out.println("client sender:\n"+reqJson);
        sc.sendJsonObject(reqJson);
    }

    @Override
    public void acceptCollaboratorRequest(CollaborationRequestEntity request) {
        String reqJson = ac.entity2Json(new EntityWrapper("accept collaborator request", "CollaborationRequestEntity",
                request));
        sc.sendJsonObject(reqJson);
    }

    @Override
    public void rejectCollaboratorRequest(CollaborationRequestEntity request) {
        String reqJson = ac.entity2Json(new EntityWrapper("reject collaborator request", "CollaboratorDTO",
                request));
        sc.sendJsonObject(reqJson);
    }

}
