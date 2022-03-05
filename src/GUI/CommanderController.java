/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import services.OrderService;
import entities.Order;
import services.ProduitService2;
import entities.Produit2;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class CommanderController implements Initializable {


    @FXML
    private Label nom11;
    @FXML
    private TextField quantiteInsertion;
        Produit2 p = new Produit2();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void CommanderProd(ActionEvent event) throws SQLException, IOException {
        OrderService cs =  new OrderService();
        ProduitService2 ps =new ProduitService2();
               p= ps.AfficherDetailProduit(Produit2.id_pModifier);
                int nbr=Integer.parseInt(quantiteInsertion.getText());
        System.out.println("aaaaaa"+p.getStockProduit());
        System.out.println(nbr);
        int test9=p.getStockProduit()-nbr;
        System.out.println(test9);
     Order  c=new Order(Produit2.id_pModifier,nbr);
        System.out.println(c);

        if (test9>=0)         
       {cs.CreateProduitsCommand(c);
        ps.quantiteApresCommande(p, test9);
   } else {
        Alert alert = new Alert(Alert.AlertType.WARNING, " Stock insuffisant ", ButtonType.CLOSE);
        alert.show();        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Front.fxml"));

        loader.load();
        AnchorPane parentContent = loader.getRoot();
       // window = (AnchorPane) nom11.getParent().getParent();
        FrontController cont = loader.getController();
        //window.getChildren().setAll(parentContent); 

    }

    @FXML
    private void pay(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Paiement.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    }
  

  

    


