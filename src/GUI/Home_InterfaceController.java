/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Chat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ChatService;

/**
 * FXML Controller class
 *
 * @author nadee ben cheikh
 */
public class Home_InterfaceController implements Initializable {
    
   
    @FXML
    private Button btn_send_message;
    @FXML
    private TextField textfield_message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void send_message(ActionEvent event) {
        String message = textfield_message.getText();
        Chat m1 = new Chat(1,message); 
        ChatService cs = new ChatService();
        cs.SendFile(m1);
       
       
    }
    
}
