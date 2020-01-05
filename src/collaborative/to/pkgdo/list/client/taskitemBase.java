package collaborative.to.pkgdo.list.client;

import com.jfoenix.controls.JFXCheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public abstract class taskitemBase extends HBox {

    protected final AnchorPane anchorPane;
    protected final JFXCheckBox jFXCheckBox;
    protected final Label label;
    protected final Line line;
    protected final AnchorPane anchorPane0;
    protected final ImageView imageView;

    public taskitemBase() {

        anchorPane = new AnchorPane();
        jFXCheckBox = new JFXCheckBox();
        label = new Label();
        line = new Line();
        anchorPane0 = new AnchorPane();
        imageView = new ImageView();

        setPrefHeight(38.0);
        setPrefWidth(399.0);

        anchorPane.setId("AnchorPane");
        anchorPane.setPrefHeight(0.0);
        anchorPane.setPrefWidth(357.0);

        jFXCheckBox.setLayoutX(14.0);
        jFXCheckBox.setLayoutY(10.0);

        label.setLayoutX(37.0);
        label.setLayoutY(9.0);
        label.setPrefHeight(19.0);
        label.setPrefWidth(338.0);
        label.setText("Item");
        label.setFont(new Font(13.0));

        line.setEndX(-164.99998474121094);
        line.setEndY(-35.0000114440918);
        line.setLayoutX(166.0);
        line.setLayoutY(38.0);
        line.setStartX(-165.0);
        line.setStartY(-3.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#22cda8"));
        line.setStrokeWidth(3.0);

        anchorPane0.setPrefHeight(18.0);
        anchorPane0.setPrefWidth(28.0);

        imageView.setFitHeight(19.0);
        imageView.setFitWidth(12.0);
        imageView.setLayoutX(7.0);
        imageView.setLayoutY(12.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("icons8_sort_down_26px.png").toExternalForm()));

        anchorPane.getChildren().add(jFXCheckBox);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(line);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(imageView);
        getChildren().add(anchorPane0);

    }
}
