package collaborative.to.pkgdo.list.client;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class taskitemBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final ImageView imageView0;
    protected final JFXButton aDDCOLL;

    public taskitemBase() {

        imageView = new ImageView();
        label = new Label();
        imageView0 = new ImageView();
        aDDCOLL = new JFXButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(29.0);
        setPrefWidth(283.0);
        setStyle("-fx-background-color: #fefefe; -fx-background-radius: 2;");

        imageView.setFitHeight(24.0);
        imageView.setFitWidth(23.0);
        imageView.setLayoutX(2.0);
        imageView.setLayoutY(2.0);
        imageView.setOpacity(0.61);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("icons8_user_24px.png").toExternalForm()));

        label.setLayoutX(33.0);
        label.setLayoutY(3.0);
        label.setPrefHeight(25.0);
        label.setPrefWidth(238.0);
        label.setText("Friend");
        label.setFont(new Font(16.0));

        imageView0.setFitHeight(29.0);
        imageView0.setFitWidth(23.0);
        imageView0.setLayoutX(256.0);
        imageView0.setLayoutY(3.0);
        imageView0.setOpacity(0.66);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("icons8_add_24px.png").toExternalForm()));

        aDDCOLL.setLayoutX(256.0);
        aDDCOLL.setLayoutY(2.0);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(imageView0);
        getChildren().add(aDDCOLL);

    }
}
