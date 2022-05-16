/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Category;
import entities.Game;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.GameService;
import services.categoryService;

/**
 * FXML Controller class
 *
 * @author fadhe
 */
public class Dashboard_GamesController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public int idgame;

    @FXML
    private TableView<Game> GameList;
    @FXML
    private TableColumn<Game, String> titleactcol;
    @FXML
    private TableColumn<Game, String> categorieactcol;
    @FXML
    private TableColumn<Game, String> dateactcol;
    @FXML
    private TableColumn<Game, String> sizeactcol;
    @FXML
    private TableColumn<Game, String> descactcol;
    @FXML
    private Label search_btn;
    @FXML
    private TextField filterField;
    @FXML
    private TextField title_g;
    @FXML
    private TextField size_g;
    @FXML
    private TextField disc_g;
    @FXML
    private ComboBox<String> cat_g;
    @FXML
    private Button Edit_btn;
    @FXML
    private Button remove_btn;
    @FXML
    private Button add_btn;
private  Timestamp timee;
    @FXML
    private Button upload_btn1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
               
                categoryService cs = new categoryService();
                ObservableList<Category> listcat = cs.afficherCat();
                 ObservableList<String> s = FXCollections.observableArrayList();
                System.out.println(listcat.toString());
                
                listcat.forEach((Cat) -> { 
                     s.add(Cat.getCategory());
                   });
                
                
 
                cat_g.setItems(s);
                
                
                GameService game = new GameService();
                GameList.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        
                        try {
                            timee =GameList.getSelectionModel().getSelectedItem().getDate();
                                    
                            System.out.println(timee);
                            idgame = game.afficherGame().get(GameList.getSelectionModel().getSelectedIndex())
                                    .getIdGame();
                            
                            title_g.setText(game.afficherGame()
                                    .get(GameList.getSelectionModel().getSelectedIndex())
                                    .getTitle());
                            
                            disc_g.setText(game.afficherGame()
                                    .get(GameList.getSelectionModel().getSelectedIndex())
                                    .getDescription());
                            
                            size_g.setText(String.valueOf(game.afficherGame()
                                    .get(GameList.getSelectionModel().getSelectedIndex())
                                    .getSize()
                            ));
                            categoryService cs = new categoryService();
                            String k= cs.afficherS( (game.afficherGame()
                                    .get(GameList.getSelectionModel().getSelectedIndex())
                                    .getCategory()) );
                            
                            cat_g.setValue(k);
                        } catch (SQLException ex) {
                            Logger.getLogger(Dashboard_GamesController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                );
                ObservableList<Game> list;
                try {
                    
                    list = game.afficherGameList();
                    System.out.println(list);
                    titleactcol.setCellValueFactory(new PropertyValueFactory<>("title"));
                    descactcol.setCellValueFactory(new PropertyValueFactory<>("description"));
                    categorieactcol.setCellValueFactory(new PropertyValueFactory<>("category"));
                    dateactcol.setCellValueFactory(new PropertyValueFactory("date"));
                    sizeactcol.setCellValueFactory(new PropertyValueFactory<>("size"));
                } catch (Exception e) {
                    Logger.getLogger(Dashboard_GamesController.class.getName()).log(Level.SEVERE, null, e);
                }
                
                GameService gs = new GameService();
                GameList.setItems(gs.afficherGameList());
                GameList.refresh();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard_GamesController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    @FXML
    private void SearchGame(MouseEvent event) {

    }

    @FXML
    private void on_on(KeyEvent event) {
    }

    private void changetoProd(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addproduit2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void ChangeToGames(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Dashboard_Games.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void EditGame(ActionEvent event) throws SQLException {
        Game a = GameList.getSelectionModel().getSelectedItem();
 categoryService cs = new categoryService();
        String p = size_g.getText();
        int size = Integer.parseInt(p);
        a.setTitle(title_g.getText());
        a.setDescription(disc_g.getText());
        a.setCategory(cs.afficher(cat_g.getValue()));
        a.setDate(timee);
     
        a.setSize(size);
       a.toString();
        GameService ss = new GameService();

        try {

            ss.modifierGame(a);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.show();
            alert.setTitle("updated !");
            alert.setContentText("updated succesfully");
            GameList.refresh();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("fail !");
            alert.setContentText("failed succesfully");

        }

        GameList.setItems(ss.afficherGameList());

    }

    @FXML
    private void RemoveGame(ActionEvent event) {
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Metyaked?");
        alert2.setHeaderText("Are you sure you want to delete this game?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            GameService as = new GameService();
            try {
                as.supprimerGame(idgame);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete");
                alert.setHeaderText(null);
                alert.setContentText(" Done!");
                alert.show();
                GameList.setItems(as.afficherGameList());
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
    private void AddGame(ActionEvent event) throws SQLException {

        String s = size_g.getText();
        int size = Integer.parseInt(s);
         categoryService cs = new categoryService();
         
       Game g = new Game(title_g.getText(),disc_g.getText(), size, cs.afficher(cat_g.getValue()),upload_btn1.getText());
        GameService gs = new GameService();
        gs.ajouterGame(g);
        try {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Done");
            alert.setContentText("Added!");
            alert.show();
            GameList.refresh();
        } catch (Exception ee) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.show();
        }
        GameList.setItems(gs.afficherGameList());

    }

    @FXML
    private void imageupload(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            
            File f = fileChooser.showOpenDialog(null);
            System.out.println(f);
            
            String newpath = "D:\\wamp64\\www\\";
            File dir = new File(newpath);
            if (!dir.exists()){
                newpath = "C:\\wamp64\\www\\";
                
            }
            
            File source = null;
            File destination = null;
            File destination2 = null;
            
            String ext = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf('.') +1);
            String namefile = getRandomStr();
            
            destination = new File (newpath+namefile+'.'+ext);
             destination2 = new File ("C:\\esplay-web-pidev-Nada-branch\\public\\images\\produits\\"+namefile+'.'+ext);
            source =new File(f.getAbsolutePath());
            String file = newpath+namefile+'.'+ext;
            Files.copy(source.toPath(), destination.toPath());
             Files.copy(source.toPath(), destination2.toPath());
            upload_btn1.setText(namefile+'.'+ext);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard_GamesController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
         public static String getRandomStr() 
    {
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz"; 
  
        StringBuilder s = new StringBuilder(7); 
  
        for (int i = 0; i < 7; i++) { 
            int index = (int)(str.length() * Math.random()); 
            s.append(str.charAt(index)); 
        } 
        return s.toString();  
    } 

    @FXML
    private void Onclick_Game(ActionEvent event) {
        
    }

    @FXML
    private void Onclick_Store(ActionEvent event) {
         FXMLLoader loder = new FXMLLoader(getClass().getResource("Addproduit2.fxml"));
                 try {
                     Parent root = loder.load();
                      upload_btn1.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
    }

    @FXML
    private void Onclick_User(ActionEvent event) {
                 FXMLLoader loder = new FXMLLoader(getClass().getResource("Admin_user.fxml"));
                 try {
                     Parent root = loder.load();
                      upload_btn1.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
       
    }

    @FXML
    private void Onclick_logout(ActionEvent event) {
                Authentification_InterfaceController.ID=0;
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Authentification_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     upload_btn1.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
       
    }

}
