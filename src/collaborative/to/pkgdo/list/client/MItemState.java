/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

/**
 *
 * @author Abd-Elmalek
 */

    
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entities.ItemEntity;
import com.jfoenix.controls.JFXButton;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;

/**
 *
 * @author OMNIA
 */
  public class MItemState extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final JFXButton jFXButton;
    protected final ImageView imageView;
    private static BiConsumer<Integer,Integer> piechartGUIGenerator;

    public static void setpiechartGUIGenerator(BiConsumer<Integer,Integer> piechartGUIGenerator) {
        MItemState.piechartGUIGenerator = piechartGUIGenerator;
    }

    public MItemState(String title,int finished, int pending) {
      
 
        anchorPane = new AnchorPane();
        jFXButton = new JFXButton();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(42.0);
        setPrefWidth(469.0);
//
        jFXButton.setLayoutX(14.0);
        jFXButton.setLayoutY(5.0);
        jFXButton.setStyle("-fx-background-radius: 7; -fx-background-color: #e8f2fd;");
        jFXButton.setPrefWidth(460);
        imageView.setFitHeight(22.0);
        imageView.setFitWidth(25.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("icons8_bulleted_list_40px.png").toExternalForm()));
        jFXButton.setGraphic(imageView);
        jFXButton.setFont(new Font("System Bold", 14.0));
        jFXButton.setText(title);
        jFXButton.setAlignment(Pos.BASELINE_LEFT);
        jFXButton.setPrefWidth(464);
        getChildren().add(anchorPane);
        getChildren().add(jFXButton);
        jFXButton.setOnMousePressed((MouseEvent event) -> {
           if (piechartGUIGenerator != null) {
                        piechartGUIGenerator.accept(new Integer(finished),new Integer(pending));
                    }
          
           
            
        });

     
    
    }
  
}
