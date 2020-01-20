package collaborative.to.pkgdo.list.client;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public abstract class taskitemBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final BorderPane borderPane;
    protected final JFXButton jFXButton;
    protected final Label label;

    public taskitemBase() {

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

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setText("Label");
        label.setFont(new Font("System Bold", 13.0));
        borderPane.setTop(label);

        getChildren().add(anchorPane);
        getChildren().add(borderPane);

    }
}
