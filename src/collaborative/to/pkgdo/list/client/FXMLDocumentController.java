package collaborative.to.pkgdo.list.client;

import Controllers.AuthenticationController;
import Utils.UserEntity;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static com.sun.deploy.security.BlockedDialog.show;
import static com.sun.glass.events.DndEvent.EXIT;
import static com.sun.glass.events.MouseEvent.EXIT;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    private AuthenticationController authenticationController = new AuthenticationController();
    @FXML
    public ImageView EXIT;
    public AnchorPane LOGINPANE;
    public AnchorPane SIGNUPPANE;

    @FXML
//    public JFXButton Login;
//    public JFXButton Create;
    //public JFXButton Sihnup;
    //public JFXTextField UsernameText;
    //public JFXTextField PasswordText;
      public JFXTextField ConfirmText1;
      public JFXTextField PasswordText1;
      public JFXTextField UsernameText1;
//    
      public JFXTextField UsernameText;
      public JFXPasswordField PasswordText;
    @FXML
    private void exit(MouseEvent event) {
        Platform.exit();
    }
     
 /*Eman Kamal*/
     @FXML
    private void toSignUp(MouseEvent event) {
        LOGINPANE.setVisible(false);
        SIGNUPPANE.setVisible(true);}
    
    @FXML
    private void SignUp(MouseEvent event) {
        String email = "eman@gmail.com";
        String password = PasswordText1.getText();
        String cpassword = ConfirmText1.getText();
        String firstname = "eman";
        String lastname = "kamal";
        String username = UsernameText1.getText();

        UserEntity userEntity = new UserEntity();
        boolean checkValidation = isValidData(email, password, cpassword, firstname, lastname, username);
        if (checkValidation) {
            userEntity.setFirstName(firstname);
            userEntity.setLastName(lastname);
            userEntity.setUserName(username);
            userEntity.setEmail(email);
            userEntity.setPassword(password);
            System.out.println(userEntity.getFirstName() + " " + userEntity.getLastName() + " "
                    + userEntity.getUserName() + " " + userEntity.getEmail() + " " + userEntity.getPassword());
            //SignUp
            authenticationController.SignUp(userEntity);
            //SocketController.getInstance().connect();
            //SocketController controller = SocketController.getInstance();
            //controller.sendJsonObject("hhihihihihihi");

        }
    }
    @FXML
     private void login (MouseEvent event) {
         String username = UsernameText.getText();
         String password = PasswordText.getText();
         
         authenticationController.logIn(username, password);
    }

    private boolean isValidData(String email, String password, String cpassword, String firstname, String lastname, String username) {
        boolean isValid = true;
        if (!isValidEmail(email)) {
            System.out.println("You must enter a valid email!");
            isValid = false;
        }
        if (!isValidPassword(password)) {
            System.out.println("You must enter a valid password!");
            isValid = false;
        }
        if (!isValidName(firstname)) {
            System.out.println("You must enter a valid firstname!");
            isValid = false;
        }
        if (!isValidName(lastname)) {
            System.out.println("You must enter a valid lastname!");
            isValid = false;
        }
        if (!isValidName(username)) {
            System.out.println("You must enter a valid username!");
            isValid = false;
        }
        if (!isMatchPassword(password, cpassword)) {
            System.out.println("Password must match!");
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches() || email.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidPassword(String password) {
        if (password.isEmpty() || password.length() > 40) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isMatchPassword(String password, String cpassword) {
        if (!password.equals(cpassword)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidName(String name) {
        if (name.isEmpty() || name.length() > 40) {
            return false;
        } else {
            return true;
        }
    }

    /*Eman Kamal*/
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

    @FXML
    private void Login(MouseEvent event) {
        LOGINPANE.setVisible(true);
        SIGNUPPANE.setVisible(false);
    }

}
