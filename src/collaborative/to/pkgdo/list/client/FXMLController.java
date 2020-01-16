/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

import Controllers.CollaboratorController;
import Controllers.ToDoListController;
import Entities.CollaborationRequestEntity;
import Entities.ItemEntity;
import Entities.ToDoEntity;
import Entities.UserEntity;
import Handlers.AcceptCollaboratorRequestHandler;
import Entities.TaskEntity;
import Entities.ToDoEntity;
import Entities.UserEntity;
import Handlers.TaskCreationHandler;
import Handlers.ToDoCreationHandler;
import Handlers.ToDoDeleteHandler;
import Handlers.ToDoUpdateHandler;
import Utils.CurrentUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
/**
 *
 * @author Abd-Elmalek
 */
public class FXMLController implements Initializable  {
    UserEntity currentUser;
    Listicon currentlyViewedTodoList;
   
    //Friendicon Fitem=new Friendicon();
    //Friendicon Fitem2=new Friendicon();
    //Listicon  Litem=new Listicon();
    //Listicon  Litem2=new Listicon();
    Item task=new Item();
    Item task2=new Item();

   // Task item=new Task(null);
  //  Task item2=new Task(null);
    //Collaborator col=new Collaborator();
    Notification notif=new Notification();
    //Friendtoadd fc=new Friendtoadd();
    //Friendtoadd fc2=new Friendtoadd();
    
    @FXML
    
    public JFXButton  MINIMIZE;
    public JFXButton  EXIT;
    public VBox FRIENDSLIST;
     @FXML
    public VBox LIST;
    public VBox COLLABORATORS; 
    public VBox NOTIFICATIONS;
    public VBox aDDRIENDCOLABLIST;
    public VBox FRIENDREQS;
    public VBox COLLABORATIONREQS;
    
    FriendRequest f = new FriendRequest();
    
    @FXML
    public Accordion TASKLISTS;
    public ScrollPane FRIENDSSCROLL;
    public ScrollPane LISTSCROLL;
    public ScrollPane COLLABSCROLL;
    
    public JFXButton FRIENDS;
    public JFXButton LISTS;
    public JFXButton nEWLIST;
    public JFXButton ADDDATE;
    public JFXButton ADDDATE1;
    public JFXButton DATEPICK;
    
    public AnchorPane TODOPANE;
    public AnchorPane LISTPANE;
    public AnchorPane NOTIFIPANE;
    public AnchorPane FRIENDPANE;
    public AnchorPane TODAYPANE;
    public AnchorPane STATUSPANE;
    public AnchorPane REQUESTPANE;
    public AnchorPane DATEPANE;
    public AnchorPane ADDLISTPANE;
    public AnchorPane ADDCOLLABORATORPANE;
    public AnchorPane EDITLISTAP;
    
    public JFXButton REQUESTS;
    public JFXButton TODAY;
    public JFXButton STATUS;
    
    public Line linelists;
    public Line linefriends;
    
    public JFXButton SHOWNOTIFICATIONS;
    public JFXButton CLEARDATE;
    public JFXButton SAVEDATE;
    public JFXButton NEWCOLLABORATOR;
    public JFXButton DONEADDCOLLABORATOR;
    public JFXButton CANCELLIST;
    public JFXButton CANCELLIST1;
    public JFXButton EDITLIST;
    
    public JFXDatePicker STARTDATE;
    public JFXDatePicker ENDDATE;
    
    public JFXTextField NEWTODOTITLE;
    public JFXTextField NEWTODOTITLE1;

    public Label USERNAME;
    public Label TITLE;
    
    public Circle TODOCOLOR;
    public Circle TODOEDITCOLOR;
    public ImageView ADDCOLLAB;
    public ImageView EDITLISTIMG;

