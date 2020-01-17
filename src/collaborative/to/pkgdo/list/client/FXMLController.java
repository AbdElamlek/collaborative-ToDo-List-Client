/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;


import Controllers.ItemController;
import Handlers.ItemCreationHandler;
import Controllers.ToDoListController;
import Entities.ItemEntity;
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
import Handlers.ItemDeletionHandler;
import Handlers.ItemUpdateHandler;
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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.List;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.paint.Color;
/**
 *
 * @author Abd-Elmalek
 */
public class FXMLController implements Initializable  {
    UserEntity currentUser;
    ItemController itemController = new ItemController();
    ArrayList<Integer> itemsIndecies;
    int itemsCounter = 0;
   
    
    private static ToDoEntity currentToDo = null ;
   // Friendicon Fitem=new Friendicon();
   // Friendicon Fitem2=new Friendicon();
    //Listicon  Litem=new Listicon();
    //Listicon  Litem2=new Listicon();
   // Item task=new Item();
   // Item task2=new Item();
    //Friendicon Fitem=new Friendicon();
    //Friendicon Fitem2=new Friendicon();
    //Listicon  Litem=new Listicon();
    //Listicon  Litem2=new Listicon();
    //Item task=new Item();
    //Item task2=new Item();

   // Task item=new Task(null);
  //  Task item2=new Task(null);
    //Collaborator col=new Collaborator();
    Notification notif=new Notification();
    //Friendtoadd fc=new Friendtoadd();
    //Friendtoadd fc2=new Friendtoadd();
    TodoStatstics bar1=new TodoStatstics();
    TodoStatstics bar2=new TodoStatstics();
    TodoStatstics bar3=new TodoStatstics();
    
    
    @FXML
    
    public JFXButton  MINIMIZE;
    public JFXButton  EXIT;
    public VBox FRIENDSLIST;
     @FXML
    public VBox LIST;
    public VBox COLLABORATORS; 
    public VBox NOTIFICATIONS;
    public VBox aDDRIENDCOLABLIST;
    public HBox sSTATISTICS;
    @FXML
    public Accordion TASKLISTS;
    public ScrollPane FRIENDSSCROLL;
    public ScrollPane LISTSCROLL;
    public ScrollPane COLLABSCROLL;
    @FXML
    public ImageView testButton; 
    public JFXTextField ADDTASK;
    public JFXButton FRIENDS;
    public JFXButton LISTS;
    public JFXButton nEWLIST;
    public JFXButton ADDDATE;
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
    
    public JFXDatePicker STARTDATE;
    public JFXDatePicker ENDDATE;
    
    public JFXTextField NEWTODOTITLE;

    public Label USERNAME;
    public Label TITLE;
    
