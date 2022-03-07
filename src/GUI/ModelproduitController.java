/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class ModelproduitController implements Initializable {

    @FXML
    private ImageView label_img11;
    @FXML
    private Label label_nom11;
    @FXML
    private Label label_prix11;
    @FXML
    private Text label_desc11;
 public static int id_p;
    @FXML
    private Label label_id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       public void setData(String nom,String prix,String desc,String file,int id) throws FileNotFoundException{
           label_id.setText(Integer.toString(id));
   label_nom11.setText(nom);
   label_desc11.setText(desc);
   label_prix11.setText(prix);
   
    InputStream input = new FileInputStream(file);
        System.out.println(input +"hneee fl fct ");
        Image image = new Image(input);
        
        label_img11.setImage(image);
       
    
    }

@FXML
    
    private void handlebuttonAction(ActionEvent event) throws IOException {
        id_p=Integer.parseInt(label_id.getText());
        Parent root = FXMLLoader.load(getClass().getResource("Commander.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}

