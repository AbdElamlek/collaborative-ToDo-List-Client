/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.fxml.Initializable;
//
///**
// * FXML Controller class
// *
// * @author ENG-HATEM
// */
//public class FXMLController implements Initializable {
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
//    
//}
import Controllers.ToDoListController;
import Handlers.LoginHandler;
import Handlers.ToDoCreationHandler;
import Utils.CurrentUser;
import Utils.ToDoEntity;
import Utils.UserEntity;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author Abd-Elmalek
 */
public class FXMLController implements Initializable  {
    UserEntity currentUser;
    
    Friendicon Fitem=new Friendicon();
    Friendicon Fitem2=new Friendicon();
    //Listicon  Litem=new Listicon();
    //Listicon  Litem2=new Listicon();
    Tasks tasks=new Tasks();
    Tasks tasks2=new Tasks();
   
    @FXML
    
    public JFXButton  MINIMIZE;
    public JFXButton  EXIT;
    public VBox FRIENDSLIST;
    public VBox LIST; 
    public VBox TASKLISTS;
    public ScrollPane FRIENDSSCROLL;
    public ScrollPane LISTSCROLL;
    public ScrollPane COLLABSCROLL;
    public JFXButton FRIENDS;
    public JFXButton LISTS;
    public AnchorPane TODOPANE;
    public AnchorPane TODAYPANE;
    public AnchorPane STATUSPANE;
    public AnchorPane REQUESTPANE;
     public AnchorPane DATEPANE;
    public JFXButton REQUESTS;
    public JFXButton TODAY;
    public JFXButton STATUS;
    public Line linelists;
    public Line linefriends;
    public ImageView DATEPICK;
    public JFXButton CLEARDATE;
    public Label USERNAME;
    public Label TITLE;
    @FXML
       public void nav(MouseEvent event) {
           ToDoListController tlc = new ToDoListController();
           tlc.createToDoList(new ToDoEntity("New list", new Date(), new Date(), 11, 1, "0xcc3333ff"));
           if(event.getSource()==LISTS){
            
            FRIENDSSCROLL.setVisible(false);
            LISTSCROLL.setVisible(true);
            linelists.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
            linefriends.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
          }
         else if(event.getSource()==FRIENDS){
             
            FRIENDSSCROLL.setVisible(true);
            LISTSCROLL.setVisible(false);
            linelists.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
            linefriends.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
          }
          else if(event.getSource()==REQUESTS){
             
            TODOPANE.setVisible(false);
            STATUSPANE.setVisible(false);
            REQUESTPANE.setVisible(true);    
            TODAYPANE.setVisible(false);  
          }
     
         else if(event.getSource()==TODAY){
             
            TODOPANE.setVisible(false);
            STATUSPANE.setVisible(false);
            REQUESTPANE.setVisible(false);    
            TODAYPANE.setVisible(true);  
          }
        else if(event.getSource()==STATUS){
              
            TODOPANE.setVisible(false);
            STATUSPANE.setVisible(true);
            REQUESTPANE.setVisible(false);    
            TODAYPANE.setVisible(false);  
          }
       }
         @FXML
        public void nav1(MouseEvent event) {
        if(event.getSource()==DATEPICK){
             
            DATEPANE.setVisible(true);
          }
        else if(event.getSource()==CLEARDATE){
             
            DATEPANE.setVisible(false);
            
          }

     
     
     
     
    }
       
        
        
        
      @FXML
     public void exit(MouseEvent event) {
         Platform.exit();
    }  
     
     private void handleButtonAction(ActionEvent event) {
        
       
    }

     
      public  void actions() {
        TODOPANE.setVisible(true);
            STATUSPANE.setVisible(false);
            REQUESTPANE.setVisible(false);    
            TODAYPANE.setVisible(false);  }
     
    
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("in init in main page");
        
        ToDoCreationHandler.setTodoGUIGenerator(this::createTodoList);
        
        currentUser = CurrentUser.getCurrentUser();
      
      
      Fitem =new Friendicon();
      FRIENDSLIST.getChildren().add(Fitem);
      FRIENDSLIST.getChildren().add(Fitem2);
     
      //LIST.getChildren().add(Litem);
      //LIST.getChildren().add(Litem2);
      
      TASKLISTS.getChildren().add(tasks);
      TASKLISTS.getChildren().add(tasks2);
      
      FRIENDSSCROLL.setVisible(false);
      LISTSCROLL.setVisible(true);
      linelists.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
      linefriends.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
    
