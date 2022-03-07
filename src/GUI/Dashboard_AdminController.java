/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class Dashboard_AdminController implements Initializable {

    @FXML
    private Label title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Onclick_Game(ActionEvent event) {
               FXMLLoader loder = new FXMLLoader(getClass().getResource("Dashboard_Games.fxml"));
                 try {
                     Parent root = loder.load();
                     title.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
        
    }

    @FXML
    private void Onclick_Store(ActionEvent event) {
         FXMLLoader loder = new FXMLLoader(getClass().getResource("Addproduit2.fxml"));
                  try {
                     Parent root = loder.load();
                     title.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void Onclick_User(ActionEvent event) {
                  FXMLLoader loder = new FXMLLoader(getClass().getResource("Admin_user.fxml"));
                 try {
                     Parent root = loder.load();
                      title.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void Onclick_logout(ActionEvent event) {
              Authentification_InterfaceController.ID=0;
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Authentification_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     title.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }
    
}
