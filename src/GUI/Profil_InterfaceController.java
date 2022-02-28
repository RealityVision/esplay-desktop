/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserService us = new UserService();
        User u = us.ReadUser(Authentification_InterfaceController.ID);
        TextField_User.setText(u.getUsername());
        TextField_Name.setText(u.getFirst_name());
        TextField_LName.setText(u.getLast_name());
        TextField_Emails.setText(u.getEmail());
        
    }   

    @FXML
    private void btn_username(ActionEvent event) {
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
       UserService us = new UserService();
       User u1 = us.ReadUser(Authentification_InterfaceController.ID);
       User u = new User(Authentification_InterfaceController.ID, Username, FirstName, LastName, phone, email, password,u1.getSalt(), Country, date, Address, Gender);
       us.UpdateUser(u);
      System.out.print(birth);
    }

    @FXML
    private void Onclick_Reset(ActionEvent event) {
    }
    
}
