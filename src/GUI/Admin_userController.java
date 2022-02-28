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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class Admin_userController implements Initializable {

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User,Integer> idcol;
    @FXML
    private TableColumn<User,String> usernamecol;
    @FXML
    private TableColumn<User,String> fnamecol;
    @FXML
    private TableColumn<User,String>lnamecol;
    @FXML
    private TableColumn<User,Integer> phonecol;
    @FXML
    private TableColumn<User,String> emailcol;
    @FXML
    private TableColumn<User,String> countrycol;
    @FXML
    private TableColumn<User,Date> birthcol;
    @FXML
    private TableColumn<User,String> addresscol;
    @FXML
    private TableColumn<User,String> rolecol;
    @FXML
    private TableColumn<User,String> gendercol;
    @FXML
    private TableColumn<?,?> actioncol;
    
    ObservableList <User> UsersList = FXCollections.observableArrayList() ;
 int index = -1; 
    @FXML
    private TextField text_id;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       updatetable();
       
    }   
    private void updatetable(){
    
     idcol.setCellValueFactory(new PropertyValueFactory<>("id_user"));
       usernamecol.setCellValueFactory(new PropertyValueFactory<>("username"));
       fnamecol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
       lnamecol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
       phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
       emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
      countrycol.setCellValueFactory(new PropertyValueFactory<>("country"));
       birthcol.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
       addresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
       rolecol.setCellValueFactory(new PropertyValueFactory<>("role"));
       gendercol.setCellValueFactory(new PropertyValueFactory<>("gender"));
       
         UsersList.clear();
         UserService us = new UserService();
         List l1 = us.ReadALLUsers();
         UsersList.addAll(l1);
         tableView.setItems(UsersList);
    
    }

    @FXML
    private void DeleteUser(ActionEvent event) {
        UserService us = new UserService();
        us.DeleteUser(Integer.parseInt(text_id.getText()));
        updatetable();
        
    }

    @FXML
    private void adduser(ActionEvent event) {
             FXMLLoader loder = new FXMLLoader(getClass().getResource("AddUser.fxml"));
                 try {
                     Parent root = loder.load();
                     tableView.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void updateUser(ActionEvent event) { 
         FXMLLoader loder = new FXMLLoader(getClass().getResource("AupdateUser.fxml"));
                 try {
                     Parent root = loder.load();
                     tableView.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void Imprimer(ActionEvent event) {
    }

    @FXML
    private void Onclick_Game(ActionEvent event) {
    }

    @FXML
    private void Onclick_Store(ActionEvent event) {
    }

    @FXML
    private void Onclick_User(ActionEvent event) {
   
    }

    @FXML
    private void Onclick_logout(ActionEvent event) {
        Authentification_InterfaceController.ID=0;
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Authentification_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     tableView.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
       
    }

    @FXML
    private void getSelected(MouseEvent event) {
        index = tableView.getSelectionModel().getSelectedIndex();
        if (index<=-1){
        return;}
        text_id.setText(idcol.getCellData(index).toString());
        System.out.println(text_id.getText());
    }
   
}
