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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
 static int id ;
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
        
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("Do you want to delete this user ?");
        Optional<ButtonType> result = alert2.showAndWait();
        System.out.println(result.toString());
        if(!result.get().getText().equals("Annuler")){
            UserService us = new UserService();
            us.DeleteUser(Integer.parseInt(text_id.getText()));
            updatetable();
        }else {
        updatetable();
        }
        
        
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
         FXMLLoader loder = new FXMLLoader(getClass().getResource("AUpdateUser.fxml"));
                 try {
                     Parent root = loder.load();
                     tableView.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void Imprimer(ActionEvent event) {
          PrinterJob job = PrinterJob.createPrinterJob();
       
        Node root= this.tableView;
        
     if(job != null){
     job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
     Printer printer = job.getPrinter();
     PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
     boolean success = job.printPage(pageLayout, root);
     if(success){
        job.endJob();
     }
   }
    }

    @FXML
    private void Onclick_Game(ActionEvent event) {
                FXMLLoader loder = new FXMLLoader(getClass().getResource("Dashboard_Games.fxml"));
                 try {
                     Parent root = loder.load();
                     tableView.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
       
        
    }

   @FXML
    private void Onclick_Store(ActionEvent event) {
         FXMLLoader loder = new FXMLLoader(getClass().getResource("Addproduit2.fxml"));
                  try {
                     Parent root = loder.load();
                     tableView.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
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
       id = Integer.parseInt(text_id.getText());
    }
   
}
