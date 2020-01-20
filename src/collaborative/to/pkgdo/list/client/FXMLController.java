/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;


import Controllers.AuthenticationController;
import Controllers.ItemController;
import Handlers.ItemCreationHandler;
import Controllers.ToDoListController;
import Entities.ItemEntity;
import Controllers.CollaboratorController;
import Controllers.CommentController;
import Controllers.FriendController;
import Controllers.TaskController;
import Controllers.SocketController;
import Controllers.ToDoListController;
import Entities.Accept_RecjectTaskEntity;
import Entities.CollaborationRequestEntity;
import Entities.CommentEntity;
import Entities.ItemEntity;
import Entities.NotificationEntity;
import Entities.RequestEntity;
import Entities.ToDoEntity;
import Entities.UserEntity;
import Handlers.AcceptCollaboratorRequestHandler;
import Entities.TaskEntity;
import Entities.ToDoEntity;
import Entities.UserEntity;
import Handlers.AcceptFriendHandler;
import Handlers.AddFriendHandler;
import Handlers.CommentCreationHandler;
import Handlers.CollaboratorRequestHandler;
import Handlers.FriendStatusHandler;
import Handlers.ItemDeletionHandler;
import Handlers.ItemUpdateHandler;
import Handlers.NotificationHandler;
import Handlers.SearchFriendHandler;
import Handlers.TaskCreationHandler;
import Handlers.TaskDeleteHandler;
import Handlers.ToDoCreationHandler;
import Handlers.ToDoDeleteHandler;
import Handlers.ToDoUpdateHandler;
import Handlers.TaskUpdateStatusHandler;
import Utils.CurrentUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author Abd-Elmalek
 */
public class FXMLController implements Initializable {

    UserEntity currentUser;
    UserEntity searchingEntityResult;
    Listicon currentlyViewedTodoList;
    ItemController itemController = new ItemController();
    TaskController taskController = new TaskController();
    CommentController commentController = new CommentController();
    ArrayList<Integer> itemsIndecies;
    int itemsCounter = 0;
   public static StatisticsHandler statistics;
    public static ToDoEntity currentToDo = null ;
    public static ItemEntity currentItem =null;
    public static TaskEntity currentTask;
   // Friendicon Fitem=new Friendicon();
   // Friendicon Fitem2=new Friendicon();
    double xOffset = 0;
    double yOffset = 0;
    
    
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
    //Notification notif=new Notification();
    //Friendtoadd fc=new Friendtoadd();
    //Friendtoadd fc2=new Friendtoadd();
//    TodoStatstics bar1 = new TodoStatstics();
  //  TodoStatstics bar2 = new TodoStatstics();
    //TodoStatstics bar3 = new TodoStatstics();

    @FXML

    public JFXButton MINIMIZE;
    public JFXButton EXIT;
    public VBox FRIENDSLIST;
    @FXML
    public VBox LIST;
    public VBox aSSIGNEDTOTASK;
    @FXML
   
    public VBox COLLABORATORS;
    public VBox NOTIFICATIONS;
    public VBox aDDRIENDCOLABLIST;
    public VBox TASKLISTS11;
    public VBox TASKLISTS1;
    public VBox Taskreq;
    
    
    
    public  HBox STATISTICS;
    public  VBox lISTSTATUS;
    @FXML
    AnchorPane iTEMCOMMENTs1;
    @FXML
    AnchorPane tASKINFO;
    @FXML
    Label iTEMNAME;
    @FXML
    VBox cOMMENTS;
    @FXML
    JFXTextField ADDTASK1;
    //public HBox sSTATISTICS;
    public  HBox sTATISTICS;
    //public static VBox lISTSTATUS;
    @FXML
    public Accordion TASKLISTS;
    public ScrollPane FRIENDSSCROLL;
    public ScrollPane LISTSCROLL;
    
    public ScrollPane nOTIFISCROLL;
    public ScrollPane COLLABSCROLL;
    @FXML
    public ImageView testButton;
    public JFXTextField ADDTASK;
    public JFXButton FRIENDS;
    public JFXButton LISTS;
    public JFXButton nEWLIST;
    public JFXButton ADDDATE;
    public JFXButton ADDDATE1;
    public JFXButton DATEPICK;
    public JFXButton lOGOUT; 
    public JFXButton NEWCOLLABORATOR;
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
    public AnchorPane eDITLISTAP;
    public AnchorPane Itemstatuspane;
    public AnchorPane cONNECTIONLOST;
    
    public JFXButton REQUESTS;
    public JFXButton TODAY;
    public JFXButton STATUS;

    public Line linelists;
    public Line linefriends;

    public JFXButton SHOWNOTIFICATIONS;
    public JFXButton CLEARDATE;
    public JFXButton SAVEDATE;
    public JFXButton aDDCOLAB;
    public JFXButton DONEADDCOLLABORATOR;
    public JFXButton CANCELLIST;
    public JFXButton CANCELLIST1;
    public JFXButton eDITLIST;
    
    public JFXButton rETRYCONNECTION;
    //public JFXButton aDDCOLAB;
    public JFXDatePicker STARTDATE;
    public JFXDatePicker ENDDATE;

    public JFXTextField NEWTODOTITLE;
    public JFXTextField NEWTODOTITLE1;

    public Label USERNAME;
    public Label TITLE;
    public Label finished;
    public Label pending;
    public Circle TODOCOLOR;

    public ImageView ADDCOLLAB;
    public PieChart piechart;

    public Circle TODOEDITCOLOR;
    public ImageView ADDCOLLAB1;
    public ImageView MENU;
    
