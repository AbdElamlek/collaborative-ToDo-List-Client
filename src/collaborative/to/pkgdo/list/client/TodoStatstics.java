/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

import Entities.ToDoEntity;
import java.util.List;
import java.util.function.Consumer;
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

    protected final Label label;
    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final Glow glow;
    protected final Label label0;
    private static Consumer<MItemState> itemstateGUIGenerator;

    public static void setItemstateGUIGenerator(Consumer<MItemState> itemstateGUIGenerator) {
        TodoStatstics.itemstateGUIGenerator = itemstateGUIGenerator;
    }
     private static Consumer itemstateGUIClear;

    public static void setItemstateGUIClear(Consumer itemstateGUIClear) {
        TodoStatstics.itemstateGUIClear = itemstateGUIClear;
    }
    public TodoStatstics(ToDoEntity todo, int Percent) {

        label = new Label();

        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        glow = new Glow();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(200.0);
        setPrefWidth(74.0);
        setStyle("-fx-background-color: #fefefe; -fx-background-radius: 2;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(12.0);
        label.setLayoutY(232.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(57.0);
        label.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        label.setFont(new Font("System Bold", 13.0));

        borderPane.setLayoutX(20.0);
        borderPane.setLayoutY(26.0);
        borderPane.setPrefHeight(160.0);
        borderPane.setPrefWidth(34.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        anchorPane0.setLayoutX(7.0);
        anchorPane0.setPrefHeight(Percent * 140.0);
        anchorPane0.setPrefWidth(24.0);
        anchorPane0.setStyle("-fx-background-color: #3b8ef4; -fx-background-radius: 5;");

        //glow.setLevel(0.85);
        // anchorPane0.setEffect(glow);
        label0.setLayoutX(3.0);
        label0.setLayoutY(-32.0);
        label0.setPrefHeight(19.0);
        label0.setPrefWidth(39.0);
        label0.setText("100%");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#6991dd"));
        label0.setFont(new Font("System Bold", 13.0));
        borderPane.setBottom(anchorPane);
        label.setText(todo.getTitle());
        getChildren().add(label);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(label0);
        getChildren().add(borderPane);

        String s = Percent + "%";
        setBarpercent(s);

        this.setOnMousePressed((MouseEvent event) -> {
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

    void setBarpercent(String s) {
        label0.setText(s);
    }

    void setBarheight(int i) {

    }

}
