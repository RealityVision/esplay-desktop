/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Games.BloackBreaker.BrickBreaker;
import Games.Tetris.Tetris;
import Games.TicTacToe.TicTacToe;
import entities.Game;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Rating;
import services.GameService;
import services.RatingController;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author fadhe
 */
public class GamplayViewController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btn_game;
    @FXML
    private Text gamename;
    @FXML
    private Text gamename1;

    @FXML
    private Rating ratingstars;

    static String gameName;
    @FXML
    private Button btn_recom;
    public static Pane gamecontainer;
    @FXML
    private Button PlayGameBtn;
    @FXML
    private Button RateBtn;
    public double r1;
    public double r2;
    public double r3;

    Connection MCN;
    PreparedStatement ste;
    private PreparedStatement pst;
    public ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gamename.setText(GameItemController.gamenameItem);
        gamename1.setText(GameItemController.gamenameItem);
        gameName = GameItemController.gamenameItem;
        MCN = MaConnexion.instconn().getcnx();

    }

    @FXML
    private void goGameInterface(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home_Interface.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void goDashboardGameInterface(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard_Games.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void PlayGame(ActionEvent event) {

        if (null != gameName) {
            switch (gameName) {
                case "Tetris":
                    try {
                        Tetris.main(new String[0]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                case "TicTacToe":
                    try {
                        TicTacToe.main(new String[0]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                case "Brick Breaker":
                    try {
                        BrickBreaker.main(new String[0]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    private void Rategame(ActionEvent event) {
        GameService gr = new GameService();
        Game a = new Game();
        JOptionPane.showMessageDialog(null, "You have rated " + gameName + " " + ratingstars.getRating());
        if (null != gameName) {
            switch (gameName) {
                case "Tetris":
                    try {
                        gr.updateRate(gameName, ratingstars.getRating());
                        System.out.println("update success " + r1);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                case "TicTacToe":
                    try {
                        gr.updateRate(gameName, ratingstars.getRating());

                        System.out.println(r2);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                case "Brick Breaker":
                    try {
                        gr.updateRate(gameName, ratingstars.getRating());

                        System.out.println(r3);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                default:
                    break;
            }
        }

    }
}
