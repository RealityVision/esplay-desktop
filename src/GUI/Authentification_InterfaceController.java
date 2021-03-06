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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.mail.MessagingException;
import services.AuthService;
import services.MailUtils;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author fadhe
 */
public class Authentification_InterfaceController implements Initializable {
    static int ID;
    @FXML
    private TextField textFiled_Username;
    @FXML
    private TextField TextFiled_password;
    @FXML
    private Button btn_login;
    @FXML
    private ImageView logo;
    @FXML
    private Label textField_warning;
    @FXML
    private TextField input_Username;
    @FXML
    private TextField Input_Name;
    @FXML
    private TextField input_LastName;
    @FXML
    private TextField input_Email;
    @FXML
    private TextField input_Password;
    @FXML
    private Label TextField_msg;
    @FXML
    private Label contol_msg;
    @FXML
    private Button btn_pass;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick_login(ActionEvent event) {
        
        
        String Username = textFiled_Username.getText();
        String Password = TextFiled_password.getText();
        
        

      if (Username.isEmpty() || Password.isEmpty() ){
      textField_warning.setText("The Login and password fields are required! ");
      
      }
   
       else {
                
                
                 AuthService a = new AuthService();
                  System.out.println(a.authentification(Username, Password));
                 if(a.authentification(Username, Password) == 1){

                        UserService us = new UserService();
                        User u = us.ReadUser(Username);
                        ID =u.getId_user();
                        System.out.println(ID); 
                        System.out.println(u.getRole());
                        if(u.getRole().equals("admin")) {

                              FXMLLoader loder = new FXMLLoader(getClass().getResource("Dashboard_Admin.fxml"));
                              try {
                                  Parent root = loder.load();
                                  btn_login.getScene().setRoot(root);
                              } catch (IOException ex) {
                                  System.out.println(ex.getMessage());
                              }
              }
              else {
                        FXMLLoader loder = new FXMLLoader(getClass().getResource("Home_Interface.fxml"));
                         try {
                            Parent root = loder.load();
                            btn_login.getScene().setRoot(root);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                 }
           
              }
              else if(a.authentification(Username, Password) == 0) {
                        //ERROR mot de passe incorrect
                        textField_warning.setText("Incorrect password");
                    }
                    else {
                        // ERROR user n'existe pas
                        textField_warning.setText("Incorrect username");
                    }

                
                
         }
        
        
           
    }

    @FXML
    private void onclick_create(ActionEvent event) {
        
        
       String Username= input_Username.getText();
       String FirstName= Input_Name.getText();
       String LastName= input_LastName.getText();
       String email= input_Email.getText();
       String password= input_Password.getText();
         if (Username.isEmpty()||FirstName.isEmpty()||LastName.isEmpty()||email.isEmpty()||password.isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Please fill all DATA");
           alert.showAndWait();
       } else if (Username.length()<4){

            contol_msg.setText("*Username must have at least 4 characters ");


            }else if (email.length()<4 || !email.contains("@") || !email.contains(".")){

            contol_msg.setText("*Email is not valid ");

            }
            else if (password.length()<6){

            contol_msg.setText("*Password must have at least 6 characters ");

            }

         else{
           try {
               User u = new User(Username,FirstName,LastName,email,password);
               UserService us = new UserService();
               us.CreateUser(u);
               
               MailUtils.SendMail(email, Username);
               
               
               input_Username.setText(null);
               Input_Name.setText(null);
               input_LastName.setText(null);
               input_Email.setText(null);
               input_Password.setText(null);
               
               contol_msg.setText(null);
               TextField_msg.setText("Account created");
           } catch (MessagingException ex) {
               Logger.getLogger(Authentification_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
           }
       
    }
    }

    @FXML
    private void Onclick_ForgotPassword(ActionEvent event) {
         FXMLLoader loder = new FXMLLoader(getClass().getResource("UserForgotpass.fxml"));
                              try {
                                  Parent root = loder.load();
                                  btn_login.getScene().setRoot(root);
                              } catch (IOException ex) {
                                  System.out.println(ex.getMessage());
                              }
    }
    
    
}