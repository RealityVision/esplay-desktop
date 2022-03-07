/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.GamplayViewController.gameName;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author fadhe
 */
public class DeveloperHubController implements Initializable {
    
     @FXML
    private Button btn_game;

    @FXML
    private Button btn_recom;
    @FXML
    private Button upload_btn;
    
    FileChooser fileChooser = new FileChooser();
    
    FileInputStream input = null;
    
    Connection myConn = null;
    PreparedStatement myStmt = null;


    

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myConn = MaConnexion.instconn().getcnx();
        // TODO
    }    

    @FXML
    private void uploadgame(ActionEvent event) throws FileNotFoundException, SQLException {

      String sql = "insert into devupload set file=?";
      myStmt = myConn.prepareStatement(sql);
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archive", "*.zip"));

      File file = fileChooser.showOpenDialog(new Stage());
      input = new FileInputStream(file);
      myStmt.setBinaryStream(1, input);
       System.out.println("Reading input file: " + file.getAbsolutePath());

            // 4. Execute statement
            System.out.println("\nStoring Game in database: " + file);
            System.out.println(sql);

            myStmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Allah y5allik w ykathem menek ennes!! A mail will be sent to our developers to analyse your project and add it to our platform! CHEERS!!");


            System.out.println("\nCompleted successfully!");
 
        
    }
    
     @FXML
    void goDashboardGameInterface(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home_Interface.fxml"));
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    

    }

    @FXML
    void goGameInterface(ActionEvent event) {

    }
    
    
}
