/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit2;
import static entities.Store.filename;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ProduitService2;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class Addproduit2Controller implements Initializable {

   public String imagecomp; 
               Integer idp2; 
               int idresproduit2;
    @FXML
    private TextField txtn;
    @FXML
    private TextField txtp;
     @FXML
    private DatePicker txtda;
    @FXML
    private ImageView imagefield;
 
    @FXML
    private Button btnajouter;
    @FXML
    private TextField produit2Description;
 
    @FXML
    private ComboBox<String> produit2Categorie;
             ObservableList<String> options = FXCollections.observableArrayList(
                "1",
                "2",
                "3",
                "4",
                "5"
        );
          ;
    @FXML
    private Button upload;
    
    @FXML
    private TableView<Produit2> affichageProduit2;
    @FXML
    private TableColumn<Produit2, String> idactcol;
    @FXML
    private TableColumn<Produit2, String> nomactcol;
    @FXML
    private TableColumn<Produit2, String> descactcol;
    @FXML
    private TableColumn<Produit2, String> categorieactcol;
    @FXML
    private TableColumn<Produit2, String> dateactcol;
    @FXML
    private TableColumn<Produit2, String> prixactcol;
    
    @FXML
    private TextField filterField;
    @FXML
    private Button stat;
    @FXML
    private TableColumn<Produit2, Image> img;
    
       ObservableList<Produit2> listep = FXCollections.observableArrayList();
    
     private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection MCN;
 
    @FXML
    private Button btn_commandes;
    @FXML
    private Button supprimeractbtn;
    @FXML
    private Button modifieractbtn;
   
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
      
        produit2Categorie.setItems(options);
        
        ProduitService2 as = new ProduitService2();
        

        
                     
              affichageProduit2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                idp2 = as.liste2()
                        .get(affichageProduit2.getSelectionModel().getSelectedIndex())
                        .getIdp2();
                txtn.setText(as.liste2()
                        .get(affichageProduit2.getSelectionModel().getSelectedIndex())
                        .getNom());
                
                produit2Description.setText(as.liste2()
                        .get(affichageProduit2.getSelectionModel().getSelectedIndex())
                        .getDescription());
                
                produit2Categorie.setValue(as.liste2()
                        .get(affichageProduit2.getSelectionModel().getSelectedIndex())
                        .getCategorie()
                );
                

                
                txtp.setText(String.valueOf(as.liste2()
                        .get(affichageProduit2.getSelectionModel().getSelectedIndex()
                        ).getPrix()
                          )
                );
               
                };
          
              
         }); 
     
         ObservableList<Produit2> list;
         
        try {
            list = as.getProduit2List();
            
            img.setPrefWidth(80);
            idactcol.setCellValueFactory(new PropertyValueFactory<>("idp2"));
            nomactcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            descactcol.setCellValueFactory(new PropertyValueFactory<>("description"));
            categorieactcol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            dateactcol.setCellValueFactory(new PropertyValueFactory("date"));
            prixactcol.setCellValueFactory(new PropertyValueFactory<>("prix"));
            img.setCellValueFactory(new PropertyValueFactory<>("image"));
           DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
            
           affichageProduit2.setItems(list);

            
        } catch (SQLException ex) {
            Logger.getLogger(Addproduit2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
         ObservableList<Produit2> liste;
         try {
             liste = as.getProduit2List();
             DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
            
        FilteredList<Produit2> filteredData = new FilteredList<>(liste, b -> true);
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Produit2 -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Produit2.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (Produit2.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
				else if (String.valueOf(Produit2.getPrix()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; 
			});
		});
		
		SortedList<Produit2> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(affichageProduit2.comparatorProperty());
		
		affichageProduit2.setItems(sortedData);
        } catch (SQLException ex) {
             Logger.getLogger(Addproduit2Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
     @FXML
    private void AjouterProduit2(ActionEvent event) throws SQLException {
        
      
          String p = txtp.getText();
          int prix = Integer.parseInt(p);
          
        
          

        Produit2 a = new Produit2(txtn.getText(),produit2Description.getText(),produit2Categorie.getValue(),Date.valueOf(txtda.getValue().toString()),Produit2.filename,prix );
        
        ProduitService2 as = new ProduitService2();
        
        as.ajouterProduit2Pst(a);
        
         try {
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setContentText("Ajouté!");
                alert.show();
                
              
                
                affichageProduit2.refresh();
            } catch (Exception ee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
            }
            affichageProduit2.setItems(as.getProduit2List());
        
     }
    
    

    

   @FXML
  private void ModifierProduit2(ActionEvent event) throws SQLException {
        
        Produit2 a = affichageProduit2.getSelectionModel().getSelectedItem();
        
        String p = txtp.getText();
         int prix = Integer.parseInt(p);
         
       
        a.setNom(txtn.getText());

        a.setDescription(produit2Description.getText());
        a.setCategorie(produit2Categorie.getValue()); 
        a.setPrix(prix);
        //a.setDate(Date.valueOf(txtda.getValue().toString()));
        a.setImage(imagecomp);
        System.out.println(imagecomp);
        ProduitService2 ss = new ProduitService2();
        
        
          try {
                       
        ss.updateproduit2 (a);
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.show();
                        alert.setTitle("updated !");
                        alert.setContentText("updated succesfully");
                        affichageProduit2.refresh();

                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.show();
                        alert.setTitle("fail !");
                        alert.setContentText("failed succesfully");

                    }
       
       affichageProduit2.setItems(ss.getProduit2listnew());
    
  
  }
    @FXML
    private void SupprimerProduit2(ActionEvent event) {
                
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous vraiment supprimer ce produit ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            ProduitService2 as = new ProduitService2();
            try {
                as.deleteproduit2(idp2);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete");
                alert.setHeaderText(null);
                alert.setContentText(" Done!");
                alert.show();
               affichageProduit2.setItems(as.getProduit2List());
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
    private void uploadimg(ActionEvent event)throws FileNotFoundException, IOException {
                FileChooser f = new FileChooser();
        String img;

        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        File fc = f.showOpenDialog(null);
        if (f != null) {
            img = fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imagefield.setImage(i);
            imagecomp = fc.toString();
            System.out.println(imagecomp);
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                filename = imagecomp.substring(index + 1);
            }

            Produit2.filename = "C:\\Users\\slimd\\OneDrive\\Bureau\\esplay-desktop\\src\\assets" + filename;
            //se.sendphp(fc.getAbsolutePath());
        }
        imagefield.setFitHeight(215);
        imagefield.setFitWidth(265);

        Produit2.pathfile = fc.getAbsolutePath();
    }

    @FXML
   /* private void OnClickedStatistique(ActionEvent event) {
        try {
                   
            Parent parent = FXMLLoader.load(getClass().getResource("Piechart.fxml"));
            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image("C:\\Users\\slimd\\OneDrive\\Bureau\\esplay-desktop\\src\\assets\\logoesplay.png"));
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Addproduit2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
     private void OnClickedStatistique(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Piechart.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    @FXML
    private void OnClickedPrint(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();
       
        Node root= this.affichageProduit2;
        
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
    /* @FXML
    private void front(ActionEvent event) {
         try { 
             Parent parent = FXMLLoader.load(getClass().getResource("Front.fxml"));
            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image("C:\\Users\\slimd\\OneDrive\\Bureau\\esplay-desktop\\src\\assets\\logoesplay.png"));
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Addproduit2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    @FXML
       private void front(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Front.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
       @FXML
    private void on_on(KeyEvent event) {
     
        try {
            listep.clear();
            
            String requette = " SELECT * FROM `Produit2` WHERE Prix LIKE  '%"+ filterField.getText()+"%' OR nom LIKE  '%"+ filterField.getText()+"%' OR date LIKE  '%"+ filterField.getText()+"%' OR categorie LIKE  '%"+ filterField.getText()+"%' ";
            pst = MCN.prepareStatement(requette);
            rs = pst.executeQuery();
            
            while (rs.next()){
                listep.add(new Produit2(
                        

                        rs.getInt("idp2"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getString("categorie"),
                        rs.getDate("date"),
                        rs.getString("image"),
                        rs.getInt("prix")
                      ));
                affichageProduit2.setItems(listep);
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Addproduit2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void commandes(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("commande.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
 
}
