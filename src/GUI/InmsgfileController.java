/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.InputStream;
import java.net.URL;
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
public class InmsgfileController implements Initializable {

    
    
    @FXML
    private ImageView image_msg;
    @FXML
    private ImageView msg_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(String file){
        
   InputStream input = OutmsgfileController.class.getResourceAsStream(file);
        System.out.println(input +"hneee fl fct ");
        Image image = new Image(input);
        
        msg_image.setImage(image);
    
    }
    
}