    /* ahmedpro */
    @FXML
    public JFXButton nEWFRIEND;
    public AnchorPane addFriendPane;
    public JFXButton doneAddFriendPane;
    public JFXTextField textFieldAddFriend;
    public AnchorPane addFriendResult;
    public Label friendName;
    public JFXButton addFriendButton;
    public Label addFriendFailedLabel;
    public Label sTARTDATE;
    public Label eNDDATE;


//
//    public void disableUIForNotification(){
//
//        MINIMIZE.setDisable(true);
//        EXIT.setDisable(true);
//        FRIENDSLIST.setDisable(true);
//        LISTSCROLL.setDisable(true);
//        COLLABSCROLL.setDisable(true);
//        FRIENDS.setDisable(true);
//        LISTS.setDisable(true);
//        nEWLIST.setDisable(true);
//        ADDDATE.setDisable(true);
//        DATEPICK.setDisable(true);
//        TODOPANE.setDisable(true);
//        LISTPANE.setDisable(true);
//        FRIENDPANE.setDisable(true);
//        TODAYPANE.setDisable(true);
//        STATUSPANE.setDisable(true);
//        REQUESTPANE.setDisable(true);
//        DATEPANE.setDisable(true);
//        ADDLISTPANE.setDisable(true);
//        REQUESTS.setDisable(true);
//        TODAY.setDisable(true);
//        STATUS.setDisable(true);
//
//        NEWCOLLABORATOR.setDisable(true);
//        ADDCOLLABORATORPANE.setDisable(true);
//    }
//     
    @FXML
    public void nav3(MouseEvent event) {


        if (event.getSource() == aDDCOLAB ) {
            
             ADDCOLLABORATORPANE.setVisible(true);
        }
    }
    
    @FXML
    public void nav(MouseEvent event) {

        if (event.getSource() == LISTS) {

            FRIENDPANE.setVisible(false);
            LISTPANE.setVisible(true);
            linelists.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
            linefriends.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
        } else if (event.getSource() == FRIENDS) {

            FRIENDPANE.setVisible(true);
            LISTPANE.setVisible(false);
            linelists.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
            linefriends.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
        } else if (event.getSource() == REQUESTS) {

            TODOPANE.setVisible(false);
            STATUSPANE.setVisible(false);
            REQUESTPANE.setVisible(true);
            TODAYPANE.setVisible(false);
        } else if (event.getSource() == TODAY) {

            TODOPANE.setVisible(false);
            STATUSPANE.setVisible(false);
            REQUESTPANE.setVisible(false);
            TODAYPANE.setVisible(true);
        } else if (event.getSource() == STATUS) {
            
             statistics=new StatisticsHandler(currentUser);
             STATISTICS.getChildren().clear();
            for(TodoStatstics graph:statistics.setListsStatistics( CurrentUser.getCurrentUser().getTodoList()))
            { 
              STATISTICS.getChildren().add(graph);
            
            }
            TODOPANE.setVisible(false);
            STATUSPANE.setVisible(true);
            REQUESTPANE.setVisible(false);
            TODAYPANE.setVisible(false);
        }
    }
   /*omnia*/
    public void manageUI(boolean disable){
        
        SHOWNOTIFICATIONS.setMouseTransparent(disable);
        lOGOUT.setMouseTransparent(disable);
        
        REQUESTS.setMouseTransparent(disable);
        TODAY.setMouseTransparent(disable);
        STATUS.setMouseTransparent(disable);
        
        LISTS.setMouseTransparent(disable);
        FRIENDS.setMouseTransparent(disable);
        
        LIST.setMouseTransparent(disable);
        
        ADDTASK.setMouseTransparent(disable);
        
        // ALL ABOVE CAN BE PROFILEPANE.setNouseTransparent(disable);
        
        TODOPANE.setMouseTransparent(disable);
        TODAYPANE.setMouseTransparent(disable);
        STATUSPANE.setMouseTransparent(disable);
        REQUESTPANE.setMouseTransparent(disable);
        NOTIFIPANE.setMouseTransparent(disable);
        
    }
    
    @FXML
    public void nav1(MouseEvent event) {

        if (event.getSource() == nEWLIST) {
            //REQUESTS.setMouseTransparent(true);
            manageUI(true);
            ADDLISTPANE.setVisible(true);
          }
        else if(event.getSource() == eDITLIST){
            NEWTODOTITLE1.setText(currentlyViewedTodoList.getTodo().getTitle());
                        
            STARTDATE.setValue(LocalDateTime.ofInstant(Instant.ofEpochMilli(currentlyViewedTodoList.getTodo().getAssignDate().getTime()), ZoneId.systemDefault()).toLocalDate());
            ENDDATE.setValue(LocalDateTime.ofInstant(Instant.ofEpochMilli(currentlyViewedTodoList.getTodo().getDeadLineDate().getTime()), ZoneId.systemDefault()).toLocalDate());
            
            eDITLISTAP.setVisible(true);
        }
        else if(event.getSource()==CLEARDATE){
             STARTDATE.setValue(null);
             ENDDATE.setValue(null);
          

        } else if (event.getSource() == CLEARDATE) {
            STARTDATE.setValue(null);
            ENDDATE.setValue(null);
        } else if (event.getSource() == SAVEDATE) {
            DATEPANE.setVisible(false);
        } else if (event.getSource() == nEWFRIEND) {
            addFriendPane.setVisible(true);

        } else if (event.getSource() == doneAddFriendPane) {
            addFriendFailedLabel.setVisible(false);
            addFriendResult.setVisible(false);
            addFriendPane.setVisible(false);
        } else if (event.getSource() == addFriendButton) {
            FriendController.addFreind(
                    currentUser.getId(), 
                    searchingEntityResult.getId(), 
                    currentUser.getUserName());
        }
        
        else if (event.getSource() == SHOWNOTIFICATIONS) {

            if (NOTIFIPANE.isVisible()) {
                NOTIFIPANE.setVisible(false);

            } else {
                NOTIFIPANE.setVisible(true);
            }

        } 
        else if (event.getSource() == aDDCOLAB) {
            ADDCOLLABORATORPANE.setVisible(true);
        }
        else if (event.getSource() == DONEADDCOLLABORATOR) {
            ADDCOLLABORATORPANE.setVisible(false);
        } else if(event.getSource() == CANCELLIST || event.getSource() == CANCELLIST1){
             if(TODOCOLOR != null)
                 TODOCOLOR.setStroke(Color.TRANSPARENT);
             TODOCOLOR = null;
             STARTDATE.setValue(null);
             ENDDATE.setValue(null);
             NEWTODOTITLE.setText("");
             ADDLISTPANE.setVisible(false);
             eDITLISTAP.setVisible(false);
             manageUI(false);
         } else if(event.getSource() == ADDDATE || event.getSource() == ADDDATE1){
             
             DATEPANE.setVisible(true);
         }

    }
    
