package collaborative.to.pkgdo.list.client;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class taskitemBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final JFXTextField ADDTASK1;
    protected final ContextMenu contextMenu;
    protected final MenuItem menuItem;

    public taskitemBase() {

        anchorPane = new AnchorPane();
        ADDTASK1 = new JFXTextField();
        contextMenu = new ContextMenu();
        menuItem = new MenuItem();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(39.0);
        setPrefWidth(405.0);
        setStyle("-fx-background-color: #fefefe; -fx-background-radius: 2;");

        anchorPane.setLayoutX(7.0);
        anchorPane.setLayoutY(6.0);
        anchorPane.setPrefHeight(27.0);
        anchorPane.setPrefWidth(389.0);
        anchorPane.setStyle("-fx-background-color: #f0f1f5; -fx-background-radius: 5;");

        ADDTASK1.setLayoutX(6.0);
        ADDTASK1.setLayoutY(1.0);
        ADDTASK1.setFont(new Font("Calibri Light", 12.0));

        menuItem.setMnemonicParsing(false);
        menuItem.setText("Delete");
        ADDTASK1.setContextMenu(contextMenu);

        contextMenu.getItems().add(menuItem);
        anchorPane.getChildren().add(ADDTASK1);
        getChildren().add(anchorPane);

    }
}