    public Circle TODOCOLOR;
    public ImageView ADDCOLLAB;
    public 
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
         else if(event.getSource() == CANCELLIST){
             if(TODOCOLOR != null)
                 TODOCOLOR.setStroke(Color.TRANSPARENT);
             TODOCOLOR = null;
             STARTDATE.setValue(null);
             ENDDATE.setValue(null);
             NEWTODOTITLE.setText("");
             ADDLISTPANE.setVisible(false);
         }
         else if(event.getSource() == ADDDATE){
             
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
        sSTATISTICS.getChildren().add(bar1);
        sSTATISTICS.getChildren().add(bar2);
        sSTATISTICS.getChildren().add(bar3);
        AcceptCollaboratorRequestHandler.setCollaboratorsGUIModifier(this::acceptTodoCollaborationResponse);
        
        currentUser = CurrentUser.getCurrentUser();
        /*REHAM*/
      /*abd-elmalek */
      ADDTASK.setOnKeyPressed((KeyEvent event) -> {
          if(event.getCode()== KeyCode.ENTER){
              System.out.println(ADDTASK.getText());
              ItemEntity itemEntity = new ItemEntity();
              itemEntity.setTitle(ADDTASK.getText());
              itemEntity.setDecription("descriotion");
              itemEntity.setTodoId(currentToDo.getId());
              Item i = new Item(itemEntity);
             //TASKLISTS.getPanes().add(i);
             try{
             CurrentUser.getCurrentUser().getTodoList().get(CurrentUser.getCurrentUser().getTodoList().indexOf(currentToDo)).getItemsList().add(itemEntity);
             }catch(Exception e){
                 e.printStackTrace();
             }
              itemController.createItem(itemEntity);
              ADDTASK.clear();
          }
      });
//      testButton.setOnMousePressed((MouseEvent event) -> {
  //        itemController.deleteItem(currentToDo.getItemsList().get(0));
    //      TASKLISTS.getPanes().remove(0);
      //  });
        
      /*abd-elamlek*/
      
     

      
      //COLLABORATORS.getChildren().add(col);
      //aDDRIENDCOLABLIST.getChildren().add(fc);
      //aDDRIENDCOLABLIST.getChildren().add(fc2);
      
      NOTIFICATIONS.getChildren().add(notif);
      
//      TASKLISTS.getPanes().add(task);
 //     TASKLISTS.getPanes().add(task2);
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
       
    private void setItemList(){
    
    for(ToDoEntity toDoEntity : CurrentUser.getCurrentUser().getTodoList()){
        for(ItemEntity itemEntity : toDoEntity.getItemsList()){
        
        
        }
    }
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
    protected final ContextMenu menu=new ContextMenu();
    protected MenuItem delete=new MenuItem("Delete");
    
    


    public Friendicon(UserEntity friend) {
        
         delete.setOnAction((event) -> {
            System.out.println("delete");
        });
    
        menu.getItems().addAll(delete);

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
        Friendname.setContextMenu(menu);
       
        
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
    protected final ContextMenu menu=new ContextMenu();
    protected MenuItem delete=new MenuItem("Delete");
    private boolean isOwnedByCurrentUser = false;
    protected  Label label;
    VBox TODOCOLLABORATORS; // create "collaborator" and attach them to this, Collaborator(UserEntity)
    VBox FRIENDSTOADDASCOLLABORATORS;
    VBox TODOITEMSLIST;
   
    List<Integer> collaboratorsIds = new ArrayList<Integer>();
    List<Integer> requestedCollaboratorsIds = new ArrayList<Integer>();

   

    public Listicon(ToDoEntity todo, boolean isOwnedByCurrentUser) {
        
        delete.setOnAction((event) -> {
            System.out.println("delete");
          });
      
        menu.getItems().addAll(delete);

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

        label.setContextMenu(menu);

        
        TODOCOLLABORATORS = new VBox();
        FRIENDSTOADDASCOLLABORATORS = new VBox();
        TODOITEMSLIST = new VBox();
        

        if(todo.getCollaboratorList()!= null){
            for(UserEntity collaborator : todo.getCollaboratorList()){
                
                Collaborator item = new Collaborator(collaborator);
                TODOCOLLABORATORS.getChildren().add(item);
            }
            try {
            todo.getCollaboratorList().forEach((collaborator) -> collaboratorsIds.add(collaborator.getId()));
            todo.getRequestedCollaboratorList().forEach((collaborator) -> requestedCollaboratorsIds.add(collaborator.getId()));    
            } catch (Exception e) {
            }
            

        }
        
        if(currentUser.getFriendList()!= null){
            for(UserEntity friend : currentUser.getFriendList()){
                
                if(!collaboratorsIds.contains(friend.getId()) && !requestedCollaboratorsIds.contains(friend.getId())){
                    System.out.println(friend.getUserName());
                    Friendtoadd item = new Friendtoadd(friend);
                    FRIENDSTOADDASCOLLABORATORS.getChildren().add(item);
                }
            }
        
        
        /*if(todo.getItemsList() != null){
            for(ItemEntity todoItem : todo.getItemsList()){
                Item item = new Item(todoItem);
                TODOITEMSLIST.getChildren().add(item);
            }
            
        }*/
        }
        label.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
             actions();
             TITLE.setText(todo.getTitle());
             currentToDo = todo;
             TASKLISTS.getPanes().clear();
             
             for(int i =0 ; i<LIST.getChildren().size();i++){
                Listicon licon = (Listicon) LIST.getChildren().get(i);
                for(ItemEntity itemEntity : todo.getItemsList()){
                    if(licon.todo.getId()== itemEntity.getTodoId()){
                        Item item = new Item(itemEntity);
                         TASKLISTS.getPanes().add(item);
                }
            }
            }
             COLLABORATORS.getChildren().setAll(TODOCOLLABORATORS);
             aDDRIENDCOLABLIST.getChildren().setAll(FRIENDSTOADDASCOLLABORATORS);
             
             NEWCOLLABORATOR.setVisible(isOwnedByCurrentUser);
             ADDCOLLAB.setVisible(isOwnedByCurrentUser);
             
            }
        });
        
        
        
    }
    void addCollaborator(Collaborator collaborator){
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
    protected final ContextMenu menu=new ContextMenu();
    protected MenuItem delete=new MenuItem("Delete");
    Addtaskpane bar=new Addtaskpane();
    
    public int itemId;
    public Item(ItemEntity itemEntity) {
         delete.setOnAction((event) -> {
            System.out.println("delete");
        });
      
        menu.getItems().addAll(delete);
        itemId = itemEntity.getId();
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
        label.setText(itemEntity.getTitle());
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
        label.setContextMenu(menu);
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
        
        label.setOnMousePressed((MouseEvent event) -> {
            deleteItem(itemEntity);
            itemController.deleteItem(itemEntity);
            
            
        });
        
        TaskCreationHandler.setTodoGUIGenerator(this::createTaskResponse);
        ItemCreationHandler.setTodoGUIGenerator(this:: createItemResponse);
        ItemUpdateHandler.setTodoGUIGenerator(this::updateItemResponse);
        ItemDeletionHandler.setTodoGUIGenerator(this::deleteItemResponse);
    }

 public void createTaskResponse(TaskEntity task){
            Platform.runLater(() ->  {
                addTask(task);
            });
    }
public void createItemResponse(ItemEntity item){
            Platform.runLater(() ->  {
                addItem(item);
            });
    }

   void addTask(TaskEntity taskEntity){
        Task i=new Task(taskEntity);
         vBox.getChildren().add(i);
        
    }
   public  void addItem(ItemEntity itemEntity){
       Item item = new Item(itemEntity);
       TASKLISTS.getPanes().add(item);
       
   }
   private void deleteItem(ItemEntity itemEntity){
        TASKLISTS.getPanes().remove(this);
   }
   
   private void deleteItemResponse(ItemEntity itemEntity){
   
       for(int i=0; i< TASKLISTS.getPanes().size();i++){
          Item i1 = (Item) TASKLISTS.getPanes().get(i);
          if(itemEntity.getId() == i1.itemId){
              TASKLISTS.getPanes().remove(i1);
              break;
          }
       }
   }
   
   private void updateItemResponse(ItemEntity itemEntity){
       for(int i=0; i< TASKLISTS.getPanes().size();i++){
          Item i1 = (Item) TASKLISTS.getPanes().get(i);
          if(itemEntity.getId() == i1.itemId){
              Item item = new Item(itemEntity);
              TASKLISTS.getPanes().set(i,item);
          }
       }
   
   }

}
     
     
     
     
     

class Task extends AnchorPane {

