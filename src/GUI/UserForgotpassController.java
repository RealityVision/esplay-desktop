/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javax.mail.MessagingException;
import services.MailUtils;
import services.PasswordUtils;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class UserForgotpassController implements Initializable {

    @FXML
    private TextField usernameID;
    @FXML
    private Label Err;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Onclick_submit(ActionEvent event) throws IOException {
        UserService us = new UserService();
       User u = us.ReadUser(usernameID.getText());
        if (u.getEmail() != null){
            
            try {
                String pass = getRandomStr();
                String salt =  PasswordUtils.getSalt(20);
                String password =  PasswordUtils.generateSecurePassword(pass, salt);
                
                u.setPassword(password);
                u.setSalt(salt);
                us.UpdateUserpassword(u);
                
                MailUtils.sendmail2(u.getEmail(), pass );
                Err.setTextFill(Color.DARKMAGENTA);
                Err.setText("*Your password is sended to your email:  "+ u.getEmail());
            } catch (MessagingException ex) {
                Logger.getLogger(UserForgotpassController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
             Err.setText("*Verify your username");
        }
    }
    public static String getRandomStr() 
    {
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz"+"0123456789"; 
  
        StringBuilder s = new StringBuilder(10); 
  
        for (int i = 0; i < 10; i++) { 
            int index = (int)(str.length() * Math.random()); 
            s.append(str.charAt(index)); 
        } 
        return s.toString();  
    } 

    @FXML
    private void Onclick_Login(ActionEvent event) {
         FXMLLoader loder = new FXMLLoader(getClass().getResource("Authentification_Interface.fxml"));
                  try {
                     Parent root = loder.load();
                     usernameID.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }
    
}
