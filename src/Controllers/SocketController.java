/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ControllerBase.ActionHandler;
import ControllerBase.SocketInterface;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Abd-Elmalek
 */
public class SocketController implements SocketInterface{

    private Socket socket; 
    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private Thread thread;
    
    private static SocketController socketController;
    
    private SocketController(){
        try {
            socket = new Socket("127.0.0.1", 5005);
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            
            thread = new Thread(){
              @Override
              public void run(){
                  while (true) {                      
                      try {
                          String receivedResponse = dataInputStream.readLine();
                          handleResponse(receivedResponse);
                      } catch (IOException ex) {
                          ex.printStackTrace();
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
    public void sendJsonObject(String jsonObjectStr) { //OR FUNCTION NAME CAN BE: sendRequest(String jsonObjectStr)
        //System.out.println("from sendJsonObject: " + jsonObjectStr);
        printStream.println(jsonObjectStr);
    }

    public void handleResponse(String jsonObjectStr){
        try {
            JSONObject jsonObject = new JSONObject(jsonObjectStr);
            String action = jsonObject.getString("action");
            ActionHandler actionHandler = null;
            
            switch(action){
                case "login":
                    actionHandler = new LoginHandler();
                    break;
            }
            Handler handler = new Handler(actionHandler);
            handler.handleAction(jsonObjectStr);
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    public static SocketController getInstance() {
        if(socketController == null)
            synchronized(SocketController.class){
                if(socketController == null)
                    socketController = new SocketController();
            }
        return socketController;
    }
    
}
