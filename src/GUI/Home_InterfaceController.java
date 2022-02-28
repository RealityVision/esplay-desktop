/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Chat;
import entities.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import services.ChatService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class Home_InterfaceController implements Initializable {
    
   
    @FXML
    private Button btn_send_message;
    @FXML
    private TextField textfield_message;
    @FXML
    private VBox vbox_chat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChatService cv= new ChatService();
        List<Chat> chats = cv.ReadChat();
      
        refresh(chats);
        
         
    }    

    @FXML
    private void send_message(ActionEvent event) throws IOException {
        UserService us = new  UserService();
        User u = us.ReadUser(Authentification_InterfaceController.ID);
        String message = textfield_message.getText();
        Chat m1 = new Chat(1,message); 
        ChatService cs = new ChatService();
        cs.SendMessage(m1);
        textfield_message.setText(null);
         FXMLLoader fxl = new FXMLLoader();
            fxl.setLocation(getClass().getResource("outmsg.fxml"));
            HBox msgg = fxl.load();
            OutmsgController mc = fxl.getController();
            mc.setData(message,u.getUsername(),new java.sql.Timestamp(System.currentTimeMillis()) );     
            vbox_chat.getChildren().add(msgg);
            
    }
    
    public void refresh(List<Chat> c){
    try {
             for (int i =0; i<c.size(); i++){
            FXMLLoader fxl = new FXMLLoader();
            fxl.setLocation(getClass().getResource("msg.fxml"));
            HBox msgg = fxl.load();
            MsgController mc = fxl.getController();
            mc.setData(c.get(i).getMessage(),c.get(i).getUsername(),c.get(i).getDate_message());
            
            vbox_chat.getChildren().add(msgg);
           
             }
        } catch (IOException ex) {
            Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @FXML
    private void logout(ActionEvent event) {
        Authentification_InterfaceController.ID=0;
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Authentification_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     btn_send_message.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
        
    }

    @FXML
    private void btn_sendfile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        
        File f = fileChooser.showOpenDialog(null);
        System.out.println(f.getAbsolutePath());
        
        String newpath = "src/assets/images/";
        File dir = new File(newpath);
        if (!dir.exists()){
        dir.mkdirs();
        }
        
        File source = null;
        File destination = null;
        destination = new File (newpath+"copy.png");
        source =new File(f.getAbsolutePath());
        try {
            Files.copy(source.toPath(), destination.toPath());
                    } catch (IOException ex) {
            Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Onclick_profil(ActionEvent event) {
                         FXMLLoader loder = new FXMLLoader(getClass().getResource("Profil_Interface.fxml"));
                  try {
                     Parent root = loder.load();
                     btn_send_message.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }
    
}
