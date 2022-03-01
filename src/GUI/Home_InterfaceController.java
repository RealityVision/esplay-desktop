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
import java.io.InputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
   
       // refresh(chats);
           
      //  InputStream input = this.getClass().getResourceAsStream("../assets/images/copy.png");
      //  System.out.println(input);
     //   Image image = new Image(input);
       // msg_image.setImage(image);
              
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
                 if (c.get(i).getId_user()!=Authentification_InterfaceController.ID && c.get(i).getMessage()!= null){
                FXMLLoader fxl = new FXMLLoader();
                fxl.setLocation(getClass().getResource("msg.fxml"));
                HBox msgg = fxl.load();
                MsgController mc = fxl.getController();
                mc.setData(c.get(i).getMessage(),c.get(i).getUsername(),c.get(i).getDate_message());

                vbox_chat.getChildren().add(msgg);
           }else if (c.get(i).getId_user()==Authentification_InterfaceController.ID&& c.get(i).getMessage()!= null){
                        FXMLLoader fxl = new FXMLLoader();
                   fxl.setLocation(getClass().getResource("outmsg.fxml"));
                   HBox msgg = fxl.load();
                   OutmsgController mc = fxl.getController();
                   mc.setData(c.get(i).getMessage(),c.get(i).getUsername(),c.get(i).getDate_message() );     
                   vbox_chat.getChildren().add(msgg);

            }else if (c.get(i).getMessage()== null && c.get(i).getId_user()==Authentification_InterfaceController.ID){
                     System.out.println("null message");
                     System.out.println(c.get(i).getFile());
                     FXMLLoader fxl = new FXMLLoader();
                    fxl.setLocation(getClass().getResource("outmsgfile.fxml"));
                    HBox msgg = fxl.load();
                    OutmsgfileController mc = fxl.getController();
                         System.out.println(c.get(i).getFile()+ "  kbal fnc");
                        mc.setData(c.get(i).getFile()) ;     
                        vbox_chat.getChildren().add(msgg);
                 }
             }
        } catch (IOException ex) {
            Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
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
     
        
        String ext = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf('.') +1);
        String namefile = getRandomStr();
        destination = new File (newpath+namefile+'.'+ext);
     
        source =new File(f.getAbsolutePath());
        try {
            Files.copy(source.toPath(), destination.toPath());
           
            ChatService cs = new ChatService();
             String  file = "../assets/images/"+namefile+'.'+ext;
             Chat c = new Chat (Authentification_InterfaceController.ID,file,null);
                cs.SendFile(c);
 
                    } catch (IOException ex) {
            Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Home_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     btn_send_message.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }
    
    public static String getRandomStr() 
    {
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz"; 
  
        StringBuilder s = new StringBuilder(7); 
  
        for (int i = 0; i < 7; i++) { 
            int index = (int)(str.length() * Math.random()); 
            s.append(str.charAt(index)); 
        } 
        return s.toString(); 
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

}
