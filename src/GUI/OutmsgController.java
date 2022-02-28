/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class OutmsgController implements Initializable {

    @FXML
    private ImageView imageview;
    @FXML
    private Label label_msg_out;
    @FXML
    private Label label_username;
    @FXML
    private Label label_time;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(String txt,String username,Timestamp date){
   label_msg_out.setText(txt);
  
    label_username.setText(username);
    
    
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        label_time.setText(strDate);
    
    }
    
}
