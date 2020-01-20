/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.CommentEntity;
import Entities.ItemEntity;
import Entities.TaskEntity;
import Entities.ToDoEntity;
import Utils.CurrentUser;
import static collaborative.to.pkgdo.list.client.FXMLController.currentItem;
import static collaborative.to.pkgdo.list.client.FXMLController.currentTask;
import static collaborative.to.pkgdo.list.client.FXMLController.currentToDo;
import com.google.gson.Gson;
import java.util.function.Consumer;
import javafx.application.Platform;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class CommentCreationHandler implements ActionHandler{

   private static Consumer<CommentEntity> commentGUIGenerator;
    
    public static void setCommentGUIGenerator(Consumer<CommentEntity> generator){
        commentGUIGenerator = generator;
    }
    @Override
    public void handleAction(String responseJsonObject) {
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(responseJsonObject);
            
            if(!jsonObject.isNull("entity")){
                String commentJsonObject  = jsonObject.getJSONObject("entity").toString();
                CommentEntity comment = gson.fromJson(commentJsonObject, CommentEntity.class);
                 System.out.println("-----------------------create-comment---"+commentJsonObject);
          //       ToDoEntity mToDo = CurrentUser.getCurrentUser().getTodoList().get(CurrentUser.getCurrentUser().getTodoList().indexOf(currentToDo));
            //     ItemEntity mItem =   mToDo.getItemsList().get(mToDo.getItemsList().indexOf(currentItem));
                // TaskEntity mTask = mItem.getTasksList().get(mItem.getTasksList().indexOf(currentTask));
              //   mTask.getCommentsList().add(comment);
                 
                if(commentGUIGenerator != null){
                    Platform.runLater(()->{
                    commentGUIGenerator.accept(comment);
                        System.out.println("accept comment generator invoked");
                    });
                }
                
            }else{
                System.out.println("comment not added");

                
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
}