    void disableUIForNotification(){
        MINIMIZE.setDisable(true);
        EXIT.setDisable(true);
        FRIENDSLIST.setDisable(true);
        LISTSCROLL.setDisable(true);
        COLLABSCROLL.setDisable(true);
        FRIENDS.setDisable(true);
        LISTS.setDisable(true);
        nEWLIST.setDisable(true);
        ADDDATE.setDisable(true);
        DATEPICK.setDisable(true);
        TODOPANE.setDisable(true);
        LISTPANE.setDisable(true);
        FRIENDPANE.setDisable(true);
        TODAYPANE.setDisable(true);
        STATUSPANE.setDisable(true);
        REQUESTPANE.setDisable(true);
        DATEPANE.setDisable(true);
        ADDLISTPANE.setDisable(true);
        REQUESTS.setDisable(true);
        TODAY.setDisable(true);
        STATUS.setDisable(true);
        
        NEWCOLLABORATOR.setDisable(true);
        ADDCOLLABORATORPANE.setDisable(true);
    } 
    @FXML
       public void nav(MouseEvent event) {
           
           if(event.getSource()==LISTS){
            
            FRIENDPANE.setVisible(false);
            LISTPANE.setVisible(true);
            linelists.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
            linefriends.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
          }
         else if(event.getSource()==FRIENDS){
             
            FRIENDPANE.setVisible(true);
            LISTPANE.setVisible(false);
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
       
        if(event.getSource()==nEWLIST){
            
            ADDLISTPANE.setVisible(true);
          }
        else if(event.getSource() == EDITLIST){
            NEWTODOTITLE1.setText(currentlyViewedTodoList.getTodo().getTitle());
                        
            STARTDATE.setValue(LocalDateTime.ofInstant(Instant.ofEpochMilli(currentlyViewedTodoList.getTodo().getAssignDate().getTime()), ZoneId.systemDefault()).toLocalDate());
            ENDDATE.setValue(LocalDateTime.ofInstant(Instant.ofEpochMilli(currentlyViewedTodoList.getTodo().getDeadLineDate().getTime()), ZoneId.systemDefault()).toLocalDate());
            
            EDITLISTAP.setVisible(true);
        }
        else if(event.getSource()==CLEARDATE){
             STARTDATE.setValue(null);
             ENDDATE.setValue(null);
          }
        else if(event.getSource()==SAVEDATE){
            DATEPANE.setVisible(false);
        }
         else if(event.getSource()==SHOWNOTIFICATIONS){
             
             if(NOTIFIPANE.isVisible())
                NOTIFIPANE.setVisible(false);
             else
                 NOTIFIPANE.setVisible(true);
             
            
          }
         else if(event.getSource() == NEWCOLLABORATOR){
             ADDCOLLABORATORPANE.setVisible(true);
         }
         else if(event.getSource() == DONEADDCOLLABORATOR){
             ADDCOLLABORATORPANE.setVisible(false);
         }
         else if(event.getSource() == CANCELLIST || event.getSource() == CANCELLIST1){
             if(TODOCOLOR != null)
                 TODOCOLOR.setStroke(Color.TRANSPARENT);
             TODOCOLOR = null;
             STARTDATE.setValue(null);
             ENDDATE.setValue(null);
             NEWTODOTITLE.setText("");
             ADDLISTPANE.setVisible(false);
             EDITLISTAP.setVisible(false);
         }
         else if(event.getSource() == ADDDATE || event.getSource() == ADDDATE1){
             
             DATEPANE.setVisible(true);
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
     

//      
//      public static boolean inHierarchy(Node node, Node potentialHierarchyElement) {
//    if (potentialHierarchyElement == null) {
//        return true;
//    }
//    while (node != null) {
//        if (node == potentialHierarchyElement) {
//            return true;
//        }
//        node = node.getParent();
//    }
//    return false;
//}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*REHAM*/
        ToDoCreationHandler.setTodoGUIGenerator(this::createTodoListResponse);
        ToDoUpdateHandler.setTodoGUIModifier(this::updateTodoListResponse);
        ToDoDeleteHandler.setTodoGUIModifier(this::deleteTodoListResponse);
        
        AcceptCollaboratorRequestHandler.setCollaboratorsGUIModifier(this::acceptTodoCollaborationResponse);
        
        currentUser = CurrentUser.getCurrentUser();
        /*REHAM*/
      /*abd-elmalek */
      
        
      /*abd-elamlek*/
      
     

      FRIENDREQS.getChildren().add(f);
      COLLABORATIONREQS.getChildren().add(new CollaborationRequest());
      COLLABORATIONREQS.getChildren().add(new TaskAssignmentRequest());
      //COLLABORATORS.getChildren().add(col);
      //aDDRIENDCOLABLIST.getChildren().add(fc);
      //aDDRIENDCOLABLIST.getChildren().add(fc2);
      
      NOTIFICATIONS.getChildren().add(notif);
      
      TASKLISTS.getPanes().add(task);
      TASKLISTS.getPanes().add(task2);
      FRIENDPANE.setVisible(false);
      LISTPANE.setVisible(true);
      linelists.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
      linefriends.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
      
      /*DATEPICK.focusedProperty().addListener(new ChangeListener<Boolean>()
         {
          @Override
         public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
             if (newPropertyValue||DATEPANE.isFocused())
                {
                DATEPANE.setVisible(true);
              }
            else
              {
               
                 DATEPANE.setVisible(false);
              }
            }
        }); */
       /*ADDDATE.focusedProperty().addListener(new ChangeListener<Boolean>()
         {
          @Override
         public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
             if (newPropertyValue||DATEPANE.isFocused())
                {
                DATEPANE.setVisible(true);
              }
            else
              {
               
                 DATEPANE.setVisible(false);
              }
            }
        }); */
     
        initiateCurrentUser();
    }  
       
     class Comment extends AnchorPane {

    protected final Label label;

    public Comment() {

        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(29.0);
        setPrefWidth(250.0);
        setStyle("-fx-background-color: #fefefe; -fx-background-radius: 2;");

        label.setLayoutX(5.0);
        label.setLayoutY(2.0);
        label.setPrefHeight(25.0);
        label.setPrefWidth(243.0);
        label.setText("Comment....");
        label.setFont(new Font("Calibri Light", 12.0));

        getChildren().add(label);

    }
}
    
    
    class Notification extends AnchorPane {

    protected final JFXTextArea jFXTextArea;

    public Notification() {

        jFXTextArea = new JFXTextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(50.0);
        setPrefWidth(319.0);
        setStyle("-fx-background-color: #fefefe; -fx-background-radius: 2;");

        jFXTextArea.setLayoutX(8.0);
        jFXTextArea.setStyle("-fx-background-color: #fefefe;");
        jFXTextArea.setPromptText("Notifications are here");
        jFXTextArea.setEditable(false);
        jFXTextArea. setPrefHeight(43.0);
        jFXTextArea. setPrefWidth(311.0);
        jFXTextArea.unFocusColorProperty().set(javafx.scene.paint.Color.valueOf("#c2bdbd"));
        getChildren().add(jFXTextArea);

    }
}

class Friendtoadd extends AnchorPane {

    private UserEntity friend;
    protected final ImageView imageView;
    protected final Label label;
    protected final ImageView imageView0;
    protected final JFXButton aDDCOLL;

    public Friendtoadd(UserEntity friend) {

        this.friend = friend;
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
        label.setText(friend.getUserName());
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


    
class  Collaborator extends AnchorPane {

    protected Circle circle;
    protected  DropShadow dropShadow;
    protected  ImageView imageView;
    protected  Circle circle0;
    protected  Label collaboratorName;
    
    private UserEntity collaborator;

    public Collaborator(UserEntity collaborator) {

        this.collaborator = collaborator;
        
        circle = new Circle();
        dropShadow = new DropShadow();
        imageView = new ImageView();
        circle0 = new Circle();
        collaboratorName = new Label();

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

        collaboratorName.setLayoutX(46.0);
        collaboratorName.setLayoutY(11.0);
        collaboratorName.setPrefHeight(17.0);
        collaboratorName.setPrefWidth(82.0);
        collaboratorName.setText(collaborator.getUserName());
        collaboratorName.setTextFill(javafx.scene.paint.Color.valueOf("#838080"));
        collaboratorName.setFont(new Font("Calibri", 12.0));
        
       
        
        getChildren().add(circle);
        getChildren().add(imageView);
        getChildren().add(circle0);
        getChildren().add(collaboratorName);

    }
     public void setFriendName(String s)
        {
         collaboratorName.setText(s);
        }
  
     public void onlinestatus(Boolean b)
        {
        // Friendname.setText(b);
        }
     
     
 }





 class  Friendicon extends AnchorPane {

    protected Circle circle;
    protected  DropShadow dropShadow;
    protected  ImageView imageView;
    protected  Circle circle0;
    protected  Label Friendname;
    private UserEntity friend;

    public Friendicon(UserEntity friend) {
        
        this.friend = friend;
        
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
        Friendname.setText(friend.getUserName());
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
         private boolean isOwnedByCurrentUser = false;
         VBox TODOCOLLABORATORS; // create "collaborator" and attach them to this, Collaborator(UserEntity)
         List<Integer> collaboratorsIds = new ArrayList<Integer>();
         List<Integer> requestedCollaboratorsIds = new ArrayList<Integer>();

         VBox FRIENDSTOADDASCOLLABORATORS;
         
         
         protected final ImageView imageView;
         protected  Label label;

    public Listicon(ToDoEntity todo, boolean isOwnedByCurrentUser) {
        
        this.todo = todo;
        this.isOwnedByCurrentUser = isOwnedByCurrentUser;
        
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
        
        TODOCOLLABORATORS = new VBox();
        FRIENDSTOADDASCOLLABORATORS = new VBox();


        if(todo.getCollaboratorList() != null){
            for(UserEntity collaborator : todo.getCollaboratorList()){
                
                Collaborator item = new Collaborator(collaborator);
                TODOCOLLABORATORS.getChildren().add(item);
            }
            
            todo.getCollaboratorList().forEach((collaborator) -> collaboratorsIds.add(collaborator.getId()));
            todo.getRequestedCollaboratorList().forEach((collaborator) -> requestedCollaboratorsIds.add(collaborator.getId()));

        }
        
        if(currentUser.getFriendList() != null){
            for(UserEntity friend : currentUser.getFriendList()){
                
                if(!collaboratorsIds.contains(friend.getId()) && !requestedCollaboratorsIds.contains(friend.getId())){
                    System.out.println(friend.getUserName());
                    Friendtoadd item = new Friendtoadd(friend);
                    FRIENDSTOADDASCOLLABORATORS.getChildren().add(item);
                }
            }
        }
        
        viewTodo();
        label.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             actions();
             viewTodo();             
            }
        }); 
    }
    public void addCollaborator(Collaborator collaborator){
        Platform.runLater(() ->  {
            TODOCOLLABORATORS.getChildren().add(collaborator);
        });
    }
    public boolean getIsOwnedByCurrentUser(){
        return isOwnedByCurrentUser;
    }
    public ToDoEntity getTodo(){
        return todo;
    }
    public void viewTodo(){
        TITLE.setText(todo.getTitle());
        COLLABORATORS.getChildren().setAll(TODOCOLLABORATORS);
        aDDRIENDCOLABLIST.getChildren().setAll(FRIENDSTOADDASCOLLABORATORS);

        NEWCOLLABORATOR.setVisible(isOwnedByCurrentUser);
        ADDCOLLAB.setVisible(isOwnedByCurrentUser);
        
        EDITLIST.setVisible(isOwnedByCurrentUser);
        EDITLISTIMG.setVisible(isOwnedByCurrentUser);
        
        currentlyViewedTodoList = Listicon.this;
    }
}


public class Item extends TitledPane {

    protected final AnchorPane anchorPane;
    protected final JFXCheckBox jFXCheckBox;
    protected final Label label;
    protected final Line line;
    protected final Line line0;
    protected final ScrollPane scrollPane;
    protected final AnchorPane anchorPane0;
    protected final VBox vBox;
    //private ItemEntity item;
    
    public Item() {
        Addtaskpane bar=new Addtaskpane();
        anchorPane = new AnchorPane();
        jFXCheckBox = new JFXCheckBox();
        label = new Label();
        line = new Line();
        line0 = new Line();
        scrollPane = new ScrollPane();
        anchorPane0 = new AnchorPane();
        vBox = new VBox();
        vBox.getChildren().add(bar);
        setGraphicTextGap(2.0);
        setMaxHeight(450.0);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(259.0);
        setPrefWidth(450.0);
        getStylesheets().add("/collaborative/to/pkgdo/list/client/tabpane.css");

        anchorPane.setPrefHeight(40.0);
        anchorPane.setPrefWidth(449.0);

        jFXCheckBox.setLayoutX(30.0);
        jFXCheckBox.setLayoutY(11.0);

        label.setLayoutX(56.0);
        label.setLayoutY(10.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(374.0);
        label.setText("Omnias Item");
        label.setFont(new Font(15.0));

        line.setEndX(-121.0);
        line.setEndY(26.0);
        line.setLayoutX(122.0);
        line.setLayoutY(12.0);
        line.setStartX(-121.0);
        line.setStartY(-22.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#cd0f97"));
        line.setStrokeWidth(3.0);

        line0.setEndX(291.0);
        line0.setEndY(1.5);
        line0.setLayoutX(158.0);
        line0.setLayoutY(38.0);
        line0.setStartX(-104.29290771484375);
        line0.setStartY(1.5);
        line0.setStroke(javafx.scene.paint.Color.valueOf("#726d6d"));
        line0.setStrokeWidth(0.2);
        setGraphic(anchorPane);
        setFont(new Font(16.0));

        scrollPane.setPrefHeight(216.0);
        scrollPane.setPrefWidth(426.0);
        scrollPane.getStylesheets().add("/collaborative/to/pkgdo/list/client/tabpane.css");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        anchorPane0.setPrefWidth(425.0);

        vBox.setLayoutX(36.0);
        vBox.setPrefWidth(405.0);
        scrollPane.setContent(anchorPane0);
        setContent(scrollPane);

        anchorPane.getChildren().add(jFXCheckBox);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(line);
        anchorPane.getChildren().add(line0);
        anchorPane0.getChildren().add(vBox);
        
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setDecription("desc");
        addTask(taskEntity);
        
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             if(TASKLISTS.getHeight()>((TASKLISTS.getChildrenUnmodifiable().size()*40)+259))
             { 
               TASKLISTS.setPrefHeight((TASKLISTS.getChildrenUnmodifiable().size()*40.0)+259.0);
             setPrefHeight(259.0);
             }
            
            }
        });
        
        
        TaskCreationHandler.setTodoGUIGenerator(this::createTaskResponse);
    }

 public void createTaskResponse(TaskEntity task){
            Platform.runLater(() ->  {
                addTask(task);
            });
    }


   void addTask(TaskEntity taskEntity){
        Task i=new Task(taskEntity);
         vBox.getChildren().add(i);
        
    }
    }     
     
     
     
     
     

class Task extends AnchorPane {

    protected  JFXCheckBox jFXCheckBox;
    protected  Line line;
    protected  Line line0;
    protected  Label label;

    public Task(TaskEntity taskjEntity ) {

        jFXCheckBox = new JFXCheckBox();
        line = new Line();
       
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(35.0);
        setPrefWidth(405);

        jFXCheckBox.setLayoutX(33.0);
        jFXCheckBox.setLayoutY(6.0);
        jFXCheckBox.setStyle("-fx-background-color: #fefefe;");
        jFXCheckBox.setFont(new Font(16.0));

        line.setEndX(-62.121307373046875);
        line.setEndY(-216.0);
        line.setLayoutX(63.0);
        line.setLayoutY(255.0);
        line.setStartX(-62.121307373046875);
        line.setStartY(-257.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#c654ad"));
        line.setStrokeWidth(3.0);

       

        label.setLayoutX(64.0);
        label.setLayoutY(7.0);
         //label.setText("omnia");
        label.setFont(new Font(14.0));


        getChildren().add(jFXCheckBox);
        getChildren().add(line);
       
        getChildren().add(label);
        
        setTaskname(taskjEntity.getDecription());
        if(taskjEntity.getStatus()==1){
            jFXCheckBox.setSelected(true);
        }
    }
        public void setTaskname(String s)
        {
         label.setText(s);
        }
        
}
    
    /*REHAM*/

    public class FriendRequest extends AnchorPane {

        protected final ImageView imageView;
        protected final JFXButton jFXButton;
        protected final JFXButton jFXButton0;
        protected final Label label;

        public FriendRequest() {

            imageView = new ImageView();
            jFXButton = new JFXButton();
            jFXButton0 = new JFXButton();
            label = new Label();

            setMaxHeight(USE_PREF_SIZE);
            setMaxWidth(USE_PREF_SIZE);
            setMinHeight(USE_PREF_SIZE);
            setMinWidth(USE_PREF_SIZE);
            setPrefHeight(47.0);
            setPrefWidth(413.0);

            imageView.setFitHeight(32.0);
            imageView.setFitWidth(32.0);
            imageView.setLayoutX(14.0);
            imageView.setLayoutY(11.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            imageView.setImage(new Image(getClass().getResource("icons8-user-30.png").toExternalForm()));
            imageView.setOpacity(0.46);

            jFXButton.setLayoutX(225.0);
            jFXButton.setLayoutY(10.0);
            jFXButton.setPrefWidth(79);
            jFXButton.setPrefHeight(25);
            jFXButton.setText("Accept");
            jFXButton.setStyle("-fx-background-color: #3b8ef4;");
            jFXButton.setTextFill(Color.web("#fffbfb"));

            jFXButton0.setLayoutX(317.0);
            jFXButton0.setLayoutY(10.0);
            jFXButton0.setPrefWidth(79);
            jFXButton0.setPrefHeight(25);
            jFXButton0.setText("Reject");
            jFXButton0.setStyle("-fx-background-color:  #f0f1f5;");

            label.setLayoutX(54.0);
            label.setLayoutY(17.0);
            label.setText("MonaEzzat");
            label.setPrefWidth(152);
            label.prefHeight(21);

            getChildren().add(imageView);
            getChildren().add(jFXButton);
            getChildren().add(jFXButton0);
            getChildren().add(label);

        }
    }
    public class CollaborationRequest extends AnchorPane {

        protected final ImageView imageView;
        protected final JFXButton jFXButton;
        protected final JFXButton jFXButton0;
        protected final Label label;

        public CollaborationRequest() {

            imageView = new ImageView();
            jFXButton = new JFXButton();
            jFXButton0 = new JFXButton();
            label = new Label();

            setMaxHeight(USE_PREF_SIZE);
            setMaxWidth(USE_PREF_SIZE);
            setMinHeight(USE_PREF_SIZE);
            setMinWidth(USE_PREF_SIZE);
            setPrefHeight(47.0);
            setPrefWidth(413.0);

            imageView.setFitHeight(32.0);
            imageView.setFitWidth(28.0);
            imageView.setLayoutX(14.0);
            imageView.setLayoutY(11.0);
            //imageView.setOpacity(0.75);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            imageView.setImage(new Image(getClass().getResource("icons8_menu_filled_50px_1.png").toExternalForm()));
            imageView.setOpacity(0.54);
            
            //imageView.setFitHeight(19.0);
            //imageView.setFitWidth(21.0);
       
        
        

            jFXButton.setLayoutX(225.0);
            jFXButton.setLayoutY(10.0);
            jFXButton.setPrefWidth(79);
            jFXButton.setPrefHeight(25);
            jFXButton.setText("Accept");
            jFXButton.setStyle("-fx-background-color: #3b8ef4;");
            jFXButton.setTextFill(Color.web("#fffbfb"));

            jFXButton0.setLayoutX(317.0);
            jFXButton0.setLayoutY(10.0);
            jFXButton0.setPrefWidth(79);
            jFXButton0.setPrefHeight(25);
            jFXButton0.setText("Reject");
            jFXButton0.setStyle("-fx-background-color:  #f0f1f5;");

            label.setLayoutX(54.0);
            label.setLayoutY(17.0);
            label.setText("My Todo");
            label.setPrefWidth(152);
            label.prefHeight(21);

            getChildren().add(imageView);
            getChildren().add(jFXButton);
            getChildren().add(jFXButton0);
            getChildren().add(label);

        }
    }
    
    public class TaskAssignmentRequest extends AnchorPane {

        protected final ImageView imageView;
        protected final JFXButton jFXButton;
        protected final JFXButton jFXButton0;
        protected final Label label;

        public TaskAssignmentRequest() {

            imageView = new ImageView();
            jFXButton = new JFXButton();
            jFXButton0 = new JFXButton();
            label = new Label();

            setMaxHeight(USE_PREF_SIZE);
            setMaxWidth(USE_PREF_SIZE);
            setMinHeight(USE_PREF_SIZE);
            setMinWidth(USE_PREF_SIZE);
            setPrefHeight(47.0);
            setPrefWidth(413.0);

            imageView.setFitHeight(32.0);
            imageView.setFitWidth(32.0);
            imageView.setLayoutX(14.0);
            imageView.setLayoutY(11.0);
            //imageView.setOpacity(0.75);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            imageView.setImage(new Image(getClass().getResource("icons8-task-planning-24.png").toExternalForm()));
            imageView.setOpacity(0.54);
            
            //imageView.setFitHeight(19.0);
            //imageView.setFitWidth(21.0);
       
        
        

            jFXButton.setLayoutX(225.0);
            jFXButton.setLayoutY(10.0);
            jFXButton.setPrefWidth(79);
            jFXButton.setPrefHeight(25);
            jFXButton.setText("Accept");
            jFXButton.setStyle("-fx-background-color: #3b8ef4;");
            jFXButton.setTextFill(Color.web("#fffbfb"));

            jFXButton0.setLayoutX(317.0);
            jFXButton0.setLayoutY(10.0);
            jFXButton0.setPrefWidth(79);
            jFXButton0.setPrefHeight(25);
            jFXButton0.setText("Reject");
            jFXButton0.setStyle("-fx-background-color:  #f0f1f5;");

            label.setLayoutX(54.0);
            label.setLayoutY(17.0);
            label.setText("My Task");
            label.setPrefWidth(152);
            label.prefHeight(21);

            getChildren().add(imageView);
            getChildren().add(jFXButton);
            getChildren().add(jFXButton0);
            getChildren().add(label);

        }
    }
    
    public void initiateCurrentUser(){
        USERNAME.setText(currentUser.getUserName());
        
        if(currentUser.getTodoList() != null)
            for(ToDoEntity todo : currentUser.getTodoList()){
                Listicon  item = new Listicon(todo, true);
                LIST.getChildren().add(item);
            }
        
        
        if(currentUser.getCollaboratorList()!= null)
            for(ToDoEntity todo : currentUser.getCollaboratorList()){
                Listicon  item = new Listicon(todo, false);
                LIST.getChildren().add(item);
            }
        
        if(currentUser.getFriendList() != null)
            for(UserEntity friend : currentUser.getFriendList()){
                Friendicon Fitem=new Friendicon(friend);
                FRIENDSLIST.getChildren().add(Fitem);
            }
        
        
    } 
    public void acceptTodoCollaborationResponse(UserEntity collaborator, int todoId){
        System.out.println("in acceptTodoCollaborationResponse");
        System.err.println(todoId);
        for(int i = 0 ; i < LIST.getChildren().size() ; i++){
            System.out.println(((Listicon)LIST.getChildren().get(i)).getTodo().getId());
           if(((Listicon)LIST.getChildren().get(i)).getTodo().getId() == todoId){
               System.out.println("I found the todo");
               Collaborator collaboratorItem = new Collaborator(collaborator);
               ((Listicon)LIST.getChildren().get(i)).addCollaborator(collaboratorItem);
               break;
           }
        }
    }
    public void createTodoListResponse(ToDoEntity todo, boolean isOwner){
        Platform.runLater(() ->  {
            Listicon  Litem=new Listicon(todo, isOwner);
            LIST.getChildren().add(Litem);
        });
    }
    
    
    public void setTodoColor(MouseEvent event){
        if(TODOCOLOR != null)
            TODOCOLOR.setStroke(Color.TRANSPARENT);
        
        TODOCOLOR = (Circle)event.getSource();
        TODOCOLOR.setStroke(Color.BLACK);
    }
    public void updateTodoListResponse(ToDoEntity todo){
        //boolean isOwnedByCurrentUser = ((Listicon)(LIST.getChildren().get(todoIndex))).getIsOwnedByCurrentUser();
       Platform.runLater(() ->  {
        for(int i = 0 ; i < LIST.getChildren().size() ; i++)
           if(((Listicon)LIST.getChildren().get(i)).getTodo().getId() == todo.getId()){
               //System.out.println("title: "+((Listicon)node).getTodo().getTitle());
               System.out.println("my index here is: " + i);
               LIST.getChildren().set(i, new Listicon(todo, ((Listicon)LIST.getChildren().get(i)).isOwnedByCurrentUser));
               break;
           }
       });
        /*boolean isOwnedByCurrentUser = false;
        Listicon Litem = 
        LIST.getChildren().set(todoIndex, Litem);*/
    }
    public void deleteTodoListResponse(Integer todoIndex){
        LIST.getChildren().remove(todoIndex);
    }
    public void acceptCollaborationRequest(CollaborationRequestEntity request){
        CollaboratorController collaboratorController = new CollaboratorController();
        //collaboratorController.acceptCollaboratorRequest(CurrentUser.getCurrentUser().getCollaborationRequestList().get(0));
        collaboratorController.acceptCollaboratorRequest(request);

    }
    public void deleteTodoListRequest(MouseEvent event){
        
    }
    public void updateTodoListRequest(MouseEvent event){
        ToDoListController t = new ToDoListController();
        ToDoEntity newTodo = currentlyViewedTodoList.getTodo();
        
        newTodo.setTitle(NEWTODOTITLE1.getText());
        newTodo.setAssignDate(Date.from(STARTDATE.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        newTodo.setDeadLineDate(Date.from(ENDDATE.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        if(TODOCOLOR != null)
            newTodo.setColor(TODOCOLOR.getFill().toString());
        
        t.updateToDoList(newTodo);
        updateTodoListResponse(newTodo);
        
        NEWTODOTITLE.setText("");
        STARTDATE.setValue(null);
        ENDDATE.setValue(null);
        TODOCOLOR = null;
        ADDLISTPANE.setVisible(false);
    }
    public void createTodoListRequest(MouseEvent event){
        
        String todoTitle = NEWTODOTITLE.getText();
        System.out.println(todoTitle);
                
        if(!todoTitle.equals("") && STARTDATE != null && ENDDATE != null && TODOCOLOR != null){
            Date startDate = Date.from(STARTDATE.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(ENDDATE.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

            ToDoListController tlc = new ToDoListController();
            tlc.createToDoList(new ToDoEntity(todoTitle, startDate, endDate, currentUser.getId(), 0, TODOCOLOR.getFill().toString()));
            
            NEWTODOTITLE.setText("");
            STARTDATE.setValue(null);
            ENDDATE.setValue(null);
            TODOCOLOR = null;
            ADDLISTPANE.setVisible(false);
        }
    }
    /*REHAM*/
    class Addtaskpane extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected  JFXTextField ADDTASK1;

    public Addtaskpane() {

        anchorPane = new AnchorPane();
        ADDTASK1 = new JFXTextField();

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
        ADDTASK1.setPrefWidth(384.0);
        ADDTASK1.unFocusColorProperty().set(javafx.scene.paint.Color.valueOf("#f0f1f5") );
        ADDTASK1.setPromptText("Add Task and press enter to save");
        anchorPane.getChildren().add(ADDTASK1);
        getChildren().add(anchorPane);

    }
}
}
