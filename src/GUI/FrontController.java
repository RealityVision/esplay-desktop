/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit2;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ProduitService2;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class FrontController implements Initializable {

    @FXML
    private TableColumn<Produit2, String> idprodcol;
    @FXML
    private TableColumn<Produit2, String> nomprodcol;
    @FXML
    private TableColumn<Produit2, String> descprodcol;
    @FXML
    private TableColumn<Produit2, String> categorieprodcol;
    @FXML
    private TableColumn<Produit2, String> dateprodcol;
    @FXML
    private TableColumn<Produit2, String> prixaprodscol;
    @FXML
    private TableColumn<Produit2, Image> img;
    @FXML
    private TextField prix;
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TextField image;
    @FXML
    private TextField categorie;
    @FXML
    private TextField date;
    @FXML
    private TextField id;
    @FXML
    private TableView<Produit2> listProd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProduitService2 as = new ProduitService2();
        

        
                     
              listProd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                id .setText(String.valueOf(as.liste2()
                        .get(listProd.getSelectionModel().getSelectedIndex()
                        ).getIdp2()
                          ));
                //System.out.println(iddd);
                nom.setText(as.liste2()
                        .get(listProd.getSelectionModel().getSelectedIndex())
                        .getNom());
                
                description.setText(as.liste2()
                        .get(listProd.getSelectionModel().getSelectedIndex())
                        .getDescription());
                
                categorie.setText(as.liste2()
                        .get(listProd.getSelectionModel().getSelectedIndex())
                        .getCategorie()
                );
                
  
               date.setText(as.liste2()
                        .get(listProd.getSelectionModel().getSelectedIndex())
                        .getCategorie()
                );
                
                
                prix.setText(String.valueOf(as.liste2()
                        .get(listProd.getSelectionModel().getSelectedIndex()
                        ).getPrix()
                          )
                );
               image.setText(String.valueOf(as.liste2()
                        .get(listProd.getSelectionModel().getSelectedIndex()
                        ).getImage()
                          )
                );
                };
          
              
         }); 
     
      

         ObservableList<Produit2> list;
         
        try {
            list = as.getProduit2List();
            
            
            img.setPrefWidth(80);
            idprodcol.setCellValueFactory(new PropertyValueFactory<>("idact"));
            nomprodcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            descprodcol.setCellValueFactory(new PropertyValueFactory<>("description"));
            categorieprodcol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            dateprodcol.setCellValueFactory(new PropertyValueFactory("date"));
            prixaprodscol.setCellValueFactory(new PropertyValueFactory<>("prix"));
            img.setCellValueFactory(new PropertyValueFactory<>("image"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
            
           listProd.setItems(list);

          
            
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    @FXML

    private void handlebuttonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Paiement.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
  
}
