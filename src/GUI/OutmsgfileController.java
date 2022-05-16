/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author khaled
 */

public class OutmsgfileController implements Initializable {

    @FXML
    private ImageView msg_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    public void setData(String file) throws FileNotFoundException{
        
   InputStream input = new FileInputStream(file);
        System.out.println(input +"hneee fl fct out file msg");
        Image image = new Image(input);
        
        msg_image.setImage(image);
    
    }
    
}
