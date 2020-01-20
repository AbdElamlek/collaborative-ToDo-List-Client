/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

import Entities.ToDoEntity;
import com.jfoenix.controls.JFXButton;
import java.util.List;
import java.util.function.Consumer;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;

/**
 *
 * @author OMNIA
 */
public class TodoStatstics extends AnchorPane {
  
    protected final AnchorPane anchorPane;
    protected final BorderPane borderPane;
    protected final JFXButton jFXButton;
    protected final Label label;

    private static Consumer<MItemState> itemstateGUIGenerator;

    public static void setItemstateGUIGenerator(Consumer<MItemState> itemstateGUIGenerator) {
        TodoStatstics.itemstateGUIGenerator = itemstateGUIGenerator;
    }
     private static Consumer itemstateGUIClear;

    public static void setItemstateGUIClear(Consumer itemstateGUIClear) {
        TodoStatstics.itemstateGUIClear = itemstateGUIClear;
    }
    public TodoStatstics(ToDoEntity todo, int Percent) {
        anchorPane = new AnchorPane();
        borderPane = new BorderPane();
        jFXButton = new JFXButton();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(249.0);
        setPrefWidth(104.0);

        anchorPane.setLayoutY(-61.0);
        anchorPane.setPrefHeight(32.0);
        anchorPane.setPrefWidth(445.0);
        anchorPane.setStyle("-fx-background-color: #edc4a8; -fx-background-radius: 7;");

        borderPane.setLayoutX(21.0);
        borderPane.setLayoutY(5.0);
        borderPane.setPrefHeight(249.0);
        borderPane.setPrefWidth(58.0);

        jFXButton.setStyle("-fx-background-radius: 7; -fx-background-color: #2486cd;");
        jFXButton.setFont(new Font("System Bold", 14.0));
        borderPane.setCenter(jFXButton);
        jFXButton.setPrefHeight((Percent*213)/100);
        jFXButton.setPrefWidth(85);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        jFXButton.setText(Percent+"%");
        label.setText(todo.getTitle());
        label.setFont(new Font("System Bold", 13.0));
        borderPane.setTop(label);

        getChildren().add(anchorPane);
        getChildren().add(borderPane);

        jFXButton.setOnMousePressed((MouseEvent event) -> {
            // statistics=new StatisticsHandler(currentUser);
            List<MItemState> items = FXMLController.statistics.setItemStates(todo);
            System.out.println("size:" + items.size());
            
             if (itemstateGUIClear != null) {
                        itemstateGUIClear.accept(null);
                    }
            
            if (items.size() > 0) {
                for (MItemState state : items) {
                    if (itemstateGUIGenerator != null) {
                        itemstateGUIGenerator.accept(state);
                    }
                    System.out.println("here itemstates!");

                }
            }

        });

    }

   

}
