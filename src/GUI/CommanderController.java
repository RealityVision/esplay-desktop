/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.stripe.model.Review.Session;
import services.OrderService;
import entities.Order;
import services.ProduitService2;
import entities.Produit2;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class CommanderController implements Initializable {


    @FXML
    private Label nom11;
    @FXML
    private TextField quantiteInsertion;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void CommanderProd(ActionEvent event) throws SQLException, IOException {
        OrderService cs =  new OrderService();
        ProduitService2 ps =new ProduitService2();
        
              
                int nbr=Integer.parseInt(quantiteInsertion.getText());
    
        System.out.println(nbr);
        
        
       
     Order  c=new Order(ModelproduitController.id_p,nbr);
        System.out.println(c);

        if (ps.AfficherDetailProduit(ModelproduitController.id_p).getStockProduit()>=nbr)         
       {        cs.CreateProduitsCommand(c);
                ps.updateproduitstock(ModelproduitController.id_p, nbr);
                
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("Paiement.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
                     
    
   } else {
        Alert alert = new Alert(Alert.AlertType.WARNING, " Stock insuffisant ", ButtonType.CLOSE);
        alert.show();        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Front.fxml"));

        loader.load();
        AnchorPane parentContent = loader.getRoot();
       // window = (AnchorPane) nom11.getParent().getParent();
        FrontController cont = loader.getController();
        //window.getChildren().setAll(parentContent); 

    }

    @FXML
    private void pay(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Paiement.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    /* @FXML
    private void sendMail(KeyEvent event) {
        
      // Recipient's email ID needs to be mentioned.
      String to = "slim.derouiche@esprit.tn";

      // Sender's email ID needs to be mentioned
      String from = "slim.derouiche@esprit.tn";
      final String username = "slim";//change accordingly
      final String password = "\"slim.derouiche@esprit.tn";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "relay.jangosmtp.net";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "25");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

      try {
	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Set Subject: header field
	   message.setSubject("Order");
	
	   // Now set the actual message
	   message.setText("votre réservation est faite avec succées " +
		"email using JavaMailAPI ");

	   // Send message
	   Transport.send(message);

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }*/
}
    
    
  

  

    


