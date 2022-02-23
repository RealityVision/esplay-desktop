/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CartProduct;
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
public class CartProductServices {
   private Statement ste;
   private PreparedStatement pst;
   private ResultSet rs;
   
     Connection MCN;
     
        
    public CartProductServices() {
        MCN= MaConnexion.instconn().getcnx();
    }
    
    public void add(CartProduct t) {
        String req = "insert into product_panier (id,id_panier,id_produit,commander) values (?,?,?,?)";
        
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, t.getIdCartProduit());
            pst.setInt(2, t.getCart().getIdCart());
            pst.setInt(3, t.getProduct().getId());
            pst.setBoolean(4, t.getCommander());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  }
    
    
    
      public void remove(CartProduct t) {
    String req = "delete from product_panier where id =?";
     
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, t.getIdCartProduit());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } }
      
      
      public CartProduct RechParId(Integer I) {
       CartProduct cartP = null;
        String req = "select * from product_panier where id=?";
       
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, I);
            rs = pst.executeQuery();
            while (rs.next()) {
                cartP = new CartProduct(rs.getBoolean(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cartP;
      }
      
       public List<CartProduct> getAll() {
      List<CartProduct> cartP = new ArrayList<>();
        String req = "select * from product_panier";
        
        try {
            pst = MCN.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                CartProduct cartPr = new CartProduct(rs.getBoolean(2));
                cartP.add(cartPr);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cartP;  }
}
