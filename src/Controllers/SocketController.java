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
import Handlers.DeleteFriendHandler;
import Handlers.SearchFriendHandler;
import Handlers.ItemDeletionHandler;
import Handlers.ItemUpdateHandler;
import Handlers.AcceptCollaboratorRequestHandler;
import Handlers.ToDoDeleteHandler;
import Handlers.ToDoUpdateHandler;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class SocketController implements SocketInterface {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private PrintStream printStream;
    private Boolean isRunning;
    private Thread thread;

    private static SocketController socketController;

    private SocketController() {
        try {
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
                            handleResponse(receivedResponse);
                        } catch (IOException ex) {
                            isRunning = false;
                            //ex.printStackTrace();
                        }
                    }
                }
            };
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void connect() {
        thread.start();
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendJsonObject(String jsonObjectStr) {
        /*Eman Kamal*/
        System.out.println("sending json: " + jsonObjectStr);
        
            //OR FUNCTION NAME CAN BE: sendRequest(String jsonObjectStr)
            //System.out.println("from sendJsonObject: " + jsonObjectStr);
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
                case "deleteFriend":
                    actionHandler = new DeleteFriendHandler();
                    break;
                case "acceptFriend":
                    actionHandler = new AcceptFriendHandler();
                    break;
                case "declineFriend":
                    actionHandler = new DeclineFriendHandler();
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
