
package collaborative.to.pkgdo.list.client;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static com.sun.deploy.security.BlockedDialog.show;
import static com.sun.glass.events.DndEvent.EXIT;
import static com.sun.glass.events.MouseEvent.EXIT;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class FXMLDocumentController implements Initializable {

    @FXML
    public ImageView EXIT;
    public AnchorPane LOGINPANE;
    public AnchorPane SIGNUPPANE;
    
//    @FXML
//    public JFXButton Login;
//    public JFXButton Create;
//    public JFXButton Sihnup;
//    public JFXTextField UsernameText;
//    public JFXTextField PasswordText;
//    public JFXTextField ConfirmText1;
//    public JFXTextField PasswordText1;
//    public JFXTextField UsernameText1;
//    

    
    @FXML
    private void exit(MouseEvent event) {
         Platform.exit();
    }
    
    @FXML
     private void SignUp (MouseEvent event) {
         LOGINPANE.setVisible(false);
         SIGNUPPANE.setVisible(true);
    }
     @FXML
     private void login (MouseEvent event) {
         //LOGINPANE.setVisible(false);
         //SIGNUPPANE.setVisible(true);
    }
      @FXML
     private void backToLogin(MouseEvent event) {
         LOGINPANE.setVisible(true);
         SIGNUPPANE.setVisible(false);
    }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LOGINPANE.setVisible(true);
        SIGNUPPANE.setVisible(false);
    }    
    
}
