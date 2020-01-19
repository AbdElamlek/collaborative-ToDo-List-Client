/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

import Entities.ItemEntity;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
  class Itemstate extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final JFXButton jFXButton;
    protected final ImageView imageView;

    public Itemstate(String title,int finished, int pending) {
      
         FXMLController.piechart.setStartAngle(180); 
      
          ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
             new PieChart.Data("Done ",(finished/(finished+pending)*100)),
             new PieChart.Data("Pending",(pending/(finished+pending)*100)));
         
        FXMLController.piechart.setData(pieChartData); 
        anchorPane = new AnchorPane();
        jFXButton = new JFXButton();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(42.0);
        setPrefWidth(473.0);

        anchorPane.setLayoutY(-61.0);
        anchorPane.setPrefHeight(32.0);
        anchorPane.setPrefWidth(445.0);
        anchorPane.setStyle("-fx-background-color: #edc4a8; -fx-background-radius: 7;");

        jFXButton.setLayoutX(14.0);
        jFXButton.setLayoutY(5.0);
        jFXButton.setStyle("-fx-background-radius: 7; -fx-background-color: #e8f2fd;");

        imageView.setFitHeight(22.0);
        imageView.setFitWidth(25.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("icons8_bulleted_list_40px.png").toExternalForm()));
        jFXButton.setGraphic(imageView);
        jFXButton.setFont(new Font("System Bold", 14.0));
        jFXButton.setText(title);
        getChildren().add(anchorPane);
        getChildren().add(jFXButton);
        jFXButton.setOnMousePressed((MouseEvent event) -> {
         
            FXMLController.Itemstatuspane.setVisible(true);
            FXMLController.finished.setText(new Integer(finished).toString());
            
            FXMLController.pending.setText(new Integer(pending).toString());
            
        });

     
    
    }
  
  }
