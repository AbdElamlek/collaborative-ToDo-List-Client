/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Handlers.ToDoCreationHandler;
import Handlers.Handler;
import Handlers.NotificationHandler;
import Handlers.LoginHandler;
import Handlers.ItemCreationHandler;
import Handlers.SignUpHandler;
import ControllerBase.ActionHandler;
import ControllerBase.SocketInterface;
import Handlers.AcceptFriendHandler;
import Handlers.AddFriendHandler;
import Handlers.DeclineFriendHandler;
import Handlers.SearchFriendHandler;
import Handlers.CollaboratorRequestHandler;
import Handlers.ItemDeletionHandler;
import Handlers.ItemUpdateHandler;
import Handlers.AcceptCollaboratorRequestHandler;
import Handlers.CommentCreationHandler;
import Handlers.FriendStatusHandler;
import Handlers.TaskCreationHandler;
import Handlers.TaskDeleteHandler;
import Handlers.ToDoDeleteHandler;
import Handlers.ToDoUpdateHandler;
import Handlers.TaskUpdateStatusHandler;
import Handlers.WithdrawFromTaskHandler;
import collaborative.to.pkgdo.list.client.FXMLDocumentController;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class SocketController implements SocketInterface {

    private Socket socket;
    private DataInputStream dataInputStream;
    //private DataOutputStream dataOutputStream;
    private PrintStream printStream;
    public static Boolean isRunning=false;
    private Thread thread;
    private static Consumer<Integer> connectionFailed;

    private static SocketController socketController;

    private SocketController() {
        try {
            System.out.println("try to connect");
            socket = new Socket("127.0.0.1", 7777);
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            isRunning = true;
            
            thread = new Thread() {
                @Override
                public void run() {
                    while (isRunning) {
                        try {
                            String receivedResponse = dataInputStream.readLine();
                            System.out.println("received something");
                            System.out.println(receivedResponse);
                            if(receivedResponse!=null){
                            handleResponse(receivedResponse);
                            }
                            else{
                                 
                                 System.out.println("server is down!");
                                  isRunning = false; 
                                  if(connectionFailed !=null)
                                  connectionFailed.accept(null);
                                  
                                 
                            
                            }
                        } catch (IOException ex) {
                            isRunning = false;
                            System.out.println(isRunning+"in siderun");
                            
                        }
                    }
                }
            };
        } catch (IOException ex) {

            System.out.print(ex);
             isRunning = false;
             System.out.println(isRunning+"in socet");

        }
    }

    
    public static void setConnectionFailed(Consumer<Integer> failed) {
       connectionFailed=failed;
        
        
    }
    
     
    public static boolean reConnect() {
       
       socketController=null;
       return getInstance().connect();
    }
    
    
    @Override

    
    public boolean connect() {
       if(thread==null){
           
           socketController=null;
           
        return false;
       }
       
    Platform.runLater(new Runnable() {
        @Override
        public void run() {
       if(!thread.isAlive())
            thread.start();
        }
    });
       
       return true;
    }

    @Override
    public void disconnect() {

        
        try {
            dataInputStream.close();
            printStream.close();
            socket.close();
            socketController=null;
            isRunning=false;
            
            
        } catch (IOException ex) {
            Logger.getLogger(SocketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendJsonObject(String jsonObjectStr) {
        /*Eman Kamal*/
        System.out.println("sending json: " + jsonObjectStr);
        
            //OR FUNCTION NAME CAN BE: sendRequest(String jsonObjectStr)
            //System.out.println("from sendJsonObject: " + jsonObjectStr);
            if(printStream != null)
                printStream.println(jsonObjectStr);
            System.out.println("SENT");

            //Send to the server the json to register !
            //dataOutputStream.writeUTF(jsonObjectStr);
       
        /*Eman Kamal*/
    }

    public void handleResponse(String jsonObjectStr) {
        try {
            
            JSONObject jsonObject = new JSONObject(jsonObjectStr);
            String action = jsonObject.getString("action");
            ActionHandler actionHandler = null;
            
            switch (action) {
                case "logIn":
                    actionHandler = new LoginHandler();
                    break;
                case "signup":
                    actionHandler = new SignUpHandler();
                    break;
                case "notification":
                    actionHandler = new NotificationHandler();
                    break;
                case "create todo list":
                    actionHandler = new ToDoCreationHandler();
                    break;
                case "update todo list":
                    System.out.println("in update todo");
                    actionHandler = new ToDoUpdateHandler();
                    break;
                case "delete todo list":
                    actionHandler = new ToDoDeleteHandler();
                    break;
                case "searchFriend":
                    actionHandler = new SearchFriendHandler();
                    break;
                case "addFriend":
                    actionHandler = new AddFriendHandler();
                    break;
                case "acceptFriend":
                    actionHandler = new AcceptFriendHandler();
                    break;
                case "declineFriend":
                    actionHandler = new DeclineFriendHandler();
                case "recieve collaborator notification":
                    actionHandler = new NotificationHandler();
                    break;
                case "recieve collaborator request":  
                    actionHandler = new CollaboratorRequestHandler();
                    break;
                case "create item":
                    actionHandler = new ItemCreationHandler();
                    break;
                case "update item":
                    actionHandler = new ItemUpdateHandler();
                    break;
                case "delete item":
                    actionHandler = new ItemDeletionHandler();
                    break;    
                case "accept collaborator request":
                    actionHandler = new AcceptCollaboratorRequestHandler();
                    break;
                case "offline friend":
                case "online friend":
                    actionHandler = new FriendStatusHandler();
                    break;
                case "create task":
                    actionHandler = new TaskCreationHandler();
                    break;
                case "changeTaskStatus":
                    actionHandler = new TaskUpdateStatusHandler();
                    break;
                case "delete task":
                    actionHandler = new TaskDeleteHandler();
                    break;
                case "withdraw from task":
                    actionHandler = new WithdrawFromTaskHandler();
                    break;
                case "add comment":
                    actionHandler = new CommentCreationHandler();
                    break;    
                    /*
                    "accept task assignment request"
                    "accept friend request"
                    item
                    task
                    comment
                    withdraw(here for other collaborators and the owner where thay know from server)
                    
                    */                    /*
                    "accept task assignment request"
                    "accept friend request"
                    item
                    task
                    comment
                    withdraw(here for other collaborators and the owner where thay know from server)
                    
                    */
            }
            Handler handler = new Handler(actionHandler);
            handler.handleAction(jsonObjectStr);

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public static SocketController getInstance() {
        if (socketController == null) {
            synchronized (SocketController.class) {
                if (socketController == null) {
                    socketController = new SocketController();
                }
            }
        }
        return socketController;
    }

}
