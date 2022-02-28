/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Order;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.OrderService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class HistoryController implements Initializable {

    ObservableList<Order> data = FXCollections.observableArrayList();
    ObservableList<Order> dataFound = FXCollections.observableArrayList();

    Tools T = new Tools();
    @FXML
    private AnchorPane holderAnchor;
    @FXML
    private TableView<Order> tableCommandes;
    @FXML
    private TableColumn<Order, Date> DateCommande;
    @FXML
    private TableColumn<Order, String> ProduitCommande;
    @FXML
    private TableColumn<Order, Integer> QuantiteProduitCommande;
    @FXML
    private TableColumn<Order, Double> PrixProduitCommande;
    @FXML
    private TableColumn<Order, Double> PrixTotalCommande;
    @FXML
    private TableColumn<Order, String> Etat;
    @FXML
    private JFXButton searchCommande;
    OrderService orderServices;
    List<Order> orderListe;
    List<Order> orderDataListe;
    @FXML
    private JFXTextField searchText;
    @FXML
    private TextArea commentaires;
    @FXML
    private TextField commentaire;
    @FXML
    private TextField quantityForSell;
    @FXML
    private TextField productPrice;
    @FXML
    private TextField productName;
    int position;
    Order selectedOrderForComment;
    @FXML
    private Label alertNotSelected;
    UserService userservice = new UserService();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderServices = new OrderService();
    
        System.out.println(orderListe);
        orderListe.forEach((order) -> {
            System.err.println(order);
        });

        data.addAll(orderListe);
        DateCommande.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        ProduitCommande.setCellValueFactory(new PropertyValueFactory<>("productName"));
        QuantiteProduitCommande.setCellValueFactory(new PropertyValueFactory<>("orderQuantity"));
        PrixProduitCommande.setCellValueFactory(new PropertyValueFactory<>("priceProduit"));
        PrixTotalCommande.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
        Etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tableCommandes.setItems(data);
        data.forEach((order) -> {
            dataFound.add(order);
        });
    }

    @FXML
    private void clickSearchCommande(ActionEvent event) {
        if ((!"".equals(searchText.getText()))) {
            dataFound.clear();

            data.stream().filter((order) -> (-1 != order.getProductName().indexOf(searchText.getText()))).forEachOrdered((order) -> {
                dataFound.add(order);
            });
            tableCommandes.setItems(dataFound);
            tableCommandes.refresh();
        } else {
            tableCommandes.setItems(data);
            tableCommandes.refresh();
        }
    }

    @FXML
    private void TextEditEnCours(KeyEvent event) {
        if ((!"".equals(searchText.getText()))) {
            dataFound.clear();

            data.stream().filter((order) -> (-1 != order.getProductName().indexOf(searchText.getText()))).forEachOrdered((order) -> {
                dataFound.add(order);
            });
            tableCommandes.setItems(dataFound);
            tableCommandes.refresh();
        } else {
            tableCommandes.setItems(data);
            tableCommandes.refresh();
        }
    }

   

    private static class Tools {

        public Tools() {
        }
    }

}
