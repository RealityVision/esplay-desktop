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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class Profil_InterfaceController implements Initializable {

    @FXML
    private Circle ChampsPhoto;
    @FXML
    private TextField TextField_User;
    @FXML
    private TextField TextField_Name;
    @FXML
    private TextField TextField_LName;
    @FXML
    private TextField TextField_Gender;
    @FXML
    private DatePicker TextField_Birdh;
    @FXML
    private TextField TextField_Country;
    @FXML
    private TextField TextField_Phone;
    @FXML
    private TextField TextField_Emails;
    @FXML
    private TextField TextField_NPswd;
    @FXML
    private TextField TextField_Address;
    @FXML
    private Text Name;
    @FXML
    private Text Name1;
    @FXML
    private Label success_msg;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }   
private void refresh(){
     UserService us = new UserService();
        User u = us.ReadUser(Authentification_InterfaceController.ID);
        Name.setText(u.getUsername());
        Name1.setText(u.getUsername());
        TextField_User.setText(u.getUsername());
        TextField_Name.setText(u.getFirst_name());
        TextField_LName.setText(u.getLast_name());
        TextField_Emails.setText(u.getEmail());
        TextField_Address.setText(u.getAddress());
        TextField_Phone.setText(Integer.toString(u.getPhone()));
        TextField_Country.setText(u.getCountry());
        TextField_Gender.setText(u.getGender());
        if(u.getBirthdate()!=null){
        TextField_Birdh.setValue(u.getBirthdate().toLocalDate());
}
}
    @FXML
    private void Onclick_save(ActionEvent event) {
          
       String Username= TextField_User.getText();
       String FirstName= TextField_Name.getText();
       String LastName= TextField_LName.getText();
       String email=  TextField_Emails.getText();
       String Gender=  TextField_Gender.getText();
       String Country=  TextField_Country.getText();
       String Address=  TextField_Address.getText();
       LocalDate birth= TextField_Birdh.getValue();
       Date date = Date.valueOf(birth);
       int phone = Integer.parseInt( TextField_Phone.getText());
       String password= TextField_NPswd.getText();
        if (Username.length()<4){
           success_msg.setTextFill(Color.RED);
       success_msg.setText("*Username must have at least 4 characters ");
       
       
       }else if (email.length()<4 || !email.contains("@") || !email.contains(".")){
         success_msg.setTextFill(Color.RED);  
       success_msg.setText("*Email is not valid ");
       
       
       }
    

         
         else{
      
       
       UserService us = new UserService();
       User u1 = us.ReadUser(Authentification_InterfaceController.ID);
       User u = new User(Authentification_InterfaceController.ID, Username, FirstName, LastName, phone, email, password,u1.getSalt(), Country, date, Address, Gender);
       us.UpdateUser(u);
     success_msg.setText("Your profile is updated");
     refresh();
       }
    }

    @FXML
    private void Onclick_Reset(ActionEvent event) {
                FXMLLoader loder = new FXMLLoader(getClass().getResource("Profil_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     TextField_Emails.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void Onclick_play(ActionEvent event) {
          FXMLLoader loder = new FXMLLoader(getClass().getResource("Home_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     TextField_Emails.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void Onclick_out(ActionEvent event) {
        Authentification_InterfaceController.ID=0;
          FXMLLoader loder = new FXMLLoader(getClass().getResource("Authentification_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     TextField_Emails.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }
    
}