    @FXML
    public void nav4(ActionEvent event) {
        if (event.getSource() == textFieldAddFriend) {
            String userName = textFieldAddFriend.getText();
            if (userName.equals(currentUser.getUserName())) {

                addFriendFailedLabel.setVisible(true);
                addFriendFailedLabel.setText("it's your user name");
            } else if (hasUserName(userName)) {
                addFriendFailedLabel.setVisible(true);
                addFriendFailedLabel.setText("you have a friend with that user name");
            } else {
                FriendController.searchFriend(userName);
            }
        }
    }

        @FXML
     public void logOut(MouseEvent event) {
         AuthenticationController authenticationController = new AuthenticationController();
         authenticationController.logout(currentUser);

         
         SocketController.getInstance().disconnect();
            Platform.runLater(()->{
        try {
            System.out.println("loading main page ....");
           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument_1.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = (Stage) MINIMIZE.getScene().getWindow();
            
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
        
      @FXML
     public void exit(MouseEvent event) {
        AuthenticationController authenticationController = new AuthenticationController();
        authenticationController.logout(currentUser);
        
          SocketController.getInstance().disconnect();
            Platform.exit();
    }  
      @FXML
     public void retryConnection(MouseEvent event) {
         AuthenticationController  authenticationController = new AuthenticationController();
                 
        if(SocketController.reConnect())
        {
         String username = CurrentUser.getCurrentUser().getUserName();
         String password = CurrentUser.getCurrentUser().getPassword();
         
         authenticationController.logIn(username, password);
         cONNECTIONLOST.setVisible(false);
         }
        
    }

    public  void conFaild(Integer i) {
       cONNECTIONLOST.setVisible(true);
        
    }
    
    /*omnia*/
    
    public  void actions() {

        TODOPANE.setVisible(true);
        STATUSPANE.setVisible(false);
        REQUESTPANE.setVisible(false);
        TODAYPANE.setVisible(false);
    }

     public void updatePieChart(int finishedp,int pendingp)
     {   int percentp=0,percentf=0;
         Itemstatuspane.setVisible(true); 
         piechart.setStartAngle(180);  
         if(finishedp>0)
         {percentf=((finishedp / (finishedp + pendingp) )* 100);}
          if(pendingp>0)
         {percentp=((pendingp / (finishedp + pendingp) )* 100);}
        
         
          ObservableList<PieChart.Data> pieChartData =
           FXCollections.observableArrayList(
                         new PieChart.Data("Done ",finishedp),
                         new PieChart.Data("Pending", pendingp));

          piechart.setData(pieChartData);
       
          finished.setText(new Integer(finishedp).toString());
          pending.setText(new Integer(pendingp).toString());
     }  
     
     
      public void clearVbox(Object o){
      lISTSTATUS.getChildren().clear();
    } 
    public void update(MItemState state){
        
        lISTSTATUS.getChildren().add(state);
    }
    
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*eman*/
        NotificationHandler.setNotificationGUIGenerator(this::createNotificationResponse);
        CollaboratorRequestHandler.setCollaborationRequestGUIGenerator(this::createCollaboratorRequestResponse);
        /*eman*/
        /*REHAM*/
        TodoStatstics.setItemstateGUIClear(this::clearVbox);
        TodoStatstics.setItemstateGUIGenerator(this::update);
        MItemState.setpiechartGUIGenerator(this::updatePieChart);
        ToDoCreationHandler.setTodoGUIGenerator(this::createTodoListResponse);
        ToDoUpdateHandler.setTodoGUIModifier(this::updateTodoListResponse);
        ToDoDeleteHandler.setTodoGUIModifier(this::deleteTodoListResponse);
        FriendStatusHandler.setFriendStatusGUIModifier(this::updateFriendStatus);
         TaskCreationHandler.setTodoGUIGenerator(this::createTaskResponse);
        ItemCreationHandler.setTodoGUIGenerator(this:: createItemResponse);
        CommentCreationHandler.setCommentGUIGenerator(this::commentCreationResponse);

       
//        sSTATISTICS.getChildren().add(bar1);
  //      sSTATISTICS.getChildren().add(bar2);
    //    sSTATISTICS.getChildren().add(bar3);
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
              //Item i = new Item(itemEntity);
             //TASKLISTS.getPanes().add(i);
             try{
              //CurrentUser.getCurrentUser().getTodoList().get(CurrentUser.getCurrentUser().getTodoList().indexOf(currentToDo)).getItemsList().add(itemEntity);
             }catch(Exception e){
                 e.printStackTrace();
             }
              itemController.createItem(itemEntity);
              ADDTASK.clear();
          }
      });
           // testButton.setOnMousePressed((MouseEvent event) -> {
            //    itemController.deleteItem(currentToDo.getItemsList().get(0));
             //   TASKLISTS.getPanes().remove(0);
            //});
        
      /*abd-elamlek*/
      
     
      MINIMIZE.setOnMousePressed((MouseEvent event) -> {
           CollaborativeToDoListClient.mPrimaryStage.setIconified(true);
      });

      
      //COLLABORATORS.getChildren().add(col);
      //aDDRIENDCOLABLIST.getChildren().add(fc);
      //aDDRIENDCOLABLIST.getChildren().add(fc2);
      

   //   NOTIFICATIONS.getChildren().add(notif);
      

        /*omnia*/
        SocketController.setConnectionFailed(this::conFaild);
        
        
        /*omnia*/
 
//      TASKLISTS.getPanes().add(task);

 //     TASKLISTS.getPanes().add(task2);
      FRIENDPANE.setVisible(false);
      LISTPANE.setVisible(true);
      linelists.setStroke(javafx.scene.paint.Color.valueOf("#000000"));
      linefriends.setStroke(javafx.scene.paint.Color.valueOf("#d7d0d0"));
      /*omnia*/
       SHOWNOTIFICATIONS.focusedProperty().addListener(new ChangeListener<Boolean>()

       {
          @Override
         public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
             if ((!newPropertyValue&&!(nOTIFISCROLL.isFocused())&&!(NOTIFIPANE.isFocused())&&!(NOTIFICATIONS.isFocused())))
                {
                NOTIFIPANE.setVisible(false);
                
              }
        
            }
        }); 
         nOTIFISCROLL.focusedProperty().addListener(new ChangeListener<Boolean>()
         {
          @Override
         public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
             if ((!newPropertyValue&&!(NOTIFICATIONS.isFocused())))
                {
                NOTIFIPANE.setVisible(false);
              }
        
            }

        }); 
         
                 /* ahmedpro */
        SearchFriendHandler.setSearchingResultGUI(this::updateSearchingResultGUI);
        AddFriendHandler.setAddFriendGUI(this::updateAddFriendGUI);
        AcceptFriendHandler.setConsumer(this::updateAcceptFriendGUI);
        /* ahmedpro */
        
          /*omnia*/
       
        initiateCurrentUser();
        
        ADDTASK1.setOnKeyPressed((KeyEvent event) -> {
                if(event.getCode()== KeyCode.ENTER){
                    
                    commentController.addComment(ADDTASK1.getText(), new java.sql.Date(System.currentTimeMillis()), currentTask.getId(), currentItem.getId(), currentToDo.getId(), currentUser.getId(), currentUser.getUserName());
                    ADDTASK1.clear();
                }
            });

    }

    private void setItemList() {

        for (ToDoEntity toDoEntity : CurrentUser.getCurrentUser().getTodoList()) {
            for (ItemEntity itemEntity : toDoEntity.getItemsList()) {

            }
        }
    }

    class Comment extends AnchorPane {

        protected final Label label;

        public Comment(CommentEntity commentEntity) {

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
            label.setText(commentEntity.getUserName()+": "+commentEntity.getMessageContent());
            label.setFont(new Font("Calibri Light", 12.0));

            getChildren().add(label);
            
            /*
            ADDTASK11.setOnKeyPressed((KeyEvent event) -> {
                if(event.getCode()== KeyCode.ENTER){
                    
                    commentController.addComment(ADDTASK11.getText(), new java.sql.Date(System.currentTimeMillis()), currentTask.getId(), currentItem.getId(), currentToDo.getId(), currentUser.getId(), currentUser.getUserName());
                }
            });
            */

        }
    }

    class Notification extends AnchorPane {

        private NotificationEntity ne;
        protected final JFXTextArea jFXTextArea;

        // public Notification()
        public Notification(NotificationEntity ne) {
            this.ne = ne;

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
            jFXTextArea.setPromptText(ne.getMsg());
            jFXTextArea.setEditable(false);
            jFXTextArea.setPrefHeight(43.0);
            jFXTextArea.setPrefWidth(311.0);
            jFXTextArea.unFocusColorProperty().set(javafx.scene.paint.Color.valueOf("#c2bdbd"));
            getChildren().add(jFXTextArea);

        }

    }

    public void createNotificationResponse(NotificationEntity ne) {
        Platform.runLater(() -> {
            System.out.println("hererrrrrrr");
            NOTIFICATIONS.getChildren().add(new Notification(ne));
        });
    }
    
    public void createCollaboratorRequestResponse(CollaborationRequestEntity cre) {
        Platform.runLater(() -> {
            TASKLISTS1.getChildren().add(new CollaborationRequest(cre));
        });
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
            aDDCOLL.setOnMouseClicked((MouseEvent event) -> {
                int collaboratorId=friend.getId();
                int senderId=CurrentUser.getCurrentUser().getId();
                int todoId=currentlyViewedTodoList.getTodo().getId();
                CollaboratorController c=new CollaboratorController();
                c.addCollaboratorRequest(collaboratorId,senderId, todoId);
                aDDCOLL.setDisable(true);
                currentlyViewedTodoList.updateFriendsToAddAsCollaborators(this);
            });
            aDDCOLL.setPrefWidth(4.0);
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

    class Collaborator extends AnchorPane {

        protected Circle circle;
        protected DropShadow dropShadow;
        protected ImageView imageView;
        protected Circle circle0;
        protected Label collaboratorName;

        private UserEntity collaborator;

        public Collaborator(UserEntity collaborator) {

            this.collaborator = collaborator;

            circle = new Circle();
            dropShadow = new DropShadow();
            imageView = new ImageView();
            //circle0 = new Circle();
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

            /*circle0.setFill(javafx.scene.paint.Color.valueOf("#7cebbd"));
            circle0.setLayoutX(27.0);
            circle0.setLayoutY(30.0);
            circle0.setRadius(5.0);
            circle0.setStroke(javafx.scene.paint.Color.valueOf("#0000007c"));
            circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);*/

            collaboratorName.setLayoutX(46.0);
            collaboratorName.setLayoutY(11.0);
            collaboratorName.setPrefHeight(17.0);
            collaboratorName.setPrefWidth(82.0);
            collaboratorName.setText(collaborator.getUserName());
            collaboratorName.setTextFill(javafx.scene.paint.Color.valueOf("#838080"));
            collaboratorName.setFont(new Font("Calibri", 12.0));

            getChildren().add(circle);
            getChildren().add(imageView);
            //getChildren().add(circle0);
            getChildren().add(collaboratorName);

        }

        public void setFriendName(String s) {
            collaboratorName.setText(s);
        }

        public void onlinestatus(Boolean b) {
            // Friendname.setText(b);
        }

    }

    class Friendicon extends AnchorPane {

        protected Circle circle;
        protected DropShadow dropShadow;
        protected ImageView imageView;
        protected Circle circle0;
        protected Label Friendname;
        private UserEntity friend;
        protected final ContextMenu menu = new ContextMenu();
        protected MenuItem delete = new MenuItem("Delete");

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

            if(friend.getUserStatus() == 1)
            circle0.setFill(javafx.scene.paint.Color.valueOf("#7cebbd"));
            else
                circle0.setFill(javafx.scene.paint.Color.RED);
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

        public void setFriendName(String s) {
            Friendname.setText(s);
        }

        public void onlinestatus(Boolean b) {
            // Friendname.setText(b);
        }
        
        public UserEntity getFriend(){
         return friend;
        }
        public void updateFriendStatus(int status){
            if(status == 1)
               circle0.setFill(javafx.scene.paint.Color.valueOf("#7cebbd"));
           else
               circle0.setFill(javafx.scene.paint.Color.RED);
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
            ToDoListController todoListController = new ToDoListController();
            todoListController.deleteToDoList(todo);
            LIST.getChildren().remove(this);
          });
        delete.setDisable(!isOwnedByCurrentUser);
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
    public void viewTodo(){
        
        iTEMCOMMENTs1.setVisible(false);
        tASKINFO.setVisible(false);
        iTEMNAME.setVisible(false);
        aSSIGNEDTOTASK.setVisible(false); 
        /*Reham*/
        TITLE.setText(todo.getTitle());
                if(COLLABORATORS == null)
                    System.err.println("first null");
                if(TODOCOLLABORATORS == null)
                    System.err.println("second null");
        if(todo.getColor() != null)
            TITLE.setTextFill(Color.web(todo.getColor()));
        
        sTARTDATE.setText(todo.getAssignDate().getDate() + "/" + todo.getAssignDate().getMonth()+1 + "/" + (todo.getAssignDate().getYear()+1900));
        eNDDATE.setText(todo.getDeadLineDate().getDate() + "/" + todo.getDeadLineDate().getMonth()+1 + "/" + (todo.getDeadLineDate().getYear()+1900));
        
        COLLABORATORS.getChildren().setAll(TODOCOLLABORATORS);
        aDDRIENDCOLABLIST.getChildren().setAll(FRIENDSTOADDASCOLLABORATORS);

        aDDCOLAB.setVisible(isOwnedByCurrentUser);
        ADDCOLLAB1.setVisible(isOwnedByCurrentUser);
        
        eDITLIST.setVisible(isOwnedByCurrentUser);
        MENU.setVisible(isOwnedByCurrentUser);
        
        currentlyViewedTodoList = Listicon.this;
        /*Reham*/
        
        /*Abd El Malek*/
        currentToDo = todo;
        TASKLISTS.getPanes().clear();
        System.out.println("to do sisze is "+todo.getItemsList().size());
        if(todo.getItemsList()!=null){
                for(ItemEntity itemEntity : todo.getItemsList()){
                        Item item = new Item(itemEntity);
                         TASKLISTS.getPanes().add(item);                    
                
                }
            }
        
        /*Abd El Malek*/    
    }
    public void updateFriendsToAddAsCollaborators(Friendtoadd friend){
        FRIENDSTOADDASCOLLABORATORS.getChildren().remove(friend);
    }

        public void addItem(ItemEntity itemEntity) {
            todo.getItemsList().add(itemEntity);
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
    public ItemEntity mItemEntity;
    
    protected final ContextMenu menu = new ContextMenu();
    protected MenuItem delete = new MenuItem("Delete");
    
    
    public int itemId;
    public Item(ItemEntity itemEntity) {
        
         delete.setOnAction((event) -> {
             if(currentToDo.getOwnerId() == currentUser.getId()){
                deleteItem(itemEntity);
                itemController.deleteItem(itemEntity);
                }
            });

        menu.getItems().addAll(delete);
        itemId = itemEntity.getId();
        
        mItemEntity = itemEntity;
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
        label.setText(itemEntity.getTitle());
        label.setFont(new Font(15.0));

        line.setEndX(-121.0);
        line.setEndY(26.0);
        line.setLayoutX(122.0);
        line.setLayoutY(12.0);
        line.setStartX(-121.0);
        line.setStartY(-22.0);
        if(currentlyViewedTodoList.getTodo().getColor() != null)
            line.setStroke(javafx.scene.paint.Color.valueOf(currentlyViewedTodoList.getTodo().getColor()));
        else
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

       // anchorPane.getChildren().add(jFXCheckBox);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(line);
        anchorPane.getChildren().add(line0);
        
        anchorPane0.getChildren().add(vBox);
        
        
        label.setOnMousePressed((MouseEvent event) -> {
        
            
        });
        label.setContextMenu(menu);
        //TaskEntity taskEntity = new TaskEntity();
        //taskEntity.setDecription("desc");
        //addTask(taskEntity);
        
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            currentItem = mItemEntity;
                vBox.getChildren().clear();
                vBox.getChildren().add(bar);
                ArrayList<TaskEntity> taskList = mItemEntity.getTasksList();
                         if(taskList!=null){
                             for(TaskEntity taskEntity : taskList){
                            if(taskEntity!=null){
                                 Task task = new Task(taskEntity);
                                 vBox.getChildren().add(task);
                            }
                         }
                         }
            if(TASKLISTS.getHeight()>((TASKLISTS.getChildrenUnmodifiable().size()*40)+259))
             { 
               TASKLISTS.setPrefHeight((TASKLISTS.getChildrenUnmodifiable().size()*40.0)+259.0);
             setPrefHeight(259.0);
             }
            
            }
        });
        label.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                iTEMCOMMENTs1.setVisible(false);
                tASKINFO.setVisible(false);
                iTEMNAME.setVisible(false);
                aSSIGNEDTOTASK.setVisible(false);
                        }
        });
        
       
        
        /*
        label.setOnMousePressed((MouseEvent event) -> {
            //deleteItem(itemEntity);
            if(currentToDo.getOwnerId() == currentUser.getId()){
            currentToDo.getItemsList().remove(itemEntity);
            itemController.deleteItem(itemEntity);
            }
            
        });
        */
        
        ItemUpdateHandler.setTodoGUIGenerator(this::updateItemResponse);
        ItemDeletionHandler.setTodoGUIGenerator(this::deleteItemResponse);
        TaskUpdateStatusHandler.setTodoGUIGenerator(this::updateTaskResponse);
        TaskDeleteHandler.setTodoGUIGenerator(this::deleteTaskResponse);
    }
         public void updateTaskResponse(TaskEntity task){
            Platform.runLater(() ->  {
                updateTAsk(task);
             //  TaskEntity entity = currentItem.getTasksList().get(currentItem.getTasksList().indexOf(task));
              // entity.setStatus(task.getStatus());
            //  currentTask.setStatus(task.getStatus());
            });
    }
    
         
    public void updateTAsk(TaskEntity taskEntity){
         for(int i=0; i< TASKLISTS.getPanes().size();i++){
          Item i1 = (Item) TASKLISTS.getPanes().get(i);
          if(taskEntity.getItemId() == i1.itemId){
              for(int j =1; j< i1.vBox.getChildren().size(); j++){
                  Task task = (Task) i1.vBox.getChildren().get(j);
                  if(task.taskId == taskEntity.getId()){
                      if (taskEntity.getStatus() == 1) {
                            task.jFXCheckBox.setSelected(true);
                        }else{
                            task.jFXCheckBox.setSelected(false);
                        }
                  }
              }
              break;
          }
       }         
    }
    
     public void deleteTaskResponse(TaskEntity task){
            Platform.runLater(() ->  {
                deleteTAsk(task);
                //currentUser.getTodoList().get(currentUser.getTodoList().indexOf(currentToDo)).getItemsList().get(currentToDo.getItemsList().indexOf(currentItem)).getTasksList().remove(task);
                //currentItem.getTasksList().remove(task);
                //mItemEntity.getTasksList().remove(task);
            });
    }
        public void deleteTAsk(TaskEntity taskEntity){
         for(int i=0; i< TASKLISTS.getPanes().size();i++){
          Item i1 = (Item) TASKLISTS.getPanes().get(i);
          if(taskEntity.getItemId() == i1.itemId){
              for(int j =1; j< i1.vBox.getChildren().size(); j++){
                  Task task = (Task) i1.vBox.getChildren().get(j);
                  if(task.taskId == taskEntity.getId()){
                      i1.vBox.getChildren().remove(task);
                      try{
                          List<TaskEntity> taskArrayList =Collections.synchronizedList(i1.mItemEntity.getTasksList());
                          for(TaskEntity te : taskArrayList){
                          if(te.getId() == taskEntity.getId()){
                              i1.mItemEntity.getTasksList().remove(te);
                          }
                      }
                      }catch(ConcurrentModificationException e){//e.printStackTrace();
                      }
                      break;
                  }
              }
             
          }
       }         
    }
 
   private void deleteItem(ItemEntity itemEntity) {
            TASKLISTS.getPanes().remove(this);
        }
   
   private void deleteItemResponse(ItemEntity itemEntity) {

            for (int i = 0; i < TASKLISTS.getPanes().size(); i++) {
                Item i1 = (Item) TASKLISTS.getPanes().get(i);
                if (itemEntity.getId() == i1.itemId) {
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

        protected JFXCheckBox jFXCheckBox;
        protected Line line;
        protected Line line0;
        protected Label label;
        public int taskId;
        protected final ContextMenu menu = new ContextMenu();
        protected MenuItem delete = new MenuItem("Delete");
        
        public Task(TaskEntity taskjEntity) {
            delete.setOnAction((event) -> {
                taskController.deleteTask(taskjEntity);
            });
            taskId = taskjEntity.getId();
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
            if(currentlyViewedTodoList.getTodo().getColor() != null)
                line.setStroke(javafx.scene.paint.Color.valueOf(currentlyViewedTodoList.getTodo().getColor()));
            else
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
            if (taskjEntity.getStatus() == 1) {
                jFXCheckBox.setSelected(true);
            }
            
            if(taskjEntity.getStatus() == 1){
            jFXCheckBox.setSelected(true);
        }else{
            jFXCheckBox.setSelected(false);
        }
        
      
            label.setOnMousePressed((MouseEvent event) -> {
             iTEMCOMMENTs1.setVisible(true);
             tASKINFO.setVisible(true);
             iTEMNAME.setVisible(true);
             aSSIGNEDTOTASK.setVisible(true);
             iTEMNAME.setText(taskjEntity.getDecription());
                System.out.println("pressed");
                currentTask = taskjEntity;
                cOMMENTS.getChildren().clear();
                
                List<CommentEntity> commentLis = Collections.synchronizedList(currentTask.getCommentsList());
                if(commentLis!=null){
                    
                    for(CommentEntity commentEntity : commentLis){
                        Comment comment = new Comment(commentEntity);
                        cOMMENTS.getChildren().add(comment);
                    }
                }
                if(currentTask.getAssignedUsersList() != null){
                    for(UserEntity user : currentTask.getAssignedUsersList()){
                        Collaborator assignedToTaskCollab = new Collaborator(user);
                        aSSIGNEDTOTASK.getChildren().add(assignedToTaskCollab);
                    }
                }
                
                 
            });
            
        jFXCheckBox.selectedProperty().addListener(new  ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                int status = 0;   
                if(newValue){
                        status =1;
                   }
        taskController.updateTaskStatus(taskjEntity, status);
            }
        });
        
        
        
        this.setOnMousePressed((MouseEvent event) -> {
            currentTask = taskjEntity;
        });
        }
        
        public void setTaskname(String s) {
            label.setText(s);
        }
          
        
}
    

       

    

    /*REHAM*/


    public class FriendRequest extends AnchorPane {

        protected final ImageView imageView;
        protected final JFXButton jFXButton;
        protected final JFXButton jFXButton0;
        protected final Label label;
        private RequestEntity friendRequest;

        public FriendRequest(RequestEntity friendRequest) {

            this.friendRequest = friendRequest;
            
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
            jFXButton.addEventHandler(ActionEvent.ACTION, (action) -> {
                TASKLISTS11.getChildren().remove(this);
                FriendController.acceptFriendReauest(
                        friendRequest.getReceivedUserId(),
                        friendRequest.getSentUserId(),
                        currentUser.getUserName());
            });

            jFXButton0.setLayoutX(317.0);
            jFXButton0.setLayoutY(10.0);
            jFXButton0.setPrefWidth(79);
            jFXButton0.setPrefHeight(25);
            jFXButton0.setText("Reject");
            jFXButton0.setStyle("-fx-background-color:  #f0f1f5;");
            jFXButton0.addEventHandler(EventType.ROOT, (action) -> {
                TASKLISTS11.getChildren().remove(this);
                FriendController.acceptFriendReauest(
                        friendRequest.getReceivedUserId(),
                        friendRequest.getSentUserId(),
                        currentUser.getUserName());
            });

            label.setLayoutX(54.0);
            label.setLayoutY(17.0);
            label.setText(friendRequest.getMessage());
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

        private CollaborationRequestEntity collaborationRequest;
        public CollaborationRequest(CollaborationRequestEntity collaborationRequest) {

            this.collaborationRequest = collaborationRequest;
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
       
        
        

            jFXButton.setLayoutX(145.0);
            jFXButton.setLayoutY(10.0);
            jFXButton.setPrefWidth(67);
            jFXButton.setPrefHeight(25);
            jFXButton.setText("Accept");
            jFXButton.setStyle("-fx-background-color: #3b8ef4;");
            jFXButton.setTextFill(Color.web("#fffbfb"));
            
            jFXButton.setOnAction((event)->{
                
                    System.out.println("from handle accept");
                    CollaboratorController collaboratorController = new CollaboratorController();
                    collaboratorController.acceptCollaboratorRequest(this.collaborationRequest);
                    TASKLISTS1.getChildren().remove(this);
                
            });

            jFXButton0.setLayoutX(225.0);
            jFXButton0.setLayoutY(10.0);
            jFXButton0.setPrefWidth(67);
            jFXButton0.setPrefHeight(25);
            jFXButton0.setText("Reject");
            jFXButton0.setStyle("-fx-background-color:  #f0f1f5;");
            
            jFXButton0.setOnAction((event)->{
                
                    CollaboratorController collaboratorController = new CollaboratorController();
                    collaboratorController.rejectCollaboratorRequest(this.collaborationRequest);
                    TASKLISTS1.getChildren().remove(this);
                
            });
            
            label.setLayoutX(54.0);
            label.setLayoutY(17.0);
            label.setText(collaborationRequest.getMessage());
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

        private Accept_RecjectTaskEntity taskAssignmentRequest;
        public TaskAssignmentRequest(Accept_RecjectTaskEntity taskAssignmentRequest) {

            this.taskAssignmentRequest = taskAssignmentRequest;
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
       
        
        

            jFXButton.setLayoutX(145.0);
            jFXButton.setLayoutY(10.0);
            jFXButton.setPrefWidth(67);
            jFXButton.setPrefHeight(25);
            jFXButton.setText("Accept");
            jFXButton.setStyle("-fx-background-color: #3b8ef4;");
            jFXButton.setTextFill(Color.web("#fffbfb"));

            jFXButton0.setLayoutX(225.0);
            jFXButton0.setLayoutY(10.0);
            jFXButton0.setPrefWidth(67);
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
        
        if(currentUser.getFriendRequestList() != null)
            for(RequestEntity re : currentUser.getFriendRequestList()){
                FriendRequest friendRequest = new FriendRequest(re);
                TASKLISTS11.getChildren().add(friendRequest);
            }

        if(currentUser.getCollaborationRequestList() != null)
            for(CollaborationRequestEntity cre : currentUser.getCollaborationRequestList()){
                CollaborationRequest collaborationRequest = new CollaborationRequest(cre);
                TASKLISTS1.getChildren().add(collaborationRequest);
            }
            
        if(currentUser.getTaskAssignmentRequestList() != null)
            for(Accept_RecjectTaskEntity arte : currentUser.getTaskAssignmentRequestList()){
                TaskAssignmentRequest taskAssignmentRequest = new TaskAssignmentRequest(arte);
                Taskreq.getChildren().add(taskAssignmentRequest);
            }
        
        if(currentUser.getNotificationList() !=null){
            for(NotificationEntity ne:currentUser.getNotificationList()){
                Notification notification=new Notification(ne);
                NOTIFICATIONS.getChildren().add(notification);
            }
        }
    } 
    public void acceptTodoCollaborationResponse(UserEntity collaborator, int todoId){
        System.out.println("in acceptTodoCollaborationResponse");
        System.err.println(todoId);
        for (int i = 0; i < LIST.getChildren().size(); i++) {
            System.out.println(((Listicon) LIST.getChildren().get(i)).getTodo().getId());
            if (((Listicon) LIST.getChildren().get(i)).getTodo().getId() == todoId) {
                System.out.println("I found the todo");
                Collaborator collaboratorItem = new Collaborator(collaborator);
                ((Listicon) LIST.getChildren().get(i)).addCollaborator(collaboratorItem);
                break;
            }
        }
    }

    public void createTodoListResponse(ToDoEntity todo, boolean isOwner) {
        Platform.runLater(() -> {
            Listicon Litem = new Listicon(todo, isOwner);
            LIST.getChildren().add(Litem);
        });
    }
    
    
    public void createTaskResponse(TaskEntity task){
            Platform.runLater(() ->  {
                addTask(task);
               // currentToDo.getItemsList().get(currentToDo.getItemsList().indexOf(currentItem)).getTasksList().add(task);
                
                currentItem.getTasksList().add(task);
               
            });
    }

public void createItemResponse(ItemEntity item){
            Platform.runLater(() ->  {
                addItem(item);
               // currentToDo.getItemsList().add(item);
            });
    }

public  void addTask(TaskEntity taskEntity){
    Task task = new Task(taskEntity);   

    for(int i=0; i< TASKLISTS.getPanes().size();i++){
          Item i1 = (Item) TASKLISTS.getPanes().get(i);
          if(taskEntity.getItemId() == i1.itemId){
              i1.vBox.getChildren().add(task);
              break;
          }
       }
     
    }
   public  void addItem(ItemEntity itemEntity){
       for (int i = 0; i < LIST.getChildren().size(); i++) {
            System.out.println(((Listicon) LIST.getChildren().get(i)).getTodo().getId());
            if (((Listicon) LIST.getChildren().get(i)).getTodo().getId() == itemEntity.getTodoId()) {
                System.out.println("I found the todo");
                ((Listicon) LIST.getChildren().get(i)).todo.getItemsList().add(itemEntity);
               
                break;
            }
        }
       
       Item item = new Item(itemEntity);
       TASKLISTS.getPanes().add(item);
       
       
   }
   
   public void commentCreationResponse(CommentEntity commentEntity ){
        
        Platform.runLater(() ->  {
                addComment(commentEntity);
               List<TaskEntity> taskEntitys = currentToDo.getItemsList().get(currentToDo.getItemsList().indexOf(currentItem)).getTasksList();
                taskEntitys.get(taskEntitys.indexOf(currentTask)).getCommentsList().add(commentEntity);
               System.out.println("comment response invoked");
               
            });
    }
    
    public void addComment(CommentEntity commentEntity){
        Comment comment = new Comment(commentEntity);
        cOMMENTS.getChildren().add(comment);
    }

    public void setTodoColor(MouseEvent event) {
        if (TODOCOLOR != null) {
            TODOCOLOR.setStroke(Color.TRANSPARENT);
        }

        TODOCOLOR = (Circle) event.getSource();
        TODOCOLOR.setStroke(Color.BLACK);
    }

    public void updateTodoListResponse(ToDoEntity todo) {
        //boolean isOwnedByCurrentUser = ((Listicon)(LIST.getChildren().get(todoIndex))).getIsOwnedByCurrentUser();
        Platform.runLater(() -> {
            for (int i = 0; i < LIST.getChildren().size(); i++) {
                if (((Listicon) LIST.getChildren().get(i)).getTodo().getId() == todo.getId()) {
                    //System.out.println("title: "+((Listicon)node).getTodo().getTitle());
                    System.out.println("my index here is: " + i);
                    LIST.getChildren().set(i, new Listicon(todo, ((Listicon) LIST.getChildren().get(i)).isOwnedByCurrentUser));
                    break;
                }
            }
        });
        /*boolean isOwnedByCurrentUser = false;
        Listicon Litem = 
        LIST.getChildren().set(todoIndex, Litem);*/
    }

    public void deleteTodoListResponse(Integer todoId) {
        Platform.runLater(() -> {
            for(Node node : LIST.getChildren())
                if(((Listicon)node).getTodo().getId() == todoId)
                    LIST.getChildren().remove((Listicon)node);
        
        });
    }

    public void acceptCollaborationRequest(CollaborationRequestEntity request) {
        CollaboratorController collaboratorController = new CollaboratorController();
        //collaboratorController.acceptCollaboratorRequest(CurrentUser.getCurrentUser().getCollaborationRequestList().get(0));
        collaboratorController.acceptCollaboratorRequest(request);

    }

    public void deleteTodoListRequest(MouseEvent event) {

    }

    public void updateTodoListRequest(MouseEvent event) {
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
        eDITLISTAP.setVisible(false);
    }

    public void createTodoListRequest(MouseEvent event) {

        String todoTitle = NEWTODOTITLE.getText();
        System.out.println(todoTitle);

       /*OMNIA*/
        String empty="JFXDatePicker[id=STARTDATE, styleClass=combo-box-base date-picker jfx-date-picker]";        
        
        //if(!todoTitle.equals("") && STARTDATE.equals(empty) && ENDDATE.equals(empty) && TODOCOLOR != null){
       
        /*OMNIA*/ 


        if (!todoTitle.equals("") && STARTDATE != null && ENDDATE != null && TODOCOLOR != null) {

            Date startDate = Date.from(STARTDATE.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(ENDDATE.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

            ToDoListController tlc = new ToDoListController();
            tlc.createToDoList(new ToDoEntity(todoTitle, startDate, endDate, currentUser.getId(), 0, TODOCOLOR.getFill().toString()));

            NEWTODOTITLE.setText("");
            STARTDATE.setValue(null);
            ENDDATE.setValue(null);
            TODOCOLOR = null;
            ADDLISTPANE.setVisible(false);
            manageUI(false);
        }
    }
    
    public void updateFriendStatus(UserEntity friend){
        int i = 0;
        while(((Friendicon)FRIENDSLIST.getChildren().get(i)).getFriend().getId() != friend.getId())
            i++;
        ((Friendicon)FRIENDSLIST.getChildren().get(i)).getFriend().setUserStatus(friend.getUserStatus());
        ((Friendicon)FRIENDSLIST.getChildren().get(i)).updateFriendStatus(friend.getUserStatus());    
    }
    
    public void withdrawFromTaskResponse(UserEntity user){
        aSSIGNEDTOTASK.getChildren().remove(new Collaborator(user));   
    }
    /*REHAM*/

 /*abd-elmalek*/
 /*abd-elmalek*/
    class Addtaskpane extends AnchorPane {


    protected final AnchorPane anchorPane;
    public  JFXTextField ADDTASK1;

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
        
        ADDTASK1.setOnKeyPressed((KeyEvent event) -> {
            if(event.getCode()== KeyCode.ENTER){
                taskController.createNewTask(0, ADDTASK1.getText(), currentItem.getId());
                ADDTASK1.clear();
            }
        });
        

        
    }



}
    /* ahmedpro */
    
        /* ahmedpro */
    /**
     * Check if the friend list has that user name
     *
     * @param userName the user name
     * @return true if there is user name with that user name else return false
     */
    public boolean hasUserName(String userName) {
        for (int i = 0; i < currentUser.getFriendList().size(); i++) {
            if (currentUser.getFriendList().get(i).getUserName().equals(userName)) {
                return true;
            }
        }

        return false;
    }
    
        public void updateSearchingResultGUI(UserEntity userEntity) {
        Platform.runLater(() -> {
            if (userEntity.getId() == -1) {
                addFriendResult.setVisible(false);
                addFriendFailedLabel.setVisible(true);
                addFriendFailedLabel.setText("incorrect user name!");
            } else {
                searchingEntityResult = userEntity;
                addFriendFailedLabel.setVisible(false);
                addFriendResult.setVisible(true);
                friendName.setText(userEntity.getUserName());
            }
        });
    }

    public void updateAddFriendGUI(RequestEntity fre) {
        Platform.runLater(() -> {
            switch (fre.getId()) {
                case -1:
                    addFriendFailedLabel.setVisible(true);
                    addFriendFailedLabel.setText("your request is already sent!");
                    addFriendResult.setVisible(false);
                    break;
                case -2:
                    addFriendFailedLabel.setVisible(true);
                    addFriendFailedLabel.setText("you already have a friend request from that user!");
                    addFriendResult.setVisible(false);
                    break;
                default:
                    TASKLISTS11.getChildren().add(new FriendRequest(fre));
                    break;
            }
        });
    }

    public void updateAcceptFriendGUI(UserEntity userEntity) {
        Friendicon friendIcon = new Friendicon(userEntity);
        FRIENDSLIST.getChildren().add(friendIcon);
        System.out.println(userEntity.getId());
    }
    
    /* ahmedpro */
    
       
    
}