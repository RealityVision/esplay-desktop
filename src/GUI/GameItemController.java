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
import static java.lang.Math.round;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fadhe
 */
public class GameItemController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView game_img;
    @FXML
    private Text game_label;
    @FXML
    private Label rate_game;
    @FXML
    private Button play_btn;
    @FXML
    private Text game_dscr;
    
    public static String gamenameItem;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }
    public void setData(String label, String description, Double rate, int ratenbr, String Gameimage) throws FileNotFoundException {
        game_label.setText(label);
        game_dscr.setText(description);
        double val = rate/ratenbr;
            val = val*100;
            val = (double)((int) val);
            val = val /100;
        rate_game.setText(Double.toString(val));
        
        InputStream input = new FileInputStream("C:\\wamp64\\www\\"+Gameimage);
        System.out.println(input + "hneee fl fct game cntr ");
        Image image = new Image(input);
        
        game_img.setImage(image);
        game_img.setFitHeight(200);
        game_img.setFitWidth(100);
    }

    @FXML
    private void goGameplayInterface1(ActionEvent event) throws IOException {
        
        gamenameItem= game_label.getText();
        Parent root = FXMLLoader.load(getClass().getResource("GamplayView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
