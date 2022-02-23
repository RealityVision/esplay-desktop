/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Cart;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.MaConnexion;


/**
 *
 * @author slimd
 */
public class CartService {
   private Statement ste;
   private PreparedStatement pst;
   private ResultSet rs;
   
     Connection MCN;
     
        
    public CartService() {
        MCN= MaConnexion.instconn().getcnx();
    }
      public void add(Cart t) {
    
      String req = "INSERT INTO `panier`(`id`, `id_client`) value(?,?)";
       
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, t.getIdCart());
            pst.setInt(2, t.getClient().getId_user());
            
            pst.executeUpdate();
            System.out.println("ajout succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   }
      public void update(Cart t) {
      
        String req = "update panier set id=?,id_client=? where id = ?";
        
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, t.getIdCart());
            pst.setInt(2, t.getClient().getId_user());
         
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } }
      public void supprimer(Cart t) {
       String req = "delete from panier where id =?";
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, t.getIdCart());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } }
      
         public List<Cart> affT() {
    List<Cart> cart = new ArrayList<>();
        String req = "select * from panier";
        try {
            pst = MCN.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cart cart1 = new Cart(rs.getInt("id"));
                cart.add(cart1);
            }
             System.out.println("affT succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cart;
    }
}
