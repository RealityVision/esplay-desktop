/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit2;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ProduitService2;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class FrontController implements Initializable {

    private TextField prix;
    private TextField nom;
    private TextField description;
    private TextField image;
    private TextField categorie;
    private TextField date;
    @FXML
    private VBox vbox_Prod;
    @FXML
    private Button btn_support;
    
    ObservableList<Produit2> listep = FXCollections.observableArrayList();
    
     private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection MCN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProduitService2 as = new ProduitService2();
        vbox_Prod.getChildren().clear();
        
          
refresh(as.readAll());
        
                     
         
        
    }   
    private void handlebuttonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Paiement.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void refresh(List<Produit2> p){
        for (int i =0; i<p.size(); i++){
            try {
                FXMLLoader fxl = new FXMLLoader();
                fxl.setLocation(getClass().getResource("Modelproduit.fxml"));
                HBox HbProd = fxl.load();
                ModelproduitController mc = fxl.getController();
                System.out.println(p.get(i).getImage());
                System.out.println(p.get(i).getImage());
              mc.setData(p.get(i).getNom(),Integer.toString(p.get(i).getPrix()),p.get(i).getDescription(),p.get(i).getImage(),p.get(i).getIdp2());
                vbox_Prod.getChildren().add(HbProd);
            } catch (IOException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
    
  
}
     @FXML
    private void support(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Support.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void toStore(ActionEvent event) {
    }

      @FXML
    private void logout(ActionEvent event) {
        Authentification_InterfaceController.ID=0;
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Authentification_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     vbox_Prod.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
        
    }

    @FXML
    private void toHome(ActionEvent event) {
        
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Home_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     vbox_Prod.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

     @FXML
    private void Onclick_profil(ActionEvent event) {
                         FXMLLoader loder = new FXMLLoader(getClass().getResource("Profil_Interface.fxml"));
                  try {
                     Parent root = loder.load();
                     vbox_Prod.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    

}
