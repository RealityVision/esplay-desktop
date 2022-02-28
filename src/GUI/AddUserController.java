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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class AddUserController implements Initializable {

    @FXML
    private Label TextField_msg;
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
    private ChoiceBox<String> rolebox;
    @FXML
    private Label contol_msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rolebox.getItems().add("admin");
        rolebox.getItems().add("player");
        rolebox.setValue("player");
        
    }    

    @FXML
    private void onclick_create(ActionEvent event) {
        
        
        
        
         String Username= input_Username.getText();
       String FirstName= Input_Name.getText();
       String LastName= input_LastName.getText();
       String email= input_Email.getText();
       String password= input_Password.getText();
       String role= rolebox.getValue();
       
       if (Username.isEmpty()||FirstName.isEmpty()||LastName.isEmpty()||email.isEmpty()||password.isEmpty()||role.isEmpty()){
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
        User u = new User(Username,FirstName,LastName,email,password,role);
        UserService us = new UserService();
        us.CreateUserADMIN(u);
        
                FXMLLoader loder = new FXMLLoader(getClass().getResource("Admin_user.fxml"));
                 try {
                     Parent root = loder.load();
                     TextField_msg.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
       }}
        
    

    @FXML
    private void Onclick_Reset(ActionEvent event) {
          FXMLLoader loder = new FXMLLoader(getClass().getResource("Admin_user.fxml"));
                 try {
                     Parent root = loder.load();
                     TextField_msg.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }
    
}
