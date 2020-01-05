/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Controllers.AuthenticationController;
import Controllers.SocketController;
import Utils.UserEntity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Abd-Elmalek
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

        /*Reham*/
         AuthenticationController authenticationController = new AuthenticationController();
        //authenticationController.logIn("reham", "123");
        /*Reham*/
        
    /*Eman Kamal*/
        String email = "eman@gmail.com";
        String password = "123456788";
        String firstname = "eman";
        String lastname = "kamal";
        String username = "ekamal";

        UserEntity userEntity = new UserEntity();
        boolean checkValidation=isValidData(email, password, firstname, lastname, username);
        if (checkValidation) {
            userEntity.setFirstName(firstname);
            userEntity.setLastName(lastname);
            userEntity.setUserName(username);
            userEntity.setEmail(email);
            userEntity.setPassword(password);
            System.out.println(userEntity.getFirstName()+" "+userEntity.getLastName()+" "
            +userEntity.getUserName()+" "+userEntity.getEmail()+" "+userEntity.getPassword());
            //SignUp
            authenticationController.SignUp(userEntity);
            //SocketController.getInstance().connect();
            //SocketController controller = SocketController.getInstance();
            //controller.sendJsonObject("hhihihihihihi");
            
        }
    /*Eman Kamal*/
    }

    /*Eman Kamal*/
    private boolean isValidData(String email, String password, String firstname, String lastname, String username) {
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
        return isValid;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()||email.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidPassword(String password) {
        if(password.isEmpty()||password.length()>40){
            return false;
        }else{
            return true;
        }   
    }

    private boolean isValidName(String name) {
        if(name.isEmpty()||name.length()>40){
            return false;
        }else{
            return true;
        } 
    }
   /*Eman Kamal*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
