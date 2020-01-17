package collaborative.to.pkgdo.list.client;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class taskitemBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final JFXButton jFXButton;
    protected final ImageView imageView;

    public taskitemBase() {

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

        getChildren().add(anchorPane);
        getChildren().add(jFXButton);

    }
}
