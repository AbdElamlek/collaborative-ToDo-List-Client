/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

import Controllers.AuthenticationController;
import Controllers.SocketController;
import Controllers.ToDoListController;
import Entities.ToDoEntity;
import java.util.Date;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Abd-Elmalek
 */
public class CollaborativeToDoListClient extends Application {
    private double xOffset = 0; 
    private double yOffset = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
        
         //stage.initStyle(StageStyle.TRANSPARENT);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //SocketController sc = SocketController.getInstance();
        //sc.connect();
        //AuthenticationController authenticationController = new AuthenticationController();
        //authenticationController.logIn("ReeeEzzat", "123");
        SocketController.getInstance().connect();
        //ToDoListController tlc = new ToDoListController();
        //tlc.createToDoList(new ToDoEntity("New list", new Date(), new Date(), 11, 1, "0xcc3333ff")); 
        launch(args);
    }
    
}
