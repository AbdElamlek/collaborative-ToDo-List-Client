/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import ControllerBase.ActionHandler;
import Entities.CommentEntity;
import Entities.TaskEntity;
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
