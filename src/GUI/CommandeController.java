/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Store;
import static entities.Store.filename;
import entities.Commande;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import services.StoreService;
import services.CommandeService;
//import utils.Mailing;
import java.io.IOException;
import static java.time.zone.ZoneRulesProvider.refresh;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import utils.commailing;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class CommandeController implements Initializable {
      Integer id; 

    
    String imagecomp;
    @FXML
    private TextField storenom;
    @FXML
    private TextField descriptionstore;
    @FXML
    private TextField categoriestore;
    @FXML
    private TextField prixstore;
    private ImageView imgview;
    @FXML
    private Button uploadbtn;
    @FXML
    private TableView<Store> affichagestore;
    @FXML
    private Label imagepath;
    @FXML
    private TableColumn<Store, String> idstorecol;
    @FXML
    private TableColumn<Store, String> nomstorecol;
    @FXML
    private TableColumn<Store, String> descriptionstorecol;
    @FXML
    private TableColumn<Store, String> categoristorecol;
    @FXML
    private TableColumn<Store, String> prixstorecol;
    @FXML
    private Button modifierstorebtn;
    @FXML
    private Button supprimerstorebtn;
    @FXML
    private Button ajoutercommandebtn;
    @FXML
    private Button modifiercommandebtn;
    @FXML
    private Button supprimercommandebtn;
    @FXML
    private DatePicker datecommande;
    @FXML
    private TextField quantitecommande;
    @FXML
    private TextField prixtcommande;
    @FXML
    private TableView<Commande> affichagecommande;
    @FXML
    private TableColumn<Commande, String> idcommandecol;
    @FXML
    private TableColumn<Commande, String> quantitecommandecol;
    @FXML
    private TableColumn<Commande, String> prixtcol;
    @FXML
    private TableColumn<Commande, String> datecommandecol;
    @FXML
    private TextField textrechercher;
    StoreService pcr = new StoreService();
    @FXML
    private Button sort;
    @FXML
    private Button btnnn;

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         StoreService ss = new StoreService();
        CommandeService cs = new CommandeService(); 
        
        
        affichagecommande.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                id = cs.liste2()
                        .get(affichagecommande.getSelectionModel().getSelectedIndex())
                        .getId();
                datecommande.setValue(LocalDate.parse(cs.liste2()
                        .get(affichagecommande.getSelectionModel().getSelectedIndex())
                        .getDate()));
                
                
                prixtcommande.setText(String.valueOf(cs.liste2()
                        .get(affichagecommande.getSelectionModel()
                                .getSelectedIndex())
                        .getPrixT()
                ));
                
                  quantitecommande.setText(String.valueOf(cs.liste2()
                        .get(affichagecommande.getSelectionModel()
                                .getSelectedIndex())
                        .getQuantite()));
                };
            
               
         }); 
            
                
                  ObservableList<Commande>list;

        try {
            list = cs.getCommandeList();
            
            
            idcommandecol.setCellValueFactory(new PropertyValueFactory<>("id"));
            datecommandecol.setCellValueFactory(new PropertyValueFactory<>("date"));
            quantitecommandecol.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            prixtcol.setCellValueFactory(new PropertyValueFactory<>("Total"));

            
           affichagecommande.setItems(list);
                    
        } catch (SQLException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
                //
                
        
                     
              affichagestore.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                id = ss.liste2()
                        .get(affichagestore.getSelectionModel().getSelectedIndex())
                        .getId();
                //System.out.println(iddd);
                storenom.setText(ss.liste2()
                        .get(affichagestore.getSelectionModel().getSelectedIndex())
                        .getNom());
                
                descriptionstore.setText(ss.liste2()
                        .get(affichagestore.getSelectionModel()
                                .getSelectedIndex())
                        .getDescription());
                
                categoriestore.setText(ss.liste2()
                        .get(affichagestore.getSelectionModel()
                                .getSelectedIndex())
                        .getCategorie()
                );
                
  
              
                prixstore.setText(String.valueOf(ss.liste2()
                        .get(affichagestore.getSelectionModel()
                            .getSelectedIndex()
                        ).getPrix()
                          )
                );
                };
            
               
         }); 
       
        
         
              ObservableList<Store>list2;

        try {
            list2 = ss.getStoreListe();
        
            
            idstorecol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomstorecol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            descriptionstorecol.setCellValueFactory(new PropertyValueFactory<>("description"));
            categoristorecol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            prixstorecol.setCellValueFactory(new PropertyValueFactory<>("prix"));

            
           affichagestore.setItems(list2);
            FilteredList<Store> filteredData = new FilteredList<>(list2, b -> true);  
 textrechercher.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(message -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (message.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } 
    else if (message.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } 
    else if (String.valueOf(message.getPrix()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    }     
    
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<Store> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(affichagestore.comparatorProperty());  
  affichagestore.setItems(sortedData);      
    }   catch (SQLException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    } 

            
        

        
        
 

    @FXML
    public void ajouterstore(ActionEvent event) throws SQLException, Exception {
        
          String rp = prixstore.getText();
          int pa = Integer.parseInt(rp);
          
         

        Store s = new Store(storenom.getText(),descriptionstore.getText(),categoriestore.getText(),pa,Store.filename );
        
        StoreService ss = new StoreService();
        
        ss.ajouterstore(s);
        
         try {
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setContentText("Added!");
                alert.show();
                
              
                
                affichagestore.refresh();
            } catch (Exception ee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
            }
       ///     affichagestore.setItems(ss.getStoreListe());
        //commailing.mailing();
        
    }

    
    
    
    
    @FXML
    private void uploadimagestore(ActionEvent event) {
        
          FileChooser f = new FileChooser();
        String img;

        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        File fc = f.showOpenDialog(null);
        if (f != null) {
            img = fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imgview.setImage(i);
            imagecomp = fc.toString();
            System.out.println(imagecomp);
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                filename = imagecomp.substring(index + 1);
            }

            
            Store.filename = "C:\\Users\\slimd\\OneDrive\\Bureau\\esplay-desktop\\src\\assets" + filename;
            
        }
        imgview.setFitHeight(215);
        imgview.setFitWidth(265);
        //..\img\google.png

        //C:\Users\splin\Documents\NetBeansProjects\FanArt\\com\esprit\img
        Store.pathfile = fc.getAbsolutePath();
       
    }

    @FXML
    private void modifierstore(ActionEvent event) throws SQLException {
        
        
         Store s = affichagestore.getSelectionModel().getSelectedItem();
        
        String rp = prixstore.getText();
         int prixProd = Integer.parseInt(rp);////////////////////////

   
        s.setNom(storenom.getText());

        s.setDescription(descriptionstore.getText());
        s.setCategorie(categoriestore.getText()); 
        s.setPrix(prixProd);
        
        //a.setDate_eve(datee);
        s.setImg(imagecomp);
        System.out.println(imagecomp);
        StoreService ss = new StoreService();
        
        
          try {
                       
        ss.modifierstore(id, s.getNom(),s.getDescription(),s.getCategorie(),prixProd, Store.filename );
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.show();
                        alert.setTitle("updated !");
                        alert.setContentText("updated succesfully");

                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.show();
                        alert.setTitle("fail !");
                        alert.setContentText("failed succesfully");

                    }
       // int id, String nom, String description, int price, String category, String adresse, String img
       affichagestore.setItems(ss.getStoreListenew());
    }

    @FXML
    private void supprimerstore(ActionEvent event) {
        
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous supprimer ce produit  ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            StoreService ss = new StoreService();
            try {
                ss.supprimerstore(id);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete");
                alert.setHeaderText(null);
                alert.setContentText(" Done!");
                alert.show();
                affichagestore.setItems(ss.getStoreListe());
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Echec");
                alert.setHeaderText(null);
                alert.setContentText("Delete Failed !");
            }

        } else {
            alert2.close();
        }
    }

    @FXML
    private void ajoutercommande(ActionEvent event) throws SQLException {
    
    

         String qc = quantitecommande.getText();
          int quantitec = Integer.parseInt(qc);
          
          
           String pt = prixtcommande.getText();
          int prixt = Integer.parseInt(pt);
          
          
          
          
     String datee = datecommande.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
System.out.println(datee);
    
        Commande c = new Commande(datee,quantitec,prixt);
        
        CommandeService cs = new CommandeService();
        
            cs.ajoutercommande(c);        
        
         try {
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setContentText("Addeded!");
                alert.show();
                
              
                
                affichagestore.refresh();
            } catch (Exception ee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
            }
            affichagecommande.setItems(cs.getCommandeList());
            
    }

    @FXML
    private void modifiercommande(ActionEvent event) throws SQLException {
        
        Commande c = affichagecommande.getSelectionModel().getSelectedItem();
       
        
         String qc = quantitecommande.getText();
          int quantitec = Integer.parseInt(qc);
          
          
           String pt = prixtcommande.getText();
          int prixt = Integer.parseInt(pt);
          
          
          
          
     String datee = datecommande.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(datee);
    
        
        CommandeService cs = new CommandeService();
       c.setDate(datee);
        c.setQuantite(quantitec);

        c.setPrixT(prixt);
       
              
        
                     try {
                       
        cs.modifiercommande(id,datee,quantitec,prixt);
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.show();
                        alert.setTitle("updated !");
                        alert.setContentText("updated succesfully");

                    } 
                     catch (Exception e) 
                     {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.show();
                        alert.setTitle("fail !");
                        alert.setContentText("failed ");

                    }
          affichagecommande.setItems(cs.getCommandeListnew());

    }

    @FXML
    private void supprimercommande(ActionEvent event) {
        
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("supprimer  ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            CommandeService cs = new CommandeService();
            try {
                cs.supprimercommande(id);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete");
                alert.setHeaderText(null);
                alert.setContentText(" Done!");
                alert.show();
                affichagecommande.setItems(cs.getCommandeList());
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Echec");
                alert.setHeaderText(null);
                alert.setContentText("Delete Failed !");
            }

        } else {
            alert2.close();
        }
    }
    
    @FXML
    private void OnClickedPrint(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();
       
        Node root= this.affichagestore;
        
     if(job != null){
     job.showPrintDialog(root.getScene().getWindow()); 
     Printer printer = job.getPrinter();
     PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
     boolean success = job.printPage(pageLayout, root);
     if(success){
        job.endJob();
     }
    }
    }

    @FXML
    private void sort(ActionEvent event) {
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
