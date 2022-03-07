/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import GUI.Authentification_InterfaceController;
import entities.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;

/**
 *
 * @author slimd
 */
public class OrderService {
     private Statement ste;
   private PreparedStatement pst;
   private ResultSet rs;
   
     Connection MCN;
      
    public OrderService() {
        MCN= MaConnexion.instconn().getcnx();
    }
        
 public void CreateProduitsCommand(Order c) throws SQLException {
     
 try {
            String req = "insert into commandeprod (id_acheteur,quantite,id_produit) values(1,?,?)";

  
     
             pst = MCN.prepareStatement(req);
       
            pst.setInt(1, c.getQuantiteCommandeProduit());
            pst.setInt(2,c.getIdproduit());
            
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
   public List<Order> consulterCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
