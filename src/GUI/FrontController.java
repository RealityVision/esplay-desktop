/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Chat;
import entities.Produit2;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;
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
    private TextField id;
    @FXML
    private VBox vbox_Prod;
    @FXML
    private ImageView label_img11;
    @FXML
    private Label label_nom11;
    @FXML
    private Label label_prix11;
    @FXML
    private Text label_desc11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProduitService2 as = new ProduitService2();
        vbox_Prod.getChildren().clear();
        
          
refresh(as.readAll());
        
                     
         
        
    }   
    @FXML
    
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
              mc.setData(p.get(i).getNom(),Integer.toString(p.get(i).getPrix()),p.get(i).getDescription(),p.get(i).getImage());
                vbox_Prod.getChildren().add(HbProd);
            } catch (IOException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
    
  
}
   

}
