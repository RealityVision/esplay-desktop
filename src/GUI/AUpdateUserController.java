/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class AUpdateUserController implements Initializable {

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
    private ChoiceBox<String> rolebox;
    @FXML
    private Label contol_msg;
    @FXML
    private TextField input_Address;
    @FXML
    private TextField input_Phone;
    @FXML
    private TextField input_Country;
 
    @FXML
    private DatePicker input_Birthdate;
    @FXML
    private Label label_gender;
   
    @FXML
    private ChoiceBox<String> genderbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genderbox.getItems().add("Male");
        genderbox.getItems().add("Female");
        rolebox.getItems().add("admin");
        rolebox.getItems().add("player");
     
        refresh();
        
    }    

    @FXML
    private void onclick_update(ActionEvent event) {
       String Username= input_Username.getText();
       String FirstName= Input_Name.getText();
       String LastName= input_LastName.getText();
       String email=  input_Email.getText();
       String Address=  input_Address.getText();
       int phone = Integer.parseInt( input_Phone.getText());
       String Country=  input_Country.getText();
       String password= ""; 
       String Gender=  genderbox.getValue();
       String role=  rolebox.getValue();
      
       LocalDate birth= input_Birthdate.getValue();
       Date date = Date.valueOf(birth);
    
        if (Username.length()<4){
           contol_msg.setTextFill(Color.RED);
       contol_msg.setText("*Username must have at least 4 characters ");
       
       
       }else if (email.length()<4 || !email.contains("@") || !email.contains(".")){
         contol_msg.setTextFill(Color.RED);  
      contol_msg.setText("*Email is not valid ");
       
       
       }
    
         else{
      
       
       UserService us = new UserService();
       User u1 = us.ReadUser( Admin_userController.id);
       
       User u = new User( Admin_userController.id, Username, FirstName, LastName, phone, email, password,"",Country, date, Address, Gender,role);
       
      
       
       us.UpdateUserAdmin(u);
     contol_msg.setText("profile updated successfully");
      FXMLLoader loder = new FXMLLoader(getClass().getResource("Admin_user.fxml"));
                 try {
                     Parent root = loder.load();
                     input_Phone.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
        
    }
    }
    private void refresh(){

        UserService us = new UserService();
       User u = us.ReadUser( Admin_userController.id);
        System.out.println(u.toString());
        input_Username.setText(u.getUsername());
        Input_Name.setText(u.getFirst_name());
        input_LastName.setText(u.getLast_name());
        input_Email.setText(u.getEmail());
        input_Address.setText(u.getAddress());
        input_Phone.setText(Integer.toString(u.getPhone()));
        input_Country.setText(u.getCountry());
       genderbox.setValue(u.getGender());
          rolebox.setValue(u.getRole());
        if(u.getBirthdate()!=null){
        input_Birthdate.setValue(u.getBirthdate().toLocalDate());
      
        
}
    }

    @FXML
    private void Onclick_Reset(ActionEvent event) {
         FXMLLoader loder = new FXMLLoader(getClass().getResource("Admin_user.fxml"));
                 try {
                     Parent root = loder.load();
                     input_Phone.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

   
    
}
