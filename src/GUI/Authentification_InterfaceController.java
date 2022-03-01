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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import services.AuthService;
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
        
        
            AuthService a = new AuthService();
       System.out.println(a.authentification(Username, Password));
       if(a.authentification(Username, Password) == 1){
           
           UserService us = new UserService();
           User u = us.ReadUser(Username);
           ID =u.getId_user();
           System.out.println(ID); 
           System.out.println(u.getRole());
           if(u.getRole().equals("admin")) {
               
                 FXMLLoader loder = new FXMLLoader(getClass().getResource("Product.fxml"));
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

    @FXML
    private void onclick_create(ActionEvent event) {
        
       String Username= input_Username.getText();
       String FirstName= Input_Name.getText();
       String LastName= input_LastName.getText();
       String email= input_Email.getText();
       String password= input_Password.getText();
       
       User u = new User(Username,FirstName,LastName,email,password);
       UserService us = new UserService();
       us.CreateUser(u);
       
       input_Username.setText(null);
       Input_Name.setText(null);
       input_LastName.setText(null);
       input_Email.setText(null);
       input_Password.setText(null);
       
       TextField_msg.setText("Account created");
       
    }
    
}