      initiateCurrentUser();
    }    
    
   
    public void initiateCurrentUser(){
        USERNAME.setText(currentUser.getUserName());
        for(ToDoEntity todo : currentUser.getTodoList()){
            Listicon  Litem=new Listicon(todo);
            LIST.getChildren().add(Litem);
        }
            
    }




 class  Friendicon extends AnchorPane {

    protected Circle circle;
    protected  DropShadow dropShadow;
    protected  ImageView imageView;
    protected  Circle circle0;
    protected  Label Friendname;

    public Friendicon() {

        circle = new Circle();
        dropShadow = new DropShadow();
        imageView = new ImageView();
        circle0 = new Circle();
        Friendname = new Label();

        setId("AnchorPane");
        setPrefHeight(35.0);
        setPrefWidth(137.0);

        circle.setFill(javafx.scene.paint.Color.valueOf("#7fb8ee"));
        circle.setLayoutX(16.0);
        circle.setLayoutY(19.0);
        circle.setRadius(14.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#00000004"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        dropShadow.setBlurType(javafx.scene.effect.BlurType.ONE_PASS_BOX);
        
        dropShadow.setHeight(5.0);
        dropShadow.setRadius(2.0);
        dropShadow.setWidth(5.0);
        circle.setEffect(dropShadow);

        imageView.setFitHeight(22.0);
        imageView.setFitWidth(28.0);
        imageView.setLayoutX(5.0);
        imageView.setLayoutY(8.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("icons8_user_40px.png").toExternalForm()));

        circle0.setFill(javafx.scene.paint.Color.valueOf("#7cebbd"));
        circle0.setLayoutX(27.0);
        circle0.setLayoutY(30.0);
        circle0.setRadius(5.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#0000007c"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        Friendname.setLayoutX(46.0);
        Friendname.setLayoutY(11.0);
        Friendname.setPrefHeight(17.0);
        Friendname.setPrefWidth(82.0);
        Friendname.setText(" ");
        Friendname.setTextFill(javafx.scene.paint.Color.valueOf("#838080"));
        Friendname.setFont(new Font("Calibri", 12.0));
        
       
        
        getChildren().add(circle);
        getChildren().add(imageView);
        getChildren().add(circle0);
        getChildren().add(Friendname);

    }
     public void setFriendName(String s)
        {
         Friendname.setText(s);
        }
  
     public void onlinestatus(Boolean b)
        {
        // Friendname.setText(b);
        }
     
     
 }
     
     
     class Listicon extends AnchorPane {
         private ToDoEntity todo;
    protected final ImageView imageView;
    protected  Label label;
    public Listicon(ToDoEntity todo) {
        
        this.todo = todo;
        imageView = new ImageView();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(25.0);
        setPrefWidth(184.0);

        imageView.setFitHeight(19.0);
        imageView.setFitWidth(21.0);
        imageView.setLayoutX(5.0);
        imageView.setLayoutY(4.0);
        imageView.setOpacity(0.54);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("icons8_menu_filled_50px_1.png").toExternalForm()));

        label.setLayoutX(39.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(100.0);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#2c2a2a"));
        label.setFont(new Font(16.0));
        label.setText(todo.getTitle());
        getChildren().add(imageView);
        getChildren().add(label);
        
          label.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             actions();
             TITLE.setText(todo.getTitle());
            }
        });
        
    }
}



 class Tasks extends AnchorPane {

    protected  JFXCheckBox jFXCheckBox;
    protected  Line line;
    protected  Line line0;
    protected  Label label;

    public Tasks() {

        jFXCheckBox = new JFXCheckBox();
        line = new Line();
        line0 = new Line();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(39.0);
        setPrefWidth(450.0);

        jFXCheckBox.setLayoutX(33.0);
        jFXCheckBox.setLayoutY(6.0);
        jFXCheckBox.setStyle("-fx-background-color: #fefefe;");
        jFXCheckBox.setFont(new Font(16.0));

        line.setEndX(-62.121307373046875);
        line.setEndY(-216.0);
        line.setLayoutX(63.0);
        line.setLayoutY(255.0);
        line.setStartX(-62.121307373046875);
        line.setStartY(-262.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#c654ad"));
        line.setStrokeWidth(3.0);

        line0.setEndX(450.0000305175781);
        line0.setEndY(40.5);
        line0.setStartX(64.37869262695312);
        line0.setStartY(40.5);
        line0.setStroke(javafx.scene.paint.Color.valueOf("#8f8c8ccb"));

        label.setLayoutX(64.0);
        label.setLayoutY(7.0);
         //label.setText("omnia");
        label.setFont(new Font(16.0));

        getChildren().add(jFXCheckBox);
        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(label);
        
      
    }
        public void setTaskname(String s)
        {
         label.setText(s);
        }
}
    public void createTodoList(ToDoEntity todo){
        Platform.runLater(() ->  {
        Listicon  Litem=new Listicon(todo);
        LIST.getChildren().add(Litem);
        });
    }
}