    protected  JFXCheckBox jFXCheckBox;
    protected  Line line;
    protected  Line line0;
    protected  Label label;
    
    protected final ContextMenu menu=new ContextMenu();
    protected MenuItem delete=new MenuItem("Delete");
    
    public Task(TaskEntity taskjEntity ) {
        delete.setOnAction((event) -> {
            System.out.println("delete");
        });
      
        menu.getItems().addAll(delete);

        jFXCheckBox = new JFXCheckBox();
        line = new Line();
       
        label = new Label();

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
        
        label.setContextMenu(menu);

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
    public void initiateCurrentUser(){
        USERNAME.setText(currentUser.getUserName());  
        if(currentUser.getTodoList() != null)
            for(ToDoEntity mtodo : currentUser.getTodoList()){
                Listicon  mLitem=new Listicon(mtodo, true);
                LIST.getChildren().add(mLitem);
            }
        
        if(currentUser.getCollaboratorList()!= null){
            for(ToDoEntity todo : currentUser.getCollaboratorList()){
                Listicon  Litem=new Listicon(todo, false);
                LIST.getChildren().add(Litem);
            }
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
        ToDoEntity newTodo = ((Listicon)LIST.getChildren().get(0)).getTodo();
        newTodo.setTitle("My Family");
        newTodo.setStatus(100);
        //(43, "My House", new Date(), new Date(), 11, 100, null);
        t.updateToDoList(newTodo);
        updateTodoListResponse(newTodo);
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
    
    /*abd-elmalek*/
    
    
    /*abd-elmalek*/
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
    
    class TodoStatstics extends AnchorPane {

    protected final Label label;
    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final Glow glow;
    protected final Label label0;

    public TodoStatstics() {

        label = new Label();
        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        glow = new Glow();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(252.0);
        setPrefWidth(80.0);
        setStyle("-fx-background-color: #fefefe; -fx-background-radius: 2;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(12.0);
        label.setLayoutY(232.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(57.0);
        label.setText("list 1");
        label.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        label.setFont(new Font("System Bold", 13.0));

        borderPane.setLayoutX(20.0);
        borderPane.setLayoutY(26.0);
        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(34.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        anchorPane0.setLayoutX(7.0);
        anchorPane0.setPrefHeight(167.0);
        anchorPane0.setPrefWidth(26.0);
        anchorPane0.setStyle("-fx-background-color: #3b8ef4; -fx-background-radius: 5;");

        //glow.setLevel(0.85);
       // anchorPane0.setEffect(glow);

        label0.setLayoutX(3.0);
        label0.setLayoutY(-32.0);
        label0.setPrefHeight(19.0);
        label0.setPrefWidth(39.0);
        label0.setText("100%");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#6991dd"));
        label0.setFont(new Font("System Bold", 13.0));
        borderPane.setBottom(anchorPane);

        getChildren().add(label);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(label0);
        getChildren().add(borderPane);
        setBarname("7amada");
        int x=20;
        String s=x+"%";
        setBarpercent(s);
        
    }
    void setBarname(String s)
      {
        label.setText(s);
      }
    
    void setBarpercent(String s )
      { label0.setText(s);
      }
    
    void setBarheight(int i)
      {
        anchorPane.setPrefHeight(i);
      }
    
}

    
    
    
}
