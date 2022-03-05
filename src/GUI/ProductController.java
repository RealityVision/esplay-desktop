/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class ProductController implements Initializable {

    @FXML
    private ComboBox<?> combobox;
    @FXML
    private TextField inputref;
    @FXML
    private TextField inputdesc;
    @FXML
    private TextField inputprix;
    @FXML
    private Button upload;
    @FXML
    private Button btnajouter;
    @FXML
    private Button modifieractbtn;
    @FXML
    private TableColumn<?, ?> img;
    @FXML
    private Button SupprimerFX;
    @FXML
    private TableView<?> affichageProd;
    @FXML
    private TableColumn<?, ?> idprodcol;
    @FXML
    private TableColumn<?, ?> refprodcol;
    @FXML
    private TableColumn<?, ?> descprodcol;
    @FXML
    private TableColumn<?, ?> prixprodcol;
    @FXML
    private TableColumn<?, ?> catprodcol;
    @FXML
    private Button imprimprod;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void front(ActionEvent event) {
    }

    @FXML
    private void AjouterImg(ActionEvent event) {
    }

    @FXML
    private void AjouterProduitFX(ActionEvent event) {
    }

    @FXML
    private void ModifierProduitFX(ActionEvent event) {
    }

    @FXML
    private void Imprimer(ActionEvent event) {
    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }
    
}
