package collaborative.to.pkgdo.list.client;

import Controllers.AuthenticationController;
import Handlers.LoginHandler;
import Entities.ToDoEntity;
import Controllers.CollaboratorController;
import Controllers.SocketController;
import Entities.UserEntity;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static com.sun.deploy.security.BlockedDialog.show;
import static com.sun.glass.events.DndEvent.EXIT;
import static com.sun.glass.events.MouseEvent.EXIT;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
     static boolean isonline;
    double xOffset = 0;
    double yOffset = 0;
    
    private AuthenticationController authenticationController;
    @FXML
    public ImageView EXIT;
    public AnchorPane LOGINPANE;
    public AnchorPane SIGNUPPANE;
    public AnchorPane nOCONNECTIONPANE;
    public Label nOTVALID;
    @FXML
     //public JFXButton Login;
    //public JFXButton Create;
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
        SIGNUPPANE.setVisible(true);
        /*System.out.println("just test collaborator controller");
        CollaboratorController c=new CollaboratorController();
        //c.addCollaboratorRequest(1, 2, 10);
        //c.acceptCollaboratorRequest(4);
        //c.rejectCollaboratorRequest(5);*/
        
        
    }
    
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
       //   isonline=SocketController.isRunning;
         if(SocketController.getInstance().connect()){
                authenticationController = new AuthenticationController();
             if(!( UsernameText.getText().equals(""))&&!( PasswordText.getText().equals(""))){
                 
         String username = UsernameText.getText();
         String password = PasswordText.getText();
         
         authenticationController.logIn(username, password);
         }}
         
         else
           {
             nOCONNECTIONPANE.setVisible(true);
             
           }
     }
       
    public void showNotValid(Object o){
        nOTVALID.setVisible(true);
    }
     
    public void navigateToMainPage(Object o){
        
       Platform.runLater(()->{
        try {
            System.out.println("loading main page ....");
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = (Stage) UsernameText.getScene().getWindow();
            
            stage.setScene(scene);
            
            
           
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
       
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        });
        
   }
//     public void showNotvalidlogin(Object o){
//        
//       Platform.runLater(()->{
//       
//       try{
//        
//       
//       
//       }catch{}
//       
//       });}
//     
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
        LoginHandler.setMainPageNavigator(this::navigateToMainPage);
        LoginHandler.setNotvalidlogin(this::showNotValid);
        
//        LoginHandler.setNotvalidlogin(this::);
        LOGINPANE.setVisible(true);
        SIGNUPPANE.setVisible(false);
        
    }

    @FXML
    private void Login(MouseEvent event) {
        LOGINPANE.setVisible(true);
        SIGNUPPANE.setVisible(false);
    }

}
