/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Games.BlockBreaker.BrickBreaker;
import Games.Pinball.Pinball;
import Games.Snake.Snake;
import Games.Tetris.Tetris;
import Games.TicTacToe.TicTacToe;
import entities.Chat;
import entities.Game;
import entities.User;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Rating;
import services.ChatService;
import services.GameService;
import services.RatingController;
import services.UserService;
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
    @FXML
    private VBox vbox_chat;
    @FXML
    private Button btn_send_message;
    @FXML
    private TextField textfield_message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChatService cv= new ChatService();
        List<Chat> chats = cv.ReadChat();
     
        refresh(chats);
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
        System.out.println(" mm pas man7ebch nemchi");
        if (null != gameName) {
            switch (gameName) {
                case "Tetris":
                    try {
                        System.out.println(" mm pas man7ebch nemchi");

                        Tetris.main(new String[0]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;

                case "TicTacToe":
                    try {
                        System.out.println(" mm pas man7ebch nemchi");

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
                case "Snake":
                    try {
                        System.out.println("man7ebch nemchi");
                        Snake.main(new String[0]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                case "Pinball":
                    try {
                        System.out.println("man7ebch nemchi");

                        Pinball.main(new String[0]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                    case "Super Mario":
                    try {
                        try {
    Desktop.getDesktop().browse(new URL("http://localhost:8000/game/1/play").toURI());
} catch (Exception e) {}
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                    case "Esplay Racing":
                    try {
                      try {
    Desktop.getDesktop().browse(new URL("http://localhost:8000/game/2/play").toURI());
} catch (Exception e) {}
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;


                    case "ESPLAY Snake":
                    try {
                       try {
    Desktop.getDesktop().browse(new URL("http://localhost:8000/game/3/play").toURI());
} catch (Exception e) {}
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                    case "Minecraft":
                    try {
                       try {
    Desktop.getDesktop().browse(new URL("http://localhost:8000/game/4/play").toURI());
} catch (Exception e) {}
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                    case "Geometry Dash":
                    try {
                       try {
    Desktop.getDesktop().browse(new URL("http://localhost:8000/game/5/play").toURI());
} catch (Exception e) {}
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
                        System.out.println("update success " + ratingstars.getRating());

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                case "Pinball":
                    try {
                        gr.updateRate(gameName, ratingstars.getRating());
                        System.out.println("update success " + r1);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                    break;
                case "Snake":
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

         @FXML
    private void send_message(ActionEvent event)  {
       
            UserService us = new  UserService();
            User u = us.ReadUser(Authentification_InterfaceController.ID);
            String message = textfield_message.getText();
            Chat m1 = new Chat(Authentification_InterfaceController.ID,message);
            ChatService cs = new ChatService();
            cs.SendMessage(m1);
            textfield_message.setText(null);
            List<Chat> chats = cs.ReadChat();
         refresh(chats);
            
    }
     public void refresh(List<Chat> c) {
       vbox_chat.getChildren().clear();
             for (int i =0; i<c.size(); i++){
                 if (c.get(i).getId_user()!=Authentification_InterfaceController.ID && c.get(i).getMessage()!= null){
                     
                     try {
                         FXMLLoader fxl = new FXMLLoader();
                         fxl.setLocation(getClass().getResource("msg.fxml"));
                         HBox msgg = fxl.load();
                         MsgController mc = fxl.getController();
                         mc.setData(c.get(i).getMessage(),c.get(i).getUsername(),c.get(i).getDate_message());
                         
                         vbox_chat.getChildren().add(msgg);
                     } catch (IOException ex) {
                         Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                     }
           }else if ((c.get(i).getId_user()==Authentification_InterfaceController.ID&& c.get(i).getMessage()!= null)){
                     try {
                         FXMLLoader fxl = new FXMLLoader();
                         fxl.setLocation(getClass().getResource("outmsg.fxml"));
                         HBox msgg = fxl.load();
                         OutmsgController mc = fxl.getController();
                         mc.setData(c.get(i).getMessage(),c.get(i).getUsername(),c.get(i).getDate_message() );
                         vbox_chat.getChildren().add(msgg);
                     } catch (IOException ex) {
                         Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                     }
           }else if (c.get(i).getMessage()== null && c.get(i).getId_user()==Authentification_InterfaceController.ID){
                     try {
                         System.out.println("null message");
                         System.out.println(c.get(i).getFile());
                         FXMLLoader fxl = new FXMLLoader();
                         fxl.setLocation(getClass().getResource("outmsgfile.fxml"));
                         HBox msgg = fxl.load();
                         OutmsgfileController mc = fxl.getController();
                         System.out.println(c.get(i).getFile()+ "  kbal fnc");
                         mc.setData(c.get(i).getFile()) ;
                         vbox_chat.getChildren().add(msgg);
                     } catch (IOException ex) {
                         Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }else if (c.get(i).getMessage()== null && c.get(i).getId_user()!=Authentification_InterfaceController.ID){
                  try {
                      
                         FXMLLoader fxl = new FXMLLoader();
                         fxl.setLocation(getClass().getResource("inmsgfile.fxml"));
                         HBox msgg = fxl.load();
                         InmsgfileController mc = fxl.getController();
                         System.out.println(c.get(i).getFile()+ "  kbal fnc");
                         mc.setData(c.get(i).getFile()) ;
                         vbox_chat.getChildren().add(msgg);
                     } catch (IOException ex) {
                         Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                 
                 
                 }
             }
        
    
    
    }

   

     @FXML
     private void btn_sendfile(ActionEvent event) {
        
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
     
  
        String ext = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf('.') +1);
        String namefile = getRandomStr();
        destination = new File (newpath+namefile+'.'+ext);
     
        source =new File(f.getAbsolutePath());
        try {
            Files.copy(source.toPath(), destination.toPath());
           
            ChatService cs = new ChatService();
             String  file = newpath +namefile+'.'+ext;
             Chat c = new Chat (Authentification_InterfaceController.ID,file,null);
                cs.SendFile(c);
 
                    } catch (IOException ex) {
            Logger.getLogger(Home_InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Home_Interface.fxml"));
                 try {
                     Parent root = loder.load();
                     btn_send_message.getScene().setRoot(root);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
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
    

}